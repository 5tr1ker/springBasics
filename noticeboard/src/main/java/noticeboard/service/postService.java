package noticeboard.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import noticeboard.entity.DTO.postdataDTO;
import noticeboard.entity.DTO.returnpostDataDTO;
import noticeboard.entity.freeboard.freeCommit;
import noticeboard.entity.freeboard.freePost;
import noticeboard.entity.freeboard.freeTag;
import noticeboard.entity.freeboard.freeWhoLike;
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
		Long number = writting.getPostnumber();
		freePost fp = new freePost();
		fp.setContent(data.getPostcontent().getContent());
		fp.setTitle(data.getPostcontent().getTitle());
		fp.setPrivates(data.getPostoption().isPrivates());
		fp.setBlockcomm(data.getPostoption().isBlockcomm());
		if(number == null) fp.setNumbers(1);
		else fp.setNumbers(number + 1);
		
		// String postMode = data.getPostwritemode(); 게시판 종류
		idinfo idinfo = login.findById(data.getIdstatus()); // 사용자 아이디
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
	
	public int AddCommit(String content , String writer , Long postid) {
		try {
			freeCommit fc = freeCommit.createCommitData(content, writer); // 댓글 내용
			Long postnum = writting.getPostNumber(postid);
			freePost fp = writting.findOne(postnum);
			fp.addFreeCommit(fc);
		
			// writting.save(fp); 이미 영속화를 저장하면 fp가 2번 저장됨
		} catch (Exception e) {
			System.out.println("Service : postService 에서 오류가 발생했습니다. : " + e);
			return -1;
		}
		return 0;
	}
	
	public int deletePost(Long Postid) {
		try {
			Long postnumber = writting.getPostNumber(Postid);
			writting.delete(postnumber);
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}
	
	public int updateLike(Long postid , String userName) {
		if(writting.getRecommender(postid , userName).isEmpty()) {
			Long postnumber = writting.getPostNumber(postid);
			freePost fp = writting.getOne(postnumber);
			fp.setLikes(fp.getLikes() + 1); // 추천 수 증가
			
			freeWhoLike wfl = freeWhoLike.makefreeWhoLike(userName, fp);
			fp.addWhoLike(wfl);
			
			return 0;
		} else {
			return -2;
		}
	}
	
	public int modifiedPost(Long postid , postdataDTO postData) {
		Long postnumber = writting.getPostNumber(postid);
		freePost fp = writting.findOne(postnumber);
		
		try {
			fp.setContent(postData.getPostcontent().getContent());
			fp.setTitle(postData.getPostcontent().getTitle());
			fp.setBlockcomm(postData.getPostoption().isBlockcomm());
			fp.setPrivates(postData.getPostoption().isPrivates());
			
			fp.getFreetag().clear();
			String TagData[] = postData.getLabeldata();
			for(String data : TagData) {
				freeTag ft = new freeTag(data);
				fp.addTagData(ft);
			}
		} catch (Exception e) {
			System.out.println("postService modifiedPost 에서 오류가 발생했습니다. " + e);
			return -1;
		}
		return 0;
	}
	
	public List<returnpostDataDTO> getfreePost() {
		List<returnpostDataDTO> result = writting.getPostData();
		return result;
	}
	
	public List<returnpostDataDTO> getPostViewData(Long postid) {
		return writting.getViewPostData(postid);
	}
	
	public List<String> getPostTag(Long postid) {
		Long number = writting.getPostNumber(postid);
		return writting.findPostTag(number);
	}

	public void updateview(Long postid) {
		Long postnumber = writting.getPostNumber(postid);
		writting.updatePostViews(postnumber);
	}
}
