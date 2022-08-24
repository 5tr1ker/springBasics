package noticeboard.entity.freeboard;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.IntSequenceGenerator;

import noticeboard.entity.userdata.idinfo;
// 게시물 데이터
@Entity
@SequenceGenerator(name = "NUMBERS_SEQUENCE" , sequenceName = "ID_numbers" , initialValue = 1 , allocationSize = 1)
@JsonIdentityInfo(generator = IntSequenceGenerator.class , property = "id")
public class freePost extends postBaseEntity {

	@Id @GeneratedValue
	private long ID_numbers;
	
	@Column(nullable = false)
	private long numbers;
	
	@Column(nullable = false , length = 30)
	private String title;
	
	private int views;
	private int likes;
	private boolean privates;
	private boolean blockcomm;
	
	@JsonIgnore // JSON response 에서 제외
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_INFO" , nullable = false)
	private idinfo idinfo;

	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "TAG_DATA")
	private List<freeTag> freetag = new ArrayList<freeTag>();

	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "freepost" , orphanRemoval = true)
	private List<freeAttach> freeAttach = new ArrayList<freeAttach>();

	@OneToMany(mappedBy = "freepost" , fetch = FetchType.LAZY , cascade = CascadeType.ALL , orphanRemoval = true)
	private List<freeCommit> freeCommit = new ArrayList<freeCommit>();

	@OneToMany(mappedBy = "freepost" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<freeWhoLike> freewholike = new ArrayList<freeWhoLike>();

	
	// 연관관계 편의 메소드 시작
	public void setIdinfo(idinfo idinfo) {
		if(this.idinfo != null) {
			this.idinfo.getFreepost().remove(this);
		}
		this.idinfo = idinfo;
		idinfo.getFreepost().add(this);
	}
	
	public void addFreeAttach(freeAttach attach) {
		freeAttach.add(attach);
		attach.setFreepost(this);
	}
	public void addFreeCommit(freeCommit commit) {
		freeCommit.add(commit);
		commit.setFreepost(this);
	}
	public void addTagData(freeTag tags) {
		freetag.add(tags);
		tags.getFreepost().add(this);
	}
	public void addWhoLike(freeWhoLike wholike) {
		freewholike.add(wholike);
		wholike.setFreepost(this);
	}
	// 연관관계 편의 메소드 종료
	
	public long getNumbers() {
		return numbers;
	}
	public void setNumbers(long numbers) {
		this.numbers = numbers;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getLike() {
		return likes;
	}
	public void setLike(int likes) {
		this.likes = likes;
	}
	public boolean isPrivates() {
		return privates;
	}
	public void setPrivates(boolean privates) {
		this.privates = privates;
	}
	public boolean isBlockcomm() {
		return blockcomm;
	}
	public void setBlockcomm(boolean blockcomm) {
		this.blockcomm = blockcomm;
	}
	public idinfo getIdinfo() {
		return idinfo;
	}
	public List<freeAttach> getFreeAttach() {
		return freeAttach;
	}
	public void setFreeAttach(List<freeAttach> freeAttach) {
		this.freeAttach = freeAttach;
	}
	public List<freeCommit> getFreeCommit() {
		return freeCommit;
	}
	public void setFreeCommit(List<freeCommit> freeCommit) {
		this.freeCommit = freeCommit;
	}

	public List<freeWhoLike> getFreewholike() {
		return freewholike;
	}
	public void setFreewholike(List<freeWhoLike> wholike) {
		this.freewholike = wholike;
	}

	public List<freeTag> getFreetag() {
		return freetag;
	}

	public void setFreetag(List<freeTag> freetag) {
		this.freetag = freetag;
	}

	public long getID_numbers() {
		return ID_numbers;
	}

	public void setID_numbers(long iD_numbers) {
		ID_numbers = iD_numbers;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
	

}
