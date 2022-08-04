package com.study.spring.service;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class idpasswordHelper {
	
	@NotBlank(message = "공백은 허용하지 않습니다.")
	@Size(min = 1)
	String userId;
	@NotEmpty(message = "공백은 허용하지 않습니다.")
	@Size(min = 1)
	String userPw;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
}
