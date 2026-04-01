package com.cts.mapper;

import com.cts.dto.request.UserRequest;
import com.cts.dto.response.UserResponse;
import com.cts.entity.User;

public class UserMapper {

    public static User toEntity(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setRole(request.getRole());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setStatus(request.getStatus());
        return user;
    }

    public static UserResponse toResponse(User user) {
        if (user == null) {
            return null; // defensive check
        }
        
        UserResponse response = new UserResponse();
        response.setUserId(user.getUserId());
        response.setName(user.getName());
        response.setRole(user.getRole());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setStatus(user.getStatus());

        return response;
    }
    
    public static void updateEntity(User user, UserRequest request) {
    	user.setName(request.getName());
    	user.setRole(request.getRole());
	    user.setEmail(request.getEmail());
	    user.setPhone(request.getPhone());
	    user.setStatus(request.getStatus());

    }
    
    
}
