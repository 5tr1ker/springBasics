package noticeboard.entity.freeboard;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class freeWhoLike {
	
	@Id @GeneratedValue
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "POST_NUMBER")
	private freepost freepost;
	
	@Column(nullable = false , length = 20)
	private String recommender;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public freepost getFreepost() {
		return freepost;
	}

	public void setFreepost(freepost freepost) {
		this.freepost = freepost;
	}

	public String getRecommender() {
		return recommender;
	}

	public void setRecommender(String recommender) {
		this.recommender = recommender;
	}


	
}
