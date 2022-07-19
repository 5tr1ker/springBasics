package com.dbstudy.dao;

import java.util.List;

import com.dbstudy.dto.MemberVO;

public interface MemberDAO {
	public List<MemberVO> selectMember() throws Exception;
}
