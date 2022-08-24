package noticeboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import noticeboard.entity.DTO.postdataDTO;
import noticeboard.entity.DTO.returnpostDataDTO;
import noticeboard.entity.freeboard.freeTag;
import noticeboard.service.postService;

@RestController
@Controller
public class postController {
	
	@Autowired postService writtingservice;
	
	@RequestMapping(value = "/newpost" , method = RequestMethod.POST)
	public int newpost(@RequestBody postdataDTO postdata) {
		return writtingservice.writePost(postdata);
	}
	
	@RequestMapping(value = "/getfreepost" , method = RequestMethod.GET)
	public List<returnpostDataDTO> getfreepost() {
		return writtingservice.getfreePost();
	}
	
	@RequestMapping(value = "/selectpost/{postid}")
	public List<returnpostDataDTO> selectpost(@PathVariable("postid") Long postid) {
		return writtingservice.getPostViewData(postid);
	}
	
	@RequestMapping(value = "/gettag/{postid}")
	public List<freeTag> getTagCommitData(@PathVariable("postid") Long postid){
		return writtingservice.getPostTag(postid);
	}
}
