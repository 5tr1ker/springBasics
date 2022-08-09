package com.study.spring.program;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.study.spring.base.AgencyVO;
import com.study.spring.base.ItemVO;
import com.study.spring.base.MemberVO;
import com.study.spring.base.OrderData;
import com.study.spring.base.OrderId;

public class program {
	
	private static void logic(EntityManager em) {
		/*  1 . 데이터 등록 테스트
		String id = "id1";
		MemberVO vo = new MemberVO();
		vo.setUserId(id); // 키값 직접 할당 / 만약 sql에 AUTO_INCREMENT 를 사용한다면 제거
		vo.setUserName("상진");
		vo.setAge(23);
		
		em.persist(vo); // 데이터 등록
		vo.setUserName("상진 박!"); // 데이터 수정
		
		MemberVO finddata = em.find(MemberVO.class, id); // 데이터 조회
		System.out.println("찾은 데이터 이름 : " + finddata.getUserName() + " 나이 : " + finddata.getAge() + " 아이디 :  " + finddata.getUserId());

		List<MemberVO> mv = em.createQuery("select m from MemberVO m" , MemberVO.class).getResultList(); // 여러 데이터 조회
														// ㄴ MemberVO 는 테이블이 아닌 객체 클래스를 말한다.
		System.out.println("mv.size= " + mv.size());
		em.remove(vo);
		*/
		
		AgencyVO avo = new AgencyVO("AVANTE_CN7"); // 팀 생성
		em.persist(avo);
		AgencyVO avo2 = new AgencyVO("SONATA_DN8"); // 팀 생성2
		em.persist(avo2);
		
		MemberVO mvo = new MemberVO("id1" , "상진 박" , 23); // 팀원 1
		mvo.setAgency(avo); // 팀 설정
		em.persist(mvo);
		
		MemberVO mvo2 = new MemberVO("id2" , "진상박" , 54); // 팀원 2
		mvo2.setAgency(avo); // 팀 설정
		em.persist(mvo2);
		
		// --------------- 다대다 연관관계 -----------------------
		// -- 식별 방법 --
		ItemVO item1 = new ItemVO("Gasolin");
		item1.setOrderID("Gasolin");
		
		OrderData order = new OrderData();
		order.setMvo(mvo);
		order.setItemvo(item1);
		
		em.persist(order); // 다대다 연관 관계
		
		OrderId oid = new OrderId();
		oid.setItemvo("Gasolin"); // 다대다 데이터 찾기
		oid.setMvo("id1"); // 두개 모두 참조해야함
		
		OrderData oidFind = em.find(OrderData.class , oid);
		MemberVO mvoResult = oidFind.getMvo();
		ItemVO itemvioResult = oidFind.getItemvo();
		
		System.out.println("[다대다 연관관계 결과] 고객명 :  " + mvoResult.getUserName() + " 물품 명 :  " + itemvioResult.getItemName());
		
//		mvo2.setAgency(avo2); // 팀 수정
		
//		mvo2.setAgency(null); 연관관계 제거
//		mvo.setAgency(null);
//		em.remove(avo2); 삭제할때는 모든 연관관계를 제거해야함
		// ---- 조회 ------
		// 외래키로 Member 조회
		List<MemberVO> result = em.createQuery("select m from MemberVO m join m.agency t where t.agency=:teamname" ,MemberVO.class).setParameter("teamname", "AVANTE_CN7").getResultList();
		for (MemberVO resultvo : result) {
			System.out.println("[query] : 이름 : " + resultvo.getUserName() + " 팀 이름 : AVANTE_CN7");
		}
		
		// 외래키에 해당되느 Member 조회
		AgencyVO resultavo = em.find(AgencyVO.class , "AVANTE_CN7");
		List<MemberVO> manyavo = resultavo.getMember();
		
		for(MemberVO member : manyavo) {
			System.out.println("[query] : 이름 : " + member.getUserName() + " 팀 이름 : AVANTE_CN7");
		}
		
	}

	public static void main(String[] args) throws IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook"); // 매니저 팩토리 생성 persistence.xml 를 탐색 후 생성
		// ** 매니저 팩토리는 커넥션 풀 , 구현체등등 생성하는 비용이 크기 때문에 엔티티 매니저는 딱 한번만 생성 후 공유해야한다.
		EntityManager em = emf.createEntityManager(); // 매니저 생성
		// 엔티티 매니저는 DB에 CRUD 할 수 있는 기능을 제공한다. 커넥션 소스를 유지하면서 DB와 통신
		// ** 커넥션과 관계가 있으니 스레드간 공유 재사용 금지 (Factory는 여러 스레드가 접근해도 됨)
		EntityTransaction tx = em.getTransaction(); // 트랜잭션 생성
		
		
		try {
			tx.begin(); // 트랜잭션 시작 ( 항상 트랜잭션 안에서 데이터를 변경해야 한다. )
			logic(em);	// 비즈니스 로직 실행
			tx.commit(); // 트랜잭션 커밋 ( 데이터베이스에 값 저장 ) , 쓰기지연
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close(); // 종료 필수
		}
		
		emf.close(); // 종료 필수
	}
}