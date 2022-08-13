package com.study.spring.program;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.h2.command.dml.Update;

import com.mysema.query.dml.UpdateClause;
import com.mysema.query.jpa.impl.JPADeleteClause;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.jpa.impl.JPAUpdateClause;
import com.mysema.query.types.Projections;
import com.study.spring.base.AgencyVO;
import com.study.spring.base.ItemList;
import com.study.spring.base.MemberDTO;
import com.study.spring.base.MemberVO;
import com.study.spring.base.OrderData;
import com.study.spring.base.OrderId;
import com.study.spring.base.QMemberVO;
import com.study.spring.base.familyInfo;
import com.study.spring.base.userInfo;
import com.study.spring.base.item.foodItem;

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
		
		MemberVO mvo3 = new MemberVO("id3" , "주히주히" , 23); // 팀원 2
		mvo3.setAgency(avo); // 팀 설정
		em.persist(mvo3);
		
		// --------------- 다대다 연관관계 -----------------------
		// -- 식별 방법 --
		ItemList item1 = new ItemList("Gasolin");
		item1.setOrderID("Gasolin");
		
		OrderData order = new OrderData();
		order.setMvo(mvo);
		order.setItemvo(item1);
		
		em.persist(order); // 다대다 연관 관계
		
		// ----- 영속성 전이 -----
		
		ItemList il = new ItemList();
		il.setOrderID("1");
		il.setItemName("부대찌개");
		
		foodItem fi = new foodItem();
		// fi.setId(41521); @GeneratedValue 로 인해 값 삽입 시 오류 발생 detached entity passed to persist
		fi.setCalorie(800);
		fi.setCount(5);
		fi.setMaker("이층집");
		fi.setName("Unknown");
		il.setFoodit(fi); // 자동 영속성 전이
		
		em.persist(il); // fi를 자동으로 
		// em.persist(fi); 영속성 전이로 인해 생략 ( 있어도 무관 ) 
		
		ItemList findList = em.find(ItemList.class , "1");
		foodItem findResult_foodItem = findList.getFoodit();
		
		System.out.println("[영속성 전이]" + findResult_foodItem.getMaker());
		
//		---- 값 타입 ----
		mvo.setUserInfo(new userInfo("사우동" , 40 , "대학생")); // 일반 값 객체 생성
		mvo.getFamilyInfo().add(new familyInfo("김은정" , "여" , 50)); // 값 타입 컬렉션
		mvo.getFamilyInfo().add(new familyInfo("박현종" , "남" , 53));
		mvo.getFamilyInfo().add(new familyInfo("박철진" , "남" , 26));
		
		em.persist(mvo);
		
		// 조회
		MemberVO resultmvo_datatype = em.find(MemberVO.class , "id1");
		userInfo ino = resultmvo_datatype.getUserInfo();
		List<familyInfo> fif = resultmvo_datatype.getFamilyInfo();
		System.out.printf("[값 타입] 거주지 : %s , 나이 : %d , 직업 : %s\n" , ino.getAddress() , ino.getFamily() , ino.getJob());
		
		for(familyInfo fn : fif) {
			System.out.printf("[값 타입] 이름 : %s , 성별 : %s , 나이 : %d\n" , fn.getName() , fn.getSex() , fn.getAge());
		}

		// ---- QueryDSL

		
		// C:\Users\tjseo\git\springBasics\com.study.spring
		JPAQuery query = new JPAQuery(em);
		QMemberVO qmvo = QMemberVO.memberVO; // 별칭사용
		//QMemberVO qmvo = QMemberVO.memberVO; // QMember에 지정한 별칭 사용 ( 기본 인스턴트)
		//QMemberVO qmvo = new QMemberVO("m"); 직접 지정
		
		/*
		List<MemberDTO> results_DTO = query.from(qmvo).list(Projections.bean(MemberDTO.class , qmvo.userName.as("userName") , qmvo.userId.as("userId")));
		
		for(MemberDTO aa : results_DTO) {
			System.out.println("[QueryDSL] 빈 생성 id : " + aa.getUserId() + " userName : " + aa.getUserName());
		}
		*/
		JPAUpdateClause juc = new JPAUpdateClause(em , qmvo);
		long count = juc.where(qmvo.userId.eq("id3")).set(qmvo.userName , "주희").execute(); // 수정
		
		JPADeleteClause jdc = new JPADeleteClause(em, qmvo);
		long count2 = jdc.where(qmvo.userId.eq("id32")).execute();

		List<MemberVO> deleteupdateResult = query.from(qmvo).list(qmvo);
		for(MemberVO a2a2 : deleteupdateResult) {
			System.out.println("[수정 삭제 결과] 아이디 : " + a2a2.getUserId() + " 이름 : " + a2a2.getUserName());
		}
		
		// 벌크 연산
		em.createQuery("update MemberVO m set m.age = m.age + 1").executeUpdate();
		TypedQuery<MemberVO> result1 = em.createQuery("select m from MemberVO m" , MemberVO.class);
		List<MemberVO> get = result1.getResultList();
		
		em.refresh(mvo);
		for(MemberVO a2a2 : get) {
			System.out.println("[벌크 연산] 아이디 : " + a2a2.getUserId() + " 이름 : " + a2a2.getUserName() + " 나이 : " + a2a2.getAge());
		}
		
		/*
		SearchResults<MemberVO> results = query.from(qmvo).where(qmvo.userId.eq("id1")).listResults(qmvo);
		
		System.out.println("\n[QueryDSL]총 조회된 데이터 갯수 : " + results.getTotal());
		List<MemberVO> resultsmvo = results.getResults(); // 결과 반환
		
		for(MemberVO dl : resultsmvo) {
			System.out.println("[QueryDSL]"+ dl.getAge() + "살의 이름은" + dl.getUserName());
		}
		
		
		QAgencyVO qgen = QAgencyVO.agencyVO;
		*/
		// -- 조인 ----
//		List<MemberVO> joinresult = query.from(qgen).join(qgen.member , qmvo).list(qmvo);
//		
//		for(MemberVO aaww : joinresult) {
//			System.out.println("[QueryDSL 조인] 유저이름 : " + aaww.getUserName() + " 아이디 : " + aaww.getUserId());
//		}
//		
//		List<AgencyVO> joinresult2 = query.from(qgen)
//				.leftJoin(qgen.member , qmvo).fetch()
//				//.on(qmvo.userId.eq("id1"))
//				.list(qgen);
//		
//		
//		for(AgencyVO aaww : joinresult2) {
//			List<MemberVO> result_member = aaww.getMember();
//			for(MemberVO aawaa : result_member) {
//				System.out.println("[QueryDSL 조인] 아이디 : " + aawaa.getUserId() + " 이름 : " + aawaa.getUserName());
//			}
//			System.out.println("[QueryDSL 조인] 유저이름 : " + aaww.getUserId() + " 별칭 : " + aaww.getAgency());
//		}
		
		/* 서브 쿼리
		List<AgencyVO> result_sub = query
				.from(qgen)
				.where(
						qgen.agency.eq(new JPASubQuery()
								.from(qgen)
								.unique("AVANTE_CN7"))).list;
								*/
		
		// ---- 데이터 찾기 ----
		OrderId oid = new OrderId();
		oid.setItemvo("Gasolin"); // 다대다 데이터 찾기
		oid.setMvo("id1"); // 두개 모두 참조해야함
		
		OrderData oidFind = em.find(OrderData.class , oid);
		MemberVO mvoResult = oidFind.getMvo();
		ItemList itemvioResult = oidFind.getItemvo();
		
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