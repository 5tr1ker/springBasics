package noticeboard.entity.freeboard;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class freePostTagAssociation {
	
	@Id @GeneratedValue
	private long id;
	
	// 필수적 비식별 관계
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POST_NUMBER" , nullable = false)
	private freePost freepostAssociation;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TAGDATA" , nullable = false)
	private freeTag freetagAssociation;

	public long getNumber() {
		return id;
	}

	public freePost getFreepostAssociation() {
		return freepostAssociation;
	}

	public freeTag getFreetagAssociation() {
		return freetagAssociation;
	}

	public void setFreetagAssociation(freeTag freetagAssociation) {
		this.freetagAssociation = freetagAssociation;
	}

	public void setNumber(long number) {
		this.id = number;
	}

	public freePost getFreepost() {
		return freepostAssociation;
	}

	public void setFreepost(freePost freepostAssociation) {
		this.freepostAssociation = freepostAssociation;
	}

	public freeTag getFreetag() {
		return freetagAssociation;
	}

	public void setFreetag(freeTag freetagAssociation) {
		this.freetagAssociation = freetagAssociation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFreepostAssociation(freePost freepostAssociation) {
		this.freepostAssociation = freepostAssociation;
	}

	
}
