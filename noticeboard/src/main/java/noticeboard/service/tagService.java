package noticeboard.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import noticeboard.repository.tagRepository;

@Service
@Transactional
public class tagService {
	
	@Autowired tagRepository tag;
	
	public List<String> getAllTag() {
		return tag.findAllTagData();
	}
}
