package springJPA.service;

import static org.junit.Assert.fail;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import springJPA.base.ItemData;
import springJPA.base.Member;
import springJPA.base.OrderData;
import springJPA.repository.memberRepository;

@RunWith(SpringJUnit4ClassRunner.class) // Spring이 제공하는 어노테이션을 사용
@ContextConfiguration(locations = "classpath:webAppConfig.xml") // 스프링 설정 정보
@Transactional // 테스트가 끝나면 강제로 롤백한다. ( 테스트 한정 ) 
public class test {

	@PersistenceContext EntityManager em;
	@Autowired memberService ms;
	@Autowired memberRepository mr;
	@Autowired orderService os;
	@Autowired itemService is;
	
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
	

	@Test
	public void 상품추가() {
		Member member = new Member();
		member.setID("박상진");
		String id = ms.join(member);
		
		Member mv = mr.findone(id);
		System.out.println("조회된 아이디: " + mv.getID());
		
		long orderid = os.order(id, "2018 BMW M5", 500);
		System.out.println("주문된 상품 번호 : " + orderid);
		
		
		OrderData ods = os.orderreview(orderid); // 상품 확인
		List<ItemData> itd = ods.getItemvo();
		
		for(ItemData dada : itd) {
			System.out.println("[상품 조회] 상품 명 : " + dada.getName() + " 상품 갯수 : " + dada.getCount());			
		}
		
		os.cancel(orderid);
		OrderData ods2 = os.orderreview(orderid);
		if(ods2 == null) System.out.println("상품이 비어있음");
		else System.out.println("상품이 있음");
	}
}
