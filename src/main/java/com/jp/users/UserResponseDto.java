package com.jp.users;

import java.io.Serializable;

public class UserResponseDto implements Serializable {

	private static final long serialVersionUID = -3799551746016296438L;

	private String userId;
	private String email;
	private String password;

	public UserResponseDto() {

	}

	public UserResponseDto(String userId, String email, String password) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
