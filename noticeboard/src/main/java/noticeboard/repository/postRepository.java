package noticeboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import noticeboard.entity.DTO.returnpostDataDTO;
import noticeboard.entity.freeboard.freePost;

public interface postRepository extends JpaRepository<freePost, Long>{
	
	@Query(value = "SELECT new noticeboard.entity.DTO.returnpostDataDTO(f.numbers , f.title , f.writer , f.posttime , f.likes , f.views) FROM freePost f order by f.numbers DESC")
	public List<returnpostDataDTO> getPostData();
	
	@Query(value = "SELECT MAX(f.numbers) FROM freePost f")
	public Integer getPostnumber();
	
	@Query(value = "SELECT new noticeboard.entity.DTO.returnpostDataDTO(f.numbers , f.title , f.writer , f.posttime , f.likes , f.views , f.content , f.blockcomm , f.privates) FROM freePost f where f.numbers = :postid")
	public List<returnpostDataDTO> getViewPostData(@Param("postid") Long postid);

	/* 글 번호 탐색  */
	@Query(value = "SELECT f.ID_numbers from freePost f where f.numbers = :postid")
	public Long getPostNumber(@Param("postid") Long postid);
	
	/* 프록시된 태그 데이터 */
	@Query("SELECT p from freePost p join fetch p.freetag where p.ID_numbers = :postid")
	public freePost findPostTag(@Param("postid") Long postid);
	
}