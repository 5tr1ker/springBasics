package noticeboard.repository.custom;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import noticeboard.entity.freeboard.freeCommit;

public class commitRepositoryImpl extends QueryDslRepositorySupport implements CustomCommitRepository {

	public commitRepositoryImpl() {
		super(freeCommit.class);
	}
}
