package com.study.spring.base;

public class MemberDTO {
	private String userId;
	private String userName;
	
	public MemberDTO() {
		
	}
	
	public MemberDTO(String userId, String userName) {
		this.userId = userId;
		this.userName = userName;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
