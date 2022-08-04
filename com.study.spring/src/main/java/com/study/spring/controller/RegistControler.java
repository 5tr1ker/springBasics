package com.study.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.spring.base.MemberDAO;
import com.study.spring.base.MemberVO;
import com.study.spring.service.idpasswordHelper;

@Controller
public class RegistControler {
	
	@Autowired
	private MemberDAO dao;
	
	public void setidpasswordHelper(MemberDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value = "/confirmRegist" , method = RequestMethod.POST )
	public String confirmRegist( @Valid @ModelAttribute("formData")idpasswordHelper iph , Errors error) {
		
		if(error.hasErrors()) {
			List<FieldError> errorList = error.getFieldErrors();
			// System.out.println("에러가 존재한다 : " + error.getFieldError().getDefaultMessage());
			// System.out.println("에러가 존재한다 : " + error.getFieldErrors());
			errorList.forEach(fieldError->{
                System.out.println("bind error" + fieldError.getObjectName() + " 필드명 : "+ fieldError.getField() + " 에러명 : "+ fieldError.getDefaultMessage());
            });
			return "/WEB-INF/view/regist.jsp";
		}
		try {
			MemberVO vo = new MemberVO(iph.getUserId() , iph.getUserPw());
			dao.insert(vo);
			return "/WEB-INF/view/home.jsp";
		} catch(Exception e) {
			return "/WEB-INF/view/home.jsp";
		}
	}
	
//	@InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.setValidator(new idpasswordValidator());
//    }
	
}
