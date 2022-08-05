package com.study.spring.service;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class idpasswordHelper {
	
	@NotBlank(message= "{userId.notempty}")
	@Size(min = 1 , message = "{size.underachiever}")
	String userId;
	@NotEmpty(message="{userPw.notempty}")
	@Size(min = 1 , message = "{size.underachiever}")
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
