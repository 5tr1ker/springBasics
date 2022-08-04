package com.study.spring.base;

public class MemberVO {

	int num;
	String userId;
	String userPw;
	
	public MemberVO(String userId , String userPw) {
		this.userId = userId;
		this.userPw = userPw;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

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
