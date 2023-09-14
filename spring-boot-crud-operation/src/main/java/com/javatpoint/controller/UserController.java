package com.javatpoint.controller;

import com.javatpoint.model.SignInRequest;
import com.javatpoint.service.UserService;
import com.javatpoint.uti.JwtUtil; // Import your JwtUtil class
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/login")
public class UserController {
	private final UserService userService;
	private final JwtUtil jwtUtil;

	@Autowired
	public UserController(UserService userService, JwtUtil jwtUtil) {
		this.userService = userService;
		this.jwtUtil = jwtUtil;
	}

	@PostMapping("/user/signin")
	public ResponseEntity<?> register(@RequestBody SignInRequest request) {
		boolean isAuthenticated = userService.authenticateUser(request.getUsername(), request.getPassword());

		if (isAuthenticated) {
			String jwtToken = jwtUtil.generateToken(request.getUsername(), request.getPassword());

			return ResponseEntity.ok("SignIn successful. Token: " + jwtToken);
		} else {
			return ResponseEntity.badRequest().body("SignIn failed: Password is incorrect");
		}
	}
}
