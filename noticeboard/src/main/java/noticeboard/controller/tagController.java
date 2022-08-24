package noticeboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import noticeboard.service.tagService;

@RestController
@Controller
public class tagController {
	
	@Autowired tagService tagService;
	
	@RequestMapping(value="/getTag" , method = RequestMethod.GET)
	public List<String> getTag() {
		return tagService.getAllTag();
	}
}
