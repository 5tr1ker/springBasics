package com.dbstudy.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dbstudy.dao.MemberDAO;
import com.dbstudy.dto.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;

	public List<MemberVO> selectMember() throws Exception {
		return dao.selectMember();
	}
	
	

}
