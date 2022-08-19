package noticeboard.entity.freeboard;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@MappedSuperclass
abstract class postBaseEntity {
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date posttime;
	@Column(nullable = false , length = 1000)
	private String content;
	@Column(nullable = false , length = 20)
	private String writer;
	
	public Date getPosttime() {
		return posttime;
	}
	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	
}
