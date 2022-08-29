package noticeboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import noticeboard.entity.freeboard.freeCommit;
import noticeboard.repository.custom.CustomCommitRepository;

public interface commitRepository extends JpaRepository<freeCommit, Long> , CustomCommitRepository{
	
	@Modifying(clearAutomatically = true)
	@Query("DELETE FROM freeCommit c where c.writer = :idinfo")
	public void deleteAllCommit(@Param("idinfo") String idinfo);

	@Modifying(clearAutomatically = true)
	@Query("UPDATE freeCommit p set p.writer = :changeid where p.writer = :idstatus")
	public void changeWritter(@Param("idstatus") String idstatus , @Param("changeid") String changeid);
	
	//@Query(value = "SELECT C from freeCommit C where C IN (SELECT p from freePost p where p.writer = :idstatus)" , nativeQuery=true)
	/* 내 POST에 적힌 댓글 */
	@Query(value = "SELECT C.* from freeCommit C where C.POST_NUMBER IN (SELECT p.ID_NUMBERS from freePost p where p.writer = :idstatus) order by C.id DESC" , nativeQuery = true)
	public List<freeCommit> getNotifice(@Param("idstatus")String idstatus);

}
