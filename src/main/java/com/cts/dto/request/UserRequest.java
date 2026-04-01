package com.cts.dto.request;

//import com.cts.entity.common.enums.RecordStatus;
//import com.cityworks.common.enums.Role;
//import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String name;
    private String role;
    private String email;
    private String phone;
    private String status;
    
	
}