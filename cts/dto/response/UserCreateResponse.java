package com.cts.dto.response;

import com.cts.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateResponse {
    private Long userId;
    private String name;
    private String email;
    private String phone;
    private Gender gender;
    private Instant createdAt;
}