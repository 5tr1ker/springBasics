package com.study.spring.service;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class idpasswordValidator implements Validator  {

	@Override
	public boolean supports(Class<?> clazz) {
		return idpasswordHelper.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		idpasswordHelper iph = (idpasswordHelper) target;
		if(iph.getUserId() == null || iph.getUserId().trim().isEmpty()) {
			System.out.println("에러 발견함 아이디");
			errors.rejectValue("userId" , "유효하지 않는 아이디");
		}
		if(iph.getUserPw() == null || iph.getUserPw().trim().isEmpty()) {
			System.out.println("에러 발견함 비밀번호");
			errors.rejectValue("userPw" , "유효하지 않는 비밀번호");
		}
		
		// ValidationUtils.rejectIfEmpty(errors, "userId", "required");
		// ValidationUtils.rejectIfEmpty(errors, "userPw", "required");
	}

}
