package com.study.spring.base;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="MEMBER" , uniqueConstraints = {@UniqueConstraint( // 유니크 제약조건
		name = "NAME_AGE_UNIQUE" ,
		columnNames = {"NAME" , "AGE"})
}) // 생략시 클래스 명으로 엔티티 조회 
@Access(AccessType.FIELD) // AccessType.FIELD JPA가 필드에 직접 접근한다. AccessType.PROPERTY -> Getter Setter 로 접근한다.
@AttributeOverrides({
	@AttributeOverride(name = "joinTime" , column = @Column(name= "JOIN_TIME")) ,
	@AttributeOverride(name = "position" , column = @Column(name= "POSITION"))
})
public class MemberVO extends comonData {
	
	// @GeneratedValue(strategy = GenerationType.IDENTITY)	sql이 AUTO_INCREASE 일때 사용 DB에 자동 생성된 키값을 사용
	@Id	// 기본키 ( 식별자 필드 )
	@Column(name="ID") // 해당 DB 테이블 연결
	private String userId;

	@Column(name="AGE")
	private int age; // column이 없으면 변수명으로 연결
	
	@Column(name="NUMBER") @GeneratedValue
	private int number;
	
	@Embedded	// 값 타입
	private userInfo userInfo;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "FAMILY_INFO" , joinColumns = @JoinColumn(name = "ID"))
	@AttributeOverrides({ // 같은 값이 있을 때 Attribute 로 이름을 바꿀 수 있다.
		@AttributeOverride(name = "name" , column = @Column(name = "FAMILY_NAME")) , 
		@AttributeOverride(name = "sex" , column = @Column(name = "FAMILY_SEX")) , 
		@AttributeOverride(name = "age" , column = @Column(name = "FAMILY_AGE"))
	})
	private List<familyInfo> familyInfo = new ArrayList<familyInfo>();
	
	@Column(name="NAME" , nullable = false , length = 10) // 제약조건 추가
	private String userName;
	
	@OneToMany(mappedBy = "mvo" , cascade = CascadeType.ALL)
	List<OrderData> orders = new ArrayList<OrderData>();
	
	@ManyToOne(fetch = FetchType.LAZY) // 지연 로딩
	@JoinColumn(name="Agency_Name") // 외래키가 저장될 장소
	private AgencyVO agency; // Member 다 : 1 Agency

	public List<OrderData> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderData> orders) {
		this.orders = orders;
	}

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

	public userInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(userInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<familyInfo> getFamilyInfo() {
		return familyInfo;
	}

	public void setFamilyInfo(List<familyInfo> familyInfo) {
		this.familyInfo = familyInfo;
	}

}