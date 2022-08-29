package noticeboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import noticeboard.entity.userdata.idinfo;

public interface loginRepository extends JpaRepository<idinfo, Long> {
	public idinfo findById(String id);

}
