package noticeboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import noticeboard.entity.freeboard.freeCommit;
import noticeboard.service.commitService;

@RestController
@Controller
public class commitController {

	@Autowired commitService commit;
	
	@RequestMapping(value = "/getcommit/{postid}" , method = RequestMethod.GET )
	public List<freeCommit> getcommit(@PathVariable("postid") Long postid) {
		return commit.getCommit(postid);
	}
	
	@RequestMapping(value = "/deletecommit/{commitid}" , method = RequestMethod.DELETE)
	public void deletecommit(@PathVariable("commitid") Long commitid) {
		commit.deleteCommit(commitid);
	}
	
	@RequestMapping(value = "/deleteAllCommit/{idinfo}" , method = RequestMethod.DELETE)
	public void deleteAllCommit(@PathVariable("idinfo") String idinfo ) {
		commit.deleteAllCommit(idinfo);
	}
}
