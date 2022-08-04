package com.study.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.study.spring.base.MemberDAO;
import com.study.spring.base.MemberVO;

@Component("newInsert")
public class mainService {
	
	@Autowired
	MemberDAO dao;
	
	public void setMemberDAO(MemberDAO dao) {
		this.dao = dao;
	}

	public void newaccount(idpasswordHelper iph) {
		MemberVO mb = new MemberVO(iph.getUserId() , iph.getUserPw());
		dao.insert(mb);	
	}
}
