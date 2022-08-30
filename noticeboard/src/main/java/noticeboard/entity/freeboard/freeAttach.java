package noticeboard.entity.freeboard;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class freeAttach {

	@Id @GeneratedValue
	private long id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false , name="POST_NUMBER")
	private freePost freepost;
	
	@Column(nullable = false , length = 30)
	private String filename;
	@Column(nullable = false , length = 40)
	private String changedFile;
	@Column(nullable = false)
	private Long fileSize;
	
	// 생성 메소드
	public static freeAttach createFreeAttach(String filename , String changedFile , Long fileSize) {
		freeAttach fa = new freeAttach();
		fa.setFilename(filename);
		fa.setChangedFile(changedFile);
		fa.setFileSize(fileSize);
		return fa;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public freePost getFreepost() {
		return freepost;
	}

	public void setFreepost(freePost freepost) {
		this.freepost = freepost;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}


	public String getChangedFile() {
		return changedFile;
	}

	public void setChangedFile(String changedFile) {
		this.changedFile = changedFile;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
}
