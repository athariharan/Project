package com.cts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.api.ApiResponse;
import com.cts.dto.request.ChangePasswordRequest;
import com.cts.dto.request.UserRequest;
import com.cts.dto.response.UserChangePasswordResponse;
import com.cts.dto.response.UserCreateResponse;
import com.cts.dto.response.UserDeleteResponse;
import com.cts.dto.response.UserUpdateResponse;
import com.cts.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserCreateResponse>> addUser(@RequestBody UserRequest user) {
        ApiResponse<UserCreateResponse> response = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserUpdateResponse>> updateUser(@PathVariable Long id,
                                                                       @RequestBody UserRequest req) {
        ApiResponse<UserUpdateResponse> response = userService.updateUser(id, req);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDeleteResponse>> deleteUser(@PathVariable Long id) {
        ApiResponse<UserDeleteResponse> response = userService.deleteUser(id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/change-password")
    public ResponseEntity<ApiResponse<UserChangePasswordResponse>> changePassword(
            @PathVariable Long id,
            @RequestBody ChangePasswordRequest req) {
        ApiResponse<UserChangePasswordResponse> response = userService.changePassword(id, req);
        return ResponseEntity.ok(response);
    }
}