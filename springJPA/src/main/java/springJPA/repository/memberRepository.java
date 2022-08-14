package springJPA.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import springJPA.base.Member;

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
