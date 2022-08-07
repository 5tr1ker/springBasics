package com.study.spring.program;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.study.spring.base.MemberVO;
import java.util.List;

public class program {
	
	private static void logic(EntityManager em) {
		String id = "id1";
		MemberVO vo = new MemberVO();
		vo.setUserId(id);
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
	}

	public static void main(String[] args) throws IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook"); // 매니저 팩토리 생성 persistence.xml 를 탐색 후 생성
		// ** 매니저 팩토리는 커넥션 풀 , 구현체등등 생성하는 비용이 크기 때문에 엔티티 매니저는 딱 한번만 생성 후 공유해야한다.
		EntityManager em = emf.createEntityManager(); // 매니저 생성
		// 엔티티 매니저는 DB에 CRUD 할 수 있는 기능을 제공한다. 커넥션 소스를 유지하면서 DB와 통신
		// ** 커넥션과 관계가 있으니 스레드간 공유 재사용 금지
		EntityTransaction tx = em.getTransaction(); // 트랜잭션 생성
		
		
		try {
			tx.begin(); // 트랜잭션 시작 ( 항상 트랜잭션 안에서 데이터를 변경해야 한다. )
			logic(em);	// 비즈니스 로직 실행
			tx.commit(); // 트랜잭션 커밋
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close(); // 종료 필수
		}
		
		emf.close(); // 종료 필수
	}
}