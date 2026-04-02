																																																																																																																																																																		package com.cts.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.cts.enums.Gender; // ← this import


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String name;
    private String email;
    private String phone;
    private Gender gender;
    private String password;
}