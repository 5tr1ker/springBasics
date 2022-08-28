package noticeboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import noticeboard.entity.userdata.profileSetting;

public interface profileRepository extends JpaRepository<profileSetting, Long>{
	
	@Query("SELECT f.idinfo_ID from idinfo f where f.id = :idinfo")
	public Long findIdByuserId(@Param("idinfo") String idinfo);

	@Query("SELECT COUNT(f) from freePost f where f.writer = :idinfo")
	public Long getTotalPost(@Param("idinfo") String idinfo);
	
	@Query("SELECT SUM(f.views) from freePost f where f.writer = :idinfo")
	public Long getPostView(@Param("idinfo") String idinfo);
	
	@Query("SELECT COUNT(f) from freeCommit f where f.writer = :idinfo")
	public Long getTotalComment(@Param("idinfo") String idinfo);
	
	@Query("SELECT I.joindate from idinfo I where I.id = :idinfo")
	public String getJoinDate(@Param("idinfo") String idinfo);
	
	@Query("SELECT p from idinfo I join I.profileSetting p where I.id = :idinfo")
	public profileSetting findprofilesettings(@Param("idinfo") String idinfo);
}
