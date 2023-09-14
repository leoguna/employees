package com.javatpoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.model.UserSignUp;
import com.javatpoint.service.UserSignUpService;

@RestController
@CrossOrigin
@RequestMapping("/api/login")
public class UserSignUpController {
	@Autowired
	UserSignUpService userSignUpService;

	@PostMapping("/signup")
	private int saveUserSignUp(@RequestBody UserSignUp userSignUp) {
		userSignUpService.saveOrUpdate(userSignUp);
		return userSignUp.getUserId();
	}

	@GetMapping("/signup/data")
	private List<UserSignUp> getAllUserSignUps() {
		return userSignUpService.getAllUserSignUps();
	}

	@GetMapping("/signup/data/{userid}")
	private UserSignUp getAllUserSignUps(@PathVariable("userid") int userid) {
		return userSignUpService.getUserSignUpById(userid);
	}

	@DeleteMapping("/signup/data-delete/{userid}")
	private void deleteUserSignUp(@PathVariable("userid") int userid) {
		userSignUpService.delete(userid);
	}

	@PutMapping("/signup/data-update")
	private UserSignUp update(@RequestBody UserSignUp userSignUp) {
		userSignUpService.saveOrUpdate(userSignUp);
		return userSignUp;
	}

	@GetMapping("/signup/names")
	private List<UserSignUp> getUserByNamePrefix(@RequestParam("prefix") String prefix) {
		return userSignUpService.getUserByNamePrefix(prefix);
	}
}
