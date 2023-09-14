package com.javatpoint.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javatpoint.model.UserSignUp;
import com.javatpoint.repository.UserSignUpRepository;
import com.javatpoint.service.UserSignUpService;

@Service
@Transactional
public class UserSignUpServiceImpl implements UserSignUpService {
	@Autowired
	UserSignUpRepository userSignUpRepository;

	public List<UserSignUp> getAllUserSignUps() {
		List<UserSignUp> userSignUp = new ArrayList<UserSignUp>();
		userSignUpRepository.findAll().forEach(userSignUp1 -> userSignUp.add(userSignUp1));
		return userSignUp;
	}

	public UserSignUp getUserSignUpById(int id) {
		return userSignUpRepository.findById(id).orElse(null);
	}

	public void saveOrUpdate(UserSignUp userSignUp) {
		userSignUpRepository.save(userSignUp);
	}

	public void delete(int id) {
		userSignUpRepository.deleteById(id);
	}

	public void update(UserSignUp userSignUp, int userid) {
		userSignUpRepository.save(userSignUp);
	}

	public List<UserSignUp> getUserByNamePrefix(String prefix) {
		return userSignUpRepository.findUsersByPrefix(prefix);
	}

}
