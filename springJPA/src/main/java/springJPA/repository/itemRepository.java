package springJPA.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import springJPA.base.ItemData;

@Repository
public class itemRepository {

	@PersistenceContext
	EntityManager em;
	
	public void save(ItemData id) {
		if(id.getNumber() == null) {
			em.persist(id);
		} else {
			em.merge(id);
		}
	}
	
	public List<ItemData> findAll() {
		return em.createQuery("select i from itemdata" , ItemData.class).getResultList();
	}
	
	public ItemData finditem(String id) {
		return em.find(ItemData.class , id);
	}
}
