//package noticeboard.preferences;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import noticeboard.controller.postController;
//
//@RunWith(SpringJUnit4ClassRunner.class) // Spring이 제공하는 어노테이션을 사용
//@ContextConfiguration(locations = {"classpath:webAppConfig.xml" , "classpath:controllerConf.xml"}) // 스프링 설정 정보
//@Transactional // 테스트가 끝나면 강제로 롤백한다. ( 테스트 한정 ) 
//public class Test_noticeboard {
//
//	@PersistenceContext EntityManager em;
//	@Autowired postController postController;
//	@Test
//	public void 태그데이터() {
//		List<String> result = postController.getTagCommitData(18L);
//		
//		if(result.isEmpty()) {
//			System.out.println("찾을 수 없는 데이터");
//			return;
//		}
//		for(String data : result) {
//			System.out.println(data);
//		}
//	}
//}
