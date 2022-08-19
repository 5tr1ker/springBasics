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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POST_NUMBER")
	private freepost freepostAssociation;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TAGDATA")
	private freeTag freetagAssociation;

	public long getNumber() {
		return id;
	}

	public freepost getFreepostAssociation() {
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

	public freepost getFreepost() {
		return freepostAssociation;
	}

	public void setFreepost(freepost freepostAssociation) {
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

	public void setFreepostAssociation(freepost freepostAssociation) {
		this.freepostAssociation = freepostAssociation;
	}

	
}
