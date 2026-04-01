package com.cts.service;

import java.util.List;

import com.cts.dto.request.UserRequest;
import com.cts.dto.response.UserResponse;
import com.cts.exception.UserNotFoundException;

public interface UserService {

    UserResponse addUser(UserRequest request);

    List<UserResponse> getUsers();
    
    UserResponse updateUser(Long id, UserRequest req) throws UserNotFoundException;
    
    void deleteUser(Long id) throws UserNotFoundException;
}