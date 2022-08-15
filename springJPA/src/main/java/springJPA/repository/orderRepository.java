package springJPA.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springJPA.base.OrderData;

@Repository
@Transactional
public class orderRepository {

	@PersistenceContext
	EntityManager em;
	
	public void save(OrderData od) { 
		em.persist(od);
	}
	
	public void delete(OrderData od) {
		em.remove(od);
	}
	
	public OrderData findOne(long id) {
		return em.find(OrderData.class , id);
	}
	
//	public List<OrderData> findAll(String username) {
//		return em.createQuery("select o from ORDER o join o.mvo m on m.USERID = o.ID where m.USERID = :username" , OrderData.class).setParameter("username", username).getResultList();
//	}
}
