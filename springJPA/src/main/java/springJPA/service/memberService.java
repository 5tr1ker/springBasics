package springJPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springJPA.base.Member;
import springJPA.repository.memberRepository;

@Service
@Transactional // 트랜잭션 설정  외부에서 메소드 호출하면 트랜잭션을 시작하고 종료할때 커밋한다. 예외 발생시 롤백 
public class memberService {

	@Autowired
	memberRepository mRepos;
	
	//회원가입
	public String join(Member member) {
		if(CheckID(member.getID())) {
			mRepos.save(member);
			return member.getID();
		} else {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		}
	}
	
	public boolean CheckID(String ID) {
		List<Member> mb = mRepos.findMember(ID);
		if(mb.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
