package noticeboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import noticeboard.entity.DTO.returnpostDataDTO;
import noticeboard.entity.freeboard.freePost;

public interface writtingRepository extends JpaRepository<freePost, Long>{
	
	@Query(value = "SELECT new noticeboard.entity.DTO.returnpostDataDTO(f.numbers , f.title , f.writer , f.posttime , f.likes , f.views) FROM freePost f")
	public List<returnpostDataDTO> getPostData();
}
