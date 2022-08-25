package noticeboard.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import noticeboard.entity.freeboard.freeCommit;
import noticeboard.repository.commitRepository;
import noticeboard.repository.postRepository;

@Service
@Transactional
public class commitService {

	@Autowired postRepository post;
	@Autowired commitRepository commit;
	
	public List<freeCommit> getCommit(Long postid) {
		return post.getCommitData(postid);
	}
	
	public void deleteCommit(Long commitid) {
		commit.delete(commitid);
	}
}
