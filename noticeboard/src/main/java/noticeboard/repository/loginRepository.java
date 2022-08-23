package noticeboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import noticeboard.entity.userdata.idinfo;

public interface loginRepository extends JpaRepository<idinfo, String> {
}
