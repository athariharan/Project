package com.cts.entity;

//import com.cts.entity.common.enums.RecordStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "User") // quoted to avoid reserved-word collisions in some DBs
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "userId", "name", "role", "email", "phone", "status", "createdAt", "updatedAt" })

@Data					//LOMBOK not working

public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  
  @Column(name = "UserID")
  private Long userId;

  @Column(name = "Name")
  private String name;
  
  
  @Column(name="Role")
  private String role;

  @Column(name = "Email", unique = true)
  private String email;

  @Column(name = "Phone")
  private String phone;
  
  @Column(name="Status")
  private String status;  
  
  @CreationTimestamp 
  @Column(name = "Created At", nullable = false, updatable = false)
  private Instant createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", nullable = false)
  private Instant updatedAt;

  @PrePersist
  void prePersist() {
    Instant now = Instant.now();
    createdAt = now;
    updatedAt = now;
  }

  @PreUpdate
  void preUpdate() {
    updatedAt = Instant.now();
  }
  
}  