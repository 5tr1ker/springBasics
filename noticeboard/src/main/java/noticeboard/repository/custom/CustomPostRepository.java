package noticeboard.repository.custom;

import java.util.List;

import noticeboard.entity.DTO.returnpostDataDTO;
import noticeboard.entity.freeboard.freeCommit;
import noticeboard.entity.freeboard.freeWhoLike;

public interface CustomPostRepository {

	List<freeCommit> getCommitData(Long postid);
	List<freeWhoLike> getRecommender(Long postid, String userid);
	List<returnpostDataDTO> findPostByTagData(String tagData);
	List<returnpostDataDTO> findPostBySearch(String postContent);
	List<returnpostDataDTO> findPostBySearchAndTag(String postContent, String tagData);
}
