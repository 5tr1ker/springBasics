package springJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springJPA.base.ItemData;

public interface itemRepository extends JpaRepository<ItemData, Integer> {
}

/*
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
*/