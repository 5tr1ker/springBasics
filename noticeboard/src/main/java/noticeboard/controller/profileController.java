package noticeboard.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import noticeboard.entity.DTO.profileDTO;
import noticeboard.service.profileService;

@RestController
@Controller
public class profileController {

	@Autowired profileService profileServ;
	
	@RequestMapping(value = "/profileinfo/{idinfo}" , method = RequestMethod.GET )
	public Map<String , String> profileinfo(@PathVariable("idinfo") String idinfo) {
		return profileServ.getProfile(idinfo);
	}
	
	@RequestMapping(value = "/profileupdate" , method = RequestMethod.PATCH)
	public int profileupdate(@RequestBody profileDTO data) {
		return profileServ.updateProfileData(data);
	}
}
