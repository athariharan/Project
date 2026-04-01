package com.cts.dto.response;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserResponse {

    private Long userId;
    private String name;
    private String role;
    private String email;
    private String phone;
    private String status;

    
}

