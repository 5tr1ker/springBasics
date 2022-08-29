package noticeboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import noticeboard.entity.freeboard.freeCommit;

public interface commitRepository extends JpaRepository<freeCommit, Long> {
	
	@Modifying(clearAutomatically = true)
	@Query("DELETE FROM freeCommit c where c.writer = :idinfo")
	public void deleteAllCommit(@Param("idinfo") String idinfo);

	@Modifying(clearAutomatically = true)
	@Query("UPDATE freeCommit p set p.writer = :changeid where p.writer = :idstatus")
	public void changeWritter(@Param("idstatus") String idstatus , @Param("changeid") String changeid);
}
