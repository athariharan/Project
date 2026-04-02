package com.cts.mapper;

import com.cts.dto.request.UserRequest;
import com.cts.dto.response.UserChangePasswordResponse;
import com.cts.dto.response.UserCreateResponse;
import com.cts.dto.response.UserDeleteResponse;
import com.cts.dto.response.UserUpdateResponse;
import com.cts.entity.User;

public class UserMapper {

    public static User toEntity(UserRequest req) {
        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPhone(req.getPhone());
        user.setGender(req.getGender());
        user.setPassword(req.getPassword());
        return user;
    }

    public static void updateEntity(User user, UserRequest req) {
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPhone(req.getPhone());
        user.setGender(req.getGender());
        user.setPassword(req.getPassword());
    }

    public static UserCreateResponse toCreateResponse(User user) {
        UserCreateResponse res = new UserCreateResponse();
        res.setUserId(user.getUserId());
        res.setName(user.getName());
        res.setEmail(user.getEmail());
        res.setPhone(user.getPhone());
        res.setGender(user.getGender());
        res.setCreatedAt(user.getCreatedAt());
        return res;
    }

    public static UserUpdateResponse toUpdateResponse(User user) {
        UserUpdateResponse res = new UserUpdateResponse();
        res.setUserId(user.getUserId());
        res.setName(user.getName());
        res.setEmail(user.getEmail());
        res.setPhone(user.getPhone());
        res.setGender(user.getGender());
        res.setUpdatedAt(user.getUpdatedAt());
        return res;
    }

    public static UserDeleteResponse toDeleteResponse(User user) {
        UserDeleteResponse res = new UserDeleteResponse();
        res.setUserId(user.getUserId());
        res.setMessage("User deleted successfully");
        return res;
    }

    public static UserChangePasswordResponse toChangePasswordResponse(User user) {
        UserChangePasswordResponse res = new UserChangePasswordResponse();
        res.setUserId(user.getUserId());
        res.setMessage("Password changed successfully");
        res.setUpdatedAt(user.getUpdatedAt());
        return res;
    }
}