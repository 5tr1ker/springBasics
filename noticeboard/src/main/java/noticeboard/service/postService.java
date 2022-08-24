package noticeboard.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import noticeboard.entity.DTO.postdataDTO;
import noticeboard.entity.DTO.returnpostDataDTO;
import noticeboard.entity.freeboard.freePost;
import noticeboard.entity.freeboard.freeTag;
import noticeboard.entity.userdata.idinfo;
import noticeboard.repository.loginRepository;
import noticeboard.repository.postRepository;
import noticeboard.repository.tagRepository;

@Service
@Transactional
public class postService {

	@Autowired postRepository writting;
	@Autowired loginRepository login;
	@Autowired tagRepository tag;
	
	public int writePost(postdataDTO data) {
		Integer number = writting.getPostnumber();
		freePost fp = new freePost();
		fp.setContent(data.getPostcontent().getContent());
		fp.setTitle(data.getPostcontent().getTitle());
		fp.setPrivates(data.getPostoption().isPrivates());
		fp.setBlockcomm(data.getPostoption().isBlockcomm());
		fp.setNumbers(number + 1);
		
		// String postMode = data.getPostwritemode(); 게시판 종류
		idinfo idinfo = login.findOne(data.getIdstatus()); // 사용자 아이디
		fp.setWriter(idinfo.getId()); // 작성자
		fp.setIdinfo(idinfo); // 편의 메소드에 접근
		
		String tagData[] = data.getLabeldata(); // 태그 데이터
		for(String str : tagData) {
			freeTag ft = new freeTag(str);
			fp.addTagData(ft);
		}
		try {
			writting.save(fp);
			idinfo.addFreePost(fp);
			login.save(idinfo);
			return 0;
		} catch(Exception e) {
			return -1;
		}
	}
	
	public List<returnpostDataDTO> getfreePost() {
		List<returnpostDataDTO> result = writting.getPostData();
		return result;
	}
	
	public List<returnpostDataDTO> getPostViewData(Long postid) {
		return writting.getViewPostData(postid);
	}
	
	public List<freeTag> getPostTag(Long postid) {
		Long number = writting.getPostNumber(postid);
		freePost fp = writting.findPostTag(number);
		if(fp == null) return null;
		return fp.getFreetag();
	}

}
