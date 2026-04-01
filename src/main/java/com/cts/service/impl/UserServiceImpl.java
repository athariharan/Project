package com.cts.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dto.request.UserRequest;
import com.cts.dto.response.UserResponse;
import com.cts.entity.User;
import com.cts.exception.DuplicateEmailException;
import com.cts.exception.UserNotFoundException;
import com.cts.mapper.UserMapper;
import com.cts.repository.UserRepo;
import com.cts.service.UserService;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserResponse addUser(UserRequest request) {

        if (userRepo.existsByEmail(request.getEmail())) {
            throw new DuplicateEmailException(
                    "Email already exists: " + request.getEmail()
            );
        }

        User user = UserMapper.toEntity(request);
        User savedUser = userRepo.save(user);
        return UserMapper.toResponse(savedUser);
    }

    @Override
    public List<UserResponse> getUsers() {
        return userRepo.findAll()
                .stream()
                .map(UserMapper::toResponse)
                .collect(Collectors.toList());
    }
    
    @Override
    public UserResponse updateUser(Long id, UserRequest req) throws UserNotFoundException {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        // Check if email belongs to a different user
        if (userRepo.existsByEmail(req.getEmail()) && 
            !user.getEmail().equals(req.getEmail())) {
            throw new DuplicateEmailException("Email already exists: " + req.getEmail());
        }

        UserMapper.updateEntity(user, req);
        User updatedUser = userRepo.save(user);
        return UserMapper.toResponse(updatedUser);
    }

    @Override

	public void deleteUser(Long id) throws UserNotFoundException{
	
	    if (!userRepo.existsById(id)) {
	        throw new UserNotFoundException("User not found with id: " + id);
	    }
	    userRepo.deleteById(id); 
    }
}

   


