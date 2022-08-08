package com.study.spring.base;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="MEMBER" , uniqueConstraints = {@UniqueConstraint( // 유니크 제약조건
		name = "NAME_AGE_UNIQUE" ,
		columnNames = {"NAME" , "AGE"})
}) // 생략시 클래스 명으로 엔티티 조회 
@Access(AccessType.FIELD) // AccessType.FIELD JPA가 필드에 직접 접근한다. AccessType.PROPERTY -> Getter Setter 로 접근한다.
public class MemberVO {

	@Column(name="AGE")
	private int age; // column이 없으면 변수명으로 연결
	
	@Column(name="NUMBER") @GeneratedValue
	private int number;
	
	// @GeneratedValue(strategy = GenerationType.IDENTITY)	sql이 AUTO_INCREASE 일때 사용 DB에 자동 생성된 키값을 사용
	@Id	// 기본키 ( 식별자 필드 )
	@Column(name="ID") // 해당 DB 테이블 연결
	private String userId;
	
	@Column(name="NAME" , nullable = false , length = 10) // 제약조건 추가
	private String userName;
	
	@Enumerated(EnumType.STRING) // 사용자의 타입 ( 사용자 , 어드민 )
	private RoleType roleType;
	
	public enum RoleType {
		ADMIN , USER
	}

	@Transient //임시로 저장되는 DB에 저장되지 않음
	private String temporary;
	
	@Temporal(TemporalType.TIMESTAMP) // 날짜를 매핑한다.
	private Date createDate; // 가입날짜
	
	@Lob	// BLOB ( String ) , CLOB ( Byte ) 속성
	private String description; // 설명
	
	@ManyToOne()
	@JoinColumn(name="Agency_Name") // 외래키가 저장될 장소
	private AgencyVO agency;
	
	
	public MemberVO(String userId , String userName , Integer age) {
		this.userId = userId;
		this.userName = userName;
		this.age = age;
	}
	
	public MemberVO(String userId , String userName) {
		this(userId , userName , 0);
	}
	
	public AgencyVO getAgency() {
		return agency;
	}

	public void setAgency(AgencyVO agency) {
		if(this.agency != null) { // 기존 연결 제거
			this.agency.getMember().remove(this);
		}
		this.agency = agency;
		agency.getMember().add(this); // 양방향 문제 해결
	}
	
	public MemberVO() {
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public String getTemporary() {
		return temporary;
	}

	public void setTemporary(String temporary) {
		this.temporary = temporary;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}