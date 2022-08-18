package noticeboard.entity.freeboard;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@AttributeOverrides({
	@AttributeOverride(name = "content" , column = @Column(length = 200))
})
public class freeCommit extends postBaseEntity {

	@Id @GeneratedValue
	private long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FREE_POST" , nullable = false)
	private freepost freepost;

	public freepost getFreepost() {
		return freepost;
	}

	public void setFreepost(freepost freepost) {
		this.freepost = freepost;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
