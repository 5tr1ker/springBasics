package com.study.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.study.spring.base.MemberDAO;
import com.study.spring.base.MemberVO;

@Component("finder")
public class findId {
	
	@Autowired
	MemberDAO dao;
	
	public void setMemberDAO(MemberDAO dao) {
		this.dao = dao;
	}

	public MemberVO findIds(String findids) {
		return dao.gets(findids);
	}

}
