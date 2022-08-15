package springJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springJPA.base.Member;

public interface memberRepository extends JpaRepository<Member, String> {
}

// JpaRepository는 Save findall find를 제공하기 떄문에 삭제

/*
@Repository
public class memberRepository {

	@PersistenceContext // 엔티티 매니저 자동 주입을 도와준다.
	private EntityManager em;
	
	public void save(Member member) {
		em.persist(member);
	}
	
	public Member findone(String id) {
		return em.find(Member.class, id);
	}
	
	public List<Member> findAll() {
		return em.createQuery("select m from Member m" , Member.class).getResultList();
	}
	
	public List<Member> findMember(String id) {
		return em.createQuery("select m from Member m where m.id = :username" , Member.class).setParameter("username", id).getResultList();
	}
}
*/