package com.javatpoint.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javatpoint.model.UserSignUp;
import com.javatpoint.repository.UserSignUpRepository;
import com.javatpoint.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserSignUpRepository userSignupRepository;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	public boolean authenticateUser(String username, String password) {
		UserSignUp userSignUp = userSignupRepository.findByUsername(username);
		if (userSignUp != null) {
			String hashedPassword = userSignUp.getPwd();
			return passwordEncoder.matches(password, hashedPassword);
		}
		return false;
	}

}
