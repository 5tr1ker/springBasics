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
	
	@RequestMapping(value = "/register" , method = RequestMethod.POST)
	public int register(@RequestBody Map<String, String> userinfo) {
		int result = login.register(userinfo);
		return result;
	}
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public int login(@RequestBody Map<String , String> userinfo) {
		int result = login.login(userinfo);
		return result;
	}
	
	@RequestMapping(value = "/findId" , method = RequestMethod.PUT)
	public String findId(@RequestBody String userinfo) {
		String result = login.findId(userinfo);
		System.out.println(result);
		return result;
	}
}
