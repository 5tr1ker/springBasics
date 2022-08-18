package noticeboard.entity.freeboard;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class freeAttach {

	@Id @GeneratedValue
	private long id;
	@ManyToOne
	@JoinColumn(nullable = false)
	private freepost freepost;
	
	@Column(nullable = false , length = 30)
	private String filename;
	@Column(nullable = false , length = 40)
	private String file;
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
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
