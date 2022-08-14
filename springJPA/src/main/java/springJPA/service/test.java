package springJPA.service;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import springJPA.base.Member;
import springJPA.repository.memberRepository;

@RunWith(SpringJUnit4ClassRunner.class) // Spring이 제공하는 어노테이션을 사용
@ContextConfiguration(locations = "classpath:webAppConfig.xml") // 스프링 설정 정보
@Transactional // 테스트가 끝나면 강제로 롤백한다. ( 테스트 한정 ) 
public class test {

	@Autowired memberService ms;
	@Autowired memberRepository mr;
	
	@Test
	public void joins() throws Exception {
		Member member = new Member();
		member.setID("박상진");
		
		String saveid = ms.join(member);
		// assertEquals(member, mr.findone(saveid));
		System.out.println("값 저장!" + saveid);
	}
	
	@Test(expected = IllegalStateException.class) // 해당 에러 코드가 나와야 성공한다.
	public void testerror() throws Exception {
		
		Member a1 = new Member();
		a1.setID("박상진");
		
		Member a2 = new Member();
		a2.setID("박상진");
		
		ms.join(a1);
		ms.join(a2);
		
		fail("오류가 안났다..");
	}
}
