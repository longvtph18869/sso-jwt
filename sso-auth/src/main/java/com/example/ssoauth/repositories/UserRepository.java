package com.example.ssoauth.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ssoauth.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByUserId(String userId);
	
	Optional<User> findByEmail(String email);
	
	Boolean existsByUserId(String userId);
	
	Boolean existsByEmail(String email);
}
