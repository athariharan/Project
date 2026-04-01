package com.cts.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.dto.request.UserRequest;
import com.cts.dto.response.UserResponse;
import com.cts.service.UserService;
 
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponse addUser(@RequestBody UserRequest user) {
        return userService.addUser(user);
    }

    @GetMapping
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }
    
    @PutMapping("{id}")
    public UserResponse updateUser(@PathVariable Long id, @RequestBody UserRequest req) {
    	return userService.updateUser(id, req);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}