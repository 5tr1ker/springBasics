package com.study.spring.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="AGENCY")
public class AgencyVO {
	
//	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="POST_NUM" ,nullable = false)
//	private int postNum;
	
	@Column(name="USER_ID")
	private String userId;
	
	@Id
	@Column(name="AGENCY")
	private String agency;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date posttime;
	
	@OneToMany(mappedBy="agency") // 양방향 맵핑으로 추가 ( 상대방의 필드 값 ) 
	private List<MemberVO> member = new ArrayList<MemberVO>();
	
	public AgencyVO(String agency) {
		this.agency = agency;
	}
	
	public AgencyVO() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public Date getPosttime() {
		return posttime;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

	public List<MemberVO> getMember() {
		return member;
	}

	public void setMember(List<MemberVO> member) {
		this.member = member;
	}
	
	
}
