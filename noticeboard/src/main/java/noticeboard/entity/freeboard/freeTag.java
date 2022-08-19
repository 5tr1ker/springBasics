package noticeboard.entity.freeboard;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class freeTag {

	@Id @GeneratedValue
	private long id;
	
	@Column(nullable = false , length = 15)
	private String tagData;
	
	@OneToMany(mappedBy = "freepostAssociation" , fetch = FetchType.LAZY , orphanRemoval = true)
	private List<freePostTagAssociation> freepost = new ArrayList<freePostTagAssociation>();

	// 연관관계 편의 메소드
	public void addFreePost(freePostTagAssociation freepost) {
		this.freepost.add(freepost);
		freepost.setFreetag(this);
	}
	
	public String getTagData() {
		return tagData;
	}

	public void setTagData(String tagData) {
		this.tagData = tagData;
	}

	public List<freePostTagAssociation> getFreepost() {
		return freepost;
	}

	
	public void setFreepost(List<freePostTagAssociation> freepost) {
		this.freepost = freepost;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
