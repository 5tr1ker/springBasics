package noticeboard.entity.freeboard;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class freeTag {

	@Id @GeneratedValue
	private long id;
	
	@Column(nullable = false , length = 15)
	private String tagData;
	
	@ManyToMany(mappedBy = "freetag")
	private List<freePost> freepost = new ArrayList<freePost>();
	
	// 연관관계 편의 메소드
	public void addFreePost(freePost freepost) {
		this.freepost.add(freepost);
		freepost.getFreetag().add(this);
	}
	
	public freeTag(String tagData) {
		this.tagData = tagData;
	}
	
	public freeTag() {
		
	}
	
	public String getTagData() {
		return tagData;
	}

	public void setTagData(String tagData) {
		this.tagData = tagData;
	}
	public List<freePost> getFreepost() {
		return freepost;
	}

	public void setFreepost(List<freePost> freepost) {
		this.freepost = freepost;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
