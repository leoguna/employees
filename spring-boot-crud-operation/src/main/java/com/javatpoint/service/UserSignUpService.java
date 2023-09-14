package com.javatpoint.service;

import java.util.List;

import com.javatpoint.model.UserSignUp;

public interface UserSignUpService {
	public List<UserSignUp> getAllUserSignUps();

	public UserSignUp getUserSignUpById(int id);

	public void saveOrUpdate(UserSignUp userSignUp);

	public void delete(int id);

	public void update(UserSignUp userSignUp, int userid);

	public List<UserSignUp> getUserByNamePrefix(String prefix);

	//public UserSignUp authenticateUser(String username);
}
