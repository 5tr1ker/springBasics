package noticeboard.repository.custom;

import java.util.List;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import com.mysema.query.jpa.JPQLQuery;

import noticeboard.entity.freeboard.QfreeCommit;
import noticeboard.entity.freeboard.QfreePost;
import noticeboard.entity.freeboard.QfreeWhoLike;
import noticeboard.entity.freeboard.freeCommit;
import noticeboard.entity.freeboard.freePost;
import noticeboard.entity.freeboard.freeWhoLike;

public class postRepositoryImpl extends QueryDslRepositorySupport implements CustomPostRepository {

	public postRepositoryImpl() {
		super(freePost.class);
	}

	@Override
	public List<freeCommit> getCommitData(Long postid) {
		QfreePost qfp = new QfreePost("Qfreepost");
		QfreeCommit qcm = new QfreeCommit("QfreeCommit");
		
		JPQLQuery query = from(qfp);
		
		return query.distinct().join(qfp.freeCommit , qcm).where(qfp.numbers.eq(postid)).list(qcm);
	}
	
	@Override
	public List<freeWhoLike> getRecommender(Long postid , String userid) {
		QfreePost qfp = new QfreePost("p");
		QfreeWhoLike qhl = new QfreeWhoLike("f");
		
		JPQLQuery query = from(qfp);
		
		return query.join(qfp.freewholike , qhl).where(qhl.recommender.in(userid)).list(qhl);
	}
}
