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
	
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String home2() {
		return "NewFile";
	}
}
