package springJPA.base;


import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class comonData {
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date joinTime;
	
	@Lob
	private String describe;
	
	@Enumerated(EnumType.STRING)
	private position position;
	
	public enum position {
		MANAGER , USER , ADMIN
	}
}
