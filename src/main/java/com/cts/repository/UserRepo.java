package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
	boolean existsByEmail(String email);
}