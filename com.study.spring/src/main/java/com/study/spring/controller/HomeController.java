package com.study.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.spring.base.MemberDAO;
import com.study.spring.base.MemberVO;
import com.study.spring.service.idpasswordHelper;

@Controller
public class HomeController {
	
	@Autowired
	MemberDAO dao;
	
	public void setMemberDAO(MemberDAO dao) {
		this.dao = dao;
	}
	
	//@GetMapping("/home")
	@RequestMapping(value = "/home" , method = RequestMethod.GET)
	public String hello(Model model, @RequestParam(value="name" , required = false) String name ) {
		model.addAttribute("greeting" , "안녕하세요" + name);
		return "/WEB-INF/view/home.jsp";
	}
	
	@RequestMapping(value = "/step" , method = RequestMethod.POST)
	public String step2(HttpServletRequest request , @RequestParam(value="agree" , defaultValue = "false") Boolean agree) {
		System.out.println(agree); // request 와 같이 사용할 수 있다.
		
		String param = request.getParameter("agree"); // Form 의 값 가져오기 ( Form 의 name을 agree 로 설정해야함)
		if(param == null) {
			return "/WEB-INF/view/step2.jsp";
		}
		return "/WEB-INF/view/step1.jsp";
	}
	
	@RequestMapping(value = "/step" , method = RequestMethod.GET)
	public String step_redirect() { // Redirect GET 으로 들어오면 해당 주소로 돌아가
		return "redirect:/home.jsp";
	}
	
	@RequestMapping(value = "/regist" , method = RequestMethod.GET)
	public String regist(idpasswordHelper iph) {
		return "/WEB-INF/view/regist.jsp";
	}
	
	@RequestMapping(value="/findid" , method = RequestMethod.GET)
	public String findid(HttpServletRequest request , Model model) {
		MemberVO vo;
		String data = request.getParameter("findIdData");
		vo = dao.gets(data);
		
		System.out.println("계정찾기" + data);
		if(vo == null) {
			model.addAttribute("idData" , "찾을 수 없는 아이디");
		} else {
			model.addAttribute("idData" , vo.getUserPw());
		}
		model.addAttribute("findResult" , data);
		return "/WEB-INF/view/findid.jsp";
	}
	
	@RequestMapping(value="/deleteId" , method = RequestMethod.POST)
	public String deleteId(@RequestParam(value="userData" , defaultValue="null") String data) {
		System.out.println("계정삭제" + data);
		dao.delete(data);
		return "/WEB-INF/view/home.jsp";
	}
}
