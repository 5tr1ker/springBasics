package noticeboard.entity.freeboard;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@AttributeOverrides({
	@AttributeOverride(name = "content" , column = @Column(length = 200))
})
public class freeCommit extends postBaseEntity {

	@Id @GeneratedValue
	private long id;
	
	@JsonIgnore // 데이터값만 필요하므로 제거
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POST_NUMBER" , nullable = false)
	private freePost freepost;
	
	private Long postnumber;
	private String posttype;
	
	// 생성 메소드
	static public freeCommit createCommitData(String content , String writer , Long postnumber , String posttype) {
		freeCommit fc = new freeCommit();
		fc.setContent(content);
		fc.setWriter(writer);
		fc.setPostnumber(postnumber);
		fc.setPosttype(posttype);
		return fc;
	}
	
	public freePost getFreepost() {
		return freepost;
	}

	public void setFreepost(freePost freepost) {
		this.freepost = freepost;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getPostnumber() {
		return postnumber;
	}

	public void setPostnumber(Long postnumber) {
		this.postnumber = postnumber;
	}

	public String getPosttype() {
		return posttype;
	}

	public void setPosttype(String posttype) {
		this.posttype = posttype;
	}
	
}
