package com.study.spring.controller;

import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.study.spring")
public class comonExceptionHandler {
	
	@ExceptionHandler(TypeMismatchException.class) // 잘못된 타입
	public String handleTypeMissing() {
		return "/WEB-INF/view/home.jsp";
	}
}
