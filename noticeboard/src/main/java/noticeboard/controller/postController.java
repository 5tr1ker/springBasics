package noticeboard.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import noticeboard.entity.DTO.postdataDTO;
import noticeboard.entity.DTO.returnpostDataDTO;
import noticeboard.repository.postRepository;
import noticeboard.service.postService;

@RestController
@Controller
public class postController {
	
	@Autowired postService writtingservice;
	@Autowired postRepository postRepos;
	
	@RequestMapping(value = "/newpost" , method = RequestMethod.POST)
	public int newpost(@RequestBody postdataDTO postdata) {
		return writtingservice.writePost(postdata);
	}
	
	@RequestMapping(value = "/getfreepost" , method = RequestMethod.GET)
	public List<returnpostDataDTO> getfreepost() {
		return writtingservice.getfreePost();
	}
	
	@RequestMapping(value = "/selectpost/{postid}" , method = RequestMethod.GET)
	public List<returnpostDataDTO> selectpost(@PathVariable("postid") Long postid) {
		return writtingservice.getPostViewData(postid);
	}
	
	@RequestMapping(value = "/gettag/{postid}" , method = RequestMethod.GET)
	public List<String> getTagCommitData(@PathVariable("postid") Long postid){
		return writtingservice.getPostTag(postid);
	}
	
	@RequestMapping(value = "/updateView/{postid}" , method = RequestMethod.PATCH)
	public void updateView(@PathVariable("postid") Long postid) {
		writtingservice.updateview(postid);
	}
	
	@RequestMapping(value = "/likes/{postid}" , method = RequestMethod.PATCH)
	public int updateLike(@PathVariable("postid") Long postid , @RequestBody Map<String , String> userId) {
		return writtingservice.updateLike(postid, userId.get("idstatus"));
	}
	
	@RequestMapping(value = "/addcommit" , method = RequestMethod.POST)
	public int addcommit(@RequestBody Map<String , String> postData) {
		return writtingservice.AddCommit(postData.get("data") , postData.get("writter") , Long.parseLong(postData.get("postnum")));
	}
	
	@RequestMapping(value = "/deletePost/{postid}" , method = RequestMethod.DELETE)
	public int deletePost(@PathVariable("postid") Long postid) {
		return writtingservice.deletePost(postid);
	}
	
	@RequestMapping(value = "/modifiedPost/{postid}" , method = RequestMethod.PATCH)
	public int modifiedPost(@PathVariable("postid") Long postid , @RequestBody postdataDTO postData ) {
		return writtingservice.modifiedPost(postid, postData);
	}
	
	@RequestMapping(value = "/getTagData/{tagData}" , method = RequestMethod.GET)
	public List<returnpostDataDTO> getTagData(@PathVariable("tagData") String tagData) {
		return postRepos.findPostByTagData(tagData);
	}
	
	@RequestMapping(value = "/findPostBySearch/{postContent}" , method = RequestMethod.GET)
	public List<returnpostDataDTO> findPostBySearch(@PathVariable("postContent") String postContent) {
		return postRepos.findPostBySearch(postContent);
	}
	
	@RequestMapping(value = "/findPostBySearchAndTag/{postContent}/{tagData}" , method = RequestMethod.GET)
	public List<returnpostDataDTO> findPostBySearchAndTag(@PathVariable("postContent") String postContent 
			, @PathVariable("tagData") String tagData) {
		
		return postRepos.findPostBySearchAndTag(postContent , tagData);
	}
}
