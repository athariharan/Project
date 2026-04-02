package com.cts.service;


import com.cts.api.ApiResponse;
import com.cts.dto.request.ChangePasswordRequest;
import com.cts.dto.request.UserRequest;
import com.cts.dto.response.UserChangePasswordResponse;
import com.cts.dto.response.UserCreateResponse;
import com.cts.dto.response.UserDeleteResponse;
import com.cts.dto.response.UserUpdateResponse;

public interface UserService {
    ApiResponse<UserCreateResponse> addUser(UserRequest request);
    ApiResponse<UserUpdateResponse> updateUser(Long id, UserRequest req);
    ApiResponse<UserDeleteResponse> deleteUser(Long id);
    ApiResponse<UserChangePasswordResponse> changePassword(Long id, ChangePasswordRequest req);
}