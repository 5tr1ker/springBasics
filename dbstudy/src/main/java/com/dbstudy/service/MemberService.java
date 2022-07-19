package com.dbstudy.service;

import java.util.List;

import com.dbstudy.dto.MemberVO;

public interface MemberService {
	public List<MemberVO> selectMember() throws Exception;
}
