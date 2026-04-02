package com.cts.service.impl;

import org.springframework.stereotype.Service;

import com.cts.api.ApiResponse;
import com.cts.dto.request.ChangePasswordRequest;
import com.cts.dto.request.UserRequest;
import com.cts.dto.response.UserChangePasswordResponse;
import com.cts.dto.response.UserCreateResponse;
import com.cts.dto.response.UserDeleteResponse;
import com.cts.dto.response.UserUpdateResponse;
import com.cts.entity.User;
import com.cts.exception.DuplicateEmailException;
import com.cts.exception.InvalidPasswordException;
import com.cts.exception.PasswordMismatchException;
import com.cts.exception.UserNotFoundException;
import com.cts.mapper.UserMapper;
import com.cts.repository.UserRepo;
import com.cts.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public ApiResponse<UserCreateResponse> addUser(UserRequest request) {
        if (userRepo.existsByEmail(request.getEmail())) {
            throw new DuplicateEmailException("Email already exists: " + request.getEmail());
        }
        User user = UserMapper.toEntity(request);
        User savedUser = userRepo.save(user);
        return ApiResponse.success("User created successfully", UserMapper.toCreateResponse(savedUser));
    }

    @Override
    public ApiResponse<UserUpdateResponse> updateUser(Long id, UserRequest req) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        if (userRepo.existsByEmail(req.getEmail()) && !user.getEmail().equals(req.getEmail())) {
            throw new DuplicateEmailException("Email already exists: " + req.getEmail());
        }
        UserMapper.updateEntity(user, req);
        User updatedUser = userRepo.save(user);
        return ApiResponse.success("User updated successfully", UserMapper.toUpdateResponse(updatedUser));
    }

    @Override
    public ApiResponse<UserDeleteResponse> deleteUser(Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        userRepo.deleteById(id);
        return ApiResponse.success("User deleted successfully", UserMapper.toDeleteResponse(user));
    }

    @Override
    public ApiResponse<UserChangePasswordResponse> changePassword(Long id, ChangePasswordRequest req) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        if (!user.getPassword().equals(req.getOldPassword())) {
            throw new InvalidPasswordException("Old password is incorrect");
        }
        if (!req.getNewPassword().equals(req.getConfirmPassword())) {
            throw new PasswordMismatchException("New password and confirm password do not match");
        }
        user.setPassword(req.getNewPassword());
        User updatedUser = userRepo.save(user);
        return ApiResponse.success("Password changed successfully", UserMapper.toChangePasswordResponse(updatedUser));
    }
}