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
	private long number;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POSTNUMBER")
	private freepost freepostAssociation;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TAGDATA")
	private freeTag freetagAssociation;

	public long getNumber() {
		return number;
	}

	public freepost getFreepostAssociation() {
		return freepostAssociation;
	}

	public void setFreepostAssociation(freepost freepostAssociation) {
		this.freepostAssociation = freepostAssociation;
	}

	public freeTag getFreetagAssociation() {
		return freetagAssociation;
	}

	public void setFreetagAssociation(freeTag freetagAssociation) {
		this.freetagAssociation = freetagAssociation;
	}

	public void setNumber(long number) {
		this.number = number;
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

	
}
