package com.study.spring.base;

import javax.persistence.*;

@Entity
@Table(name="MEMBER") // 생략시 클래스 명으로 엔티티 조회
public class MemberVO {

	@Column(name="AGE")
	private Integer age; // column이 없으면 변수명으로 연결
	
	@Id	// 기본키 ( 식별자 필드 )
	@Column(name="ID") // 해당 DB 테이블 연결
	private String userId;
	
	@Column(name="NAME")
	private String userName;
	
	public MemberVO(String userId , String userName , Integer age) {
		this.userId = userId;
		this.userName = userName;
		this.age = age;
	}
	
	public MemberVO(String userId , String userName) {
		this(userId , userName , 0);
	}
	
	public MemberVO() {
	}

	public int getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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



//public class MemberVO {
//
//	private int age;
//	private String userId;
//	private String userPw;
//	
//	public MemberVO(String userId , String userPw , int age) {
//		this.userId = userId;
//		this.userPw = userPw;
//		this.age = age;
//	}
//	
//	public MemberVO(String userId , String userPw) {
//		this(userId , userPw , 0);
//	}
//	
//	public int getAum() {
//		return age;
//	}
//	public void setAum(int age) {
//		this.age = age;
//	}
//
//	public String getUserId() {
//		return userId;
//	}
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
//	public String getUserPw() {
//		return userPw;
//	}
//	public void setUserPw(String userPw) {
//		this.userPw = userPw;
//	}
//}

