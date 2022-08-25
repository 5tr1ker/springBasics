package noticeboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import noticeboard.entity.DTO.returnpostDataDTO;
import noticeboard.entity.freeboard.freePost;
import noticeboard.repository.custom.CustomPostRepository;

public interface postRepository extends JpaRepository<freePost, Long> , CustomPostRepository {
	
	/*
	 * QueryDSL 로 구현된 몇가지 파일이 있습니다. ( CustomPostRepository )
	 * Commit 가져오기.
	 * WhoLike 명단.
	 */
	
	@Query(value = "SELECT new noticeboard.entity.DTO.returnpostDataDTO(f.numbers , f.title , f.writer , f.posttime , f.likes , f.views) FROM freePost f order by f.numbers DESC")
	public List<returnpostDataDTO> getPostData();
	
	/* Post 번호 증감식 */
	@Query(value = "SELECT MAX(f.numbers) FROM freePost f")
	public Long getPostnumber();
	
	@Query(value = "SELECT new noticeboard.entity.DTO.returnpostDataDTO(f.numbers , f.title , f.writer , f.posttime , f.likes , f.views , f.content , f.blockcomm , f.privates) FROM freePost f where f.numbers = :postid")
	public List<returnpostDataDTO> getViewPostData(@Param("postid") Long postid);

	/* 글 번호 탐색  */
	@Query(value = "SELECT f.ID_numbers from freePost f where f.numbers = :postid")
	public Long getPostNumber(@Param("postid") Long postid);
	
	/* 프록시된 태그 데이터 */
	@Query("SELECT f.tagData from freePost p join p.freetag f where p.ID_numbers = :postid")
	public List<String> findPostTag(@Param("postid") Long postid);
	
	/* Post 조회수 1 증가 */
	@Modifying(clearAutomatically = true) // 영속성 컨텍스트 초기화
	@Query("UPDATE freePost p set p.views = p.views + 1 where p.ID_numbers = :postid")
	public Integer updatePostViews(@Param("postid") Long postid);
}