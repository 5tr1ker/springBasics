package noticeboard.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import noticeboard.entity.userdata.profileSetting;
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
	
	@RequestMapping(value = "/iddelete/{idinfo}" , method = RequestMethod.DELETE)
	public int iddelete(@PathVariable("idinfo") String userinfo) {
		int result = login.remove(userinfo);
		return result;
	}
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public int login(@RequestBody Map<String , String> userinfo) {
		int result = login.login(userinfo);
		return result;
	}
	
	@RequestMapping(value = "/findId" , method = RequestMethod.POST)
	public String findId(@RequestBody Map<String , String> userinfo) {
		String result = login.findId(userinfo);
		System.out.println(result);
		return result;
	}
	
	@RequestMapping(value = "/getprofiledata/{id}" , method = RequestMethod.GET)
	public profileSetting getprofiledata(@PathVariable("id") String id) {
		profileSetting ps = login.getProfile(id);
		return ps;
	}
}
