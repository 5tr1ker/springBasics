package noticeboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class test {

	@RequestMapping(value = "/home" , method = RequestMethod.GET)
	public String home() {
		return "NewFile";
	}
	
	@RequestMapping(value = "/")
	public String home2() {
		System.out.println("home2 에 대한 요청");
		return "NewFile";
	}
}
