package noticeboard.entity.freeboard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import noticeboard.entity.userdata.idinfo;
// 게시물 데이터
@Entity
public class freepost extends postBaseEntity {

	@Id @GeneratedValue
	@Column(name = "NUMBERS")
	private long numbers;
	@Column(nullable = false , length = 30)
	private String title;
	private int views;
	private int like;
	private boolean privates;
	private boolean blockcomm;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_INFO" , nullable = false)
	private idinfo idinfo;
	
	@OneToMany(mappedBy = "freetagAssociation" , fetch = FetchType.LAZY)
	private List<freePostTagAssociation> freetag = new ArrayList<freePostTagAssociation>();
	
	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "freepost")
	private List<freeAttach> freeAttach = new ArrayList<freeAttach>();
	
	@OneToMany(mappedBy = "freepost" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<freeCommit> freeCommit = new ArrayList<freeCommit>();
	
	@ElementCollection
	@CollectionTable(name = "FREE_RECOMMENDER" , joinColumns = @JoinColumn(name = "POSTNUMBER"))
	private Set<freeWhoLike> freewholike = new HashSet<freeWhoLike>();
	

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
	public void addTagAssociation(freePostTagAssociation association) {
		freetag.add(association);
		association.setFreepost(this);
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
		return like;
	}
	public void setLike(int like) {
		this.like = like;
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
	
	
	public List<freePostTagAssociation> getFreetag() {
		return freetag;
	}
	public void setFreetag(List<freePostTagAssociation> freetag) {
		this.freetag = freetag;
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
	public Set<freeWhoLike> getFreewholike() {
		return freewholike;
	}
	public void setFreewholike(Set<freeWhoLike> freewholike) {
		this.freewholike = freewholike;
	}
	
}
