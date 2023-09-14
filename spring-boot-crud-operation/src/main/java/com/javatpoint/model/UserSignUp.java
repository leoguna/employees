package com.javatpoint.model;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Component
@Table(name = "user_signup")
public class UserSignUp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@NotNull
	@Size(max = 255)
	private String username;

	@NotNull
	@Email
	@Size(max = 255)
	private String email;

	@NotNull
	@Size(min = 10, max = 15)
	private String phoneno;

	@NotNull
	@Size(min = 8, max = 255)
	private String pwd;

	@NotNull
	@Size(max = 255)
	private String firstname;

	@Size(max = 255)
	private String lastname;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

//	public void setPwd(String pwd) {
//		this.pwd = pwd;
//	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String encryptPassword) {
		this.pwd = BCrypt.hashpw(encryptPassword, BCrypt.gensalt());
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
