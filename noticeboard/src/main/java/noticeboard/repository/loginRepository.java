package noticeboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import noticeboard.entity.userdata.idinfo;

public interface loginRepository extends JpaRepository<idinfo, Long> {
	public idinfo findById(String id);
	
	@Modifying(clearAutomatically = true)
	@Query("DELETE FROM idinfo f where f.id = :userid")
	public void deleteByUserId(@Param("userid") String userid);
	

}
