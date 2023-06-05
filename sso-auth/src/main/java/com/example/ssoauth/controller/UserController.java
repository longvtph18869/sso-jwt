package com.example.ssoauth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
	@GetMapping("/me")
	public ResponseEntity<?> getCurrentUser(Authentication authentication) {
	    String username = authentication.getName();
	    return ResponseEntity.ok(new UserResponse(username));
	}
	 public static class UserResponse {
	        private String username;

	        public UserResponse(String username) {
	            this.username = username;
	        }

	        public String getUsername() {
	            return username;
	        }

	        public void setUsername(String username) {
	            this.username = username;
	        }
	    }
}
