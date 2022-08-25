package noticeboard.repository.custom;

import java.util.List;

import noticeboard.entity.freeboard.freeCommit;
import noticeboard.entity.freeboard.freeWhoLike;

public interface CustomPostRepository {

	List<freeCommit> getCommitData(Long postid);
	List<freeWhoLike> getRecommender(Long postid, String userid);

}
