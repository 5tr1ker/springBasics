package noticeboard.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import noticeboard.service.loginService;

@RestController
@Controller
public class loginController {

	@Autowired loginService login;
	
	@RequestMapping(value ="/test" , method = RequestMethod.GET)
	public String test() {
		return "Test Data";
	}
	
	@RequestMapping(value = "/register" , method = RequestMethod.POST)
	public int register(@RequestBody Map<String, String> userinfo) {
		System.out.println(userinfo.toString());
		int result = login.register(userinfo);
		return result;
	}
}
