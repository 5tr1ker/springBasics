package springJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springJPA.base.OrderData;

public interface orderRepository extends JpaRepository<OrderData, Long>{
	
}
/*
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
*/