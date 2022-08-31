package noticeboard.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.io.ByteStreams;

import noticeboard.entity.DTO.postdataDTO;
import noticeboard.entity.DTO.returnpostDataDTO;
import noticeboard.entity.freeboard.freeAttach;
import noticeboard.repository.postRepository;
import noticeboard.service.attachManager;
import noticeboard.service.postService;

@RestController
@Controller
public class postController {
	
	@Autowired postService writtingservice;
	@Autowired postRepository postRepos;
	@Autowired attachManager attach;
	
	@RequestMapping(value = "/newpost" , method = RequestMethod.POST)
	public HashMap<String, Long> newpost(@RequestBody postdataDTO postdata) {
		return writtingservice.writePost(postdata);
	}
	
	@RequestMapping(value = "/uploadData/{postnumber}" , method = RequestMethod.POST)
	public void upload(@RequestPart(value = "file" , required = true) List<MultipartFile> file , @PathVariable("postnumber")Long postnumber) {
		attach.upload(file , postnumber);
	}
	
//	@RequestMapping(value = "/modifieduploadData/{postnumber}" , method = RequestMethod.POST)
//	public void modifieduploadData(@RequestPart List<MultipartFile> file , @PathVariable("postnumber")Long postnumber) {
//		attach.modifiedupload(file , postnumber);
//	}
	
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
	
	@RequestMapping(value = "/getattach/{postid}" , method = RequestMethod.GET)
	public List<freeAttach> getattach(@PathVariable("postid") Long postid) {
		return postRepos.getAttachment(postid);
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
		return writtingservice.AddCommit(postData.get("data") , postData.get("writter") , Long.parseLong(postData.get("postnum")) , Long.parseLong(postData.get("postNumber")) , postData.get("posttype") );
	}
	
	@RequestMapping(value = "/deletePost/{postid}" , method = RequestMethod.DELETE)
	public int deletePost(@PathVariable("postid") Long postid) {
		return writtingservice.deletePost(postid);
	}
	
	@RequestMapping(value = "/modifiedPost/{postid}" , method = RequestMethod.PATCH)
	public int modifiedPost(@PathVariable("postid") Long postid , @RequestBody postdataDTO postData ) {
		attach.modifiedupload(postData.getDeletedfilelist() , postid);
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
	
	@RequestMapping(value = "/onDownload/{fileName}" , method = RequestMethod.GET)
	public void onDownload(@PathVariable("fileName") String fileName , HttpServletResponse response) throws IOException {

		String realName = postRepos.getFileName(fileName);
		String extend = realName.substring(realName.lastIndexOf('.') , realName.length());
		System.out.println(realName + "\n약 : " + extend);
		
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ";");
		response.setContentType("text/plain");
		
		File down_file = new File("C:\\notice\\file\\" + fileName + extend); //파일 생성
	    FileInputStream fileIn = new FileInputStream(down_file); //파일 읽어오기
	    ByteStreams.copy(fileIn, response.getOutputStream());
	    response.flushBuffer();
	}
}
