package springJPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springJPA.base.ItemData;
import springJPA.repository.itemRepository;

@Service
@Transactional
public class itemService {

	@Autowired
	itemRepository irs;
	
	public void saveItem(ItemData id) {
		irs.save(id);
	}
	
	public ItemData finditem(String id) {
		return irs.finditem(id);
	}
	
	public List<ItemData> findAll() {
		return irs.findAll();
	}
}
