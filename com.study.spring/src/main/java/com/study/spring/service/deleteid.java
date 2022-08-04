package com.study.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.study.spring.base.MemberDAO;

@Component("delID")
public class deleteid {

	@Autowired
	MemberDAO dao;
	
	public void setMemberDAO(MemberDAO dao) {
		this.dao = dao;
	}
	
	public void deletedID(String ids) {
		dao.delete(ids);
	}
	
}
