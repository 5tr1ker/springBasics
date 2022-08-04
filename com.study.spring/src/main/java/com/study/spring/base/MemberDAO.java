package com.study.spring.base;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class MemberDAO {
	
	HashMap<String, MemberVO> map = new HashMap<String, MemberVO>();
	
	public void insert(MemberVO mv) {
		map.put(mv.getUserId() , mv);
	}
	
	public void delete(String id) {
		map.remove(id);
	}
	
	public MemberVO gets(String id) {
		return map.get(id);
	}
}