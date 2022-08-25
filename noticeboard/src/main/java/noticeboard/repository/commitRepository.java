package noticeboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import noticeboard.entity.freeboard.freeCommit;

public interface commitRepository extends JpaRepository<freeCommit, Long> {
	
}
