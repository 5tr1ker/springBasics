package noticeboard.entity.userdata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import noticeboard.entity.freeboard.freepost;

@Entity
public class idinfo {

	@Id @Column(nullable = false , length = 20)
	private String id;
	
	@Column(name = "PASSWORD" , nullable = false , length = 45)
	private String password;
	
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date joindate;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROFILE_SETTING")
	private profileSetting profileSetting;
	
	@OneToMany(mappedBy = "idinfo" , fetch = FetchType.LAZY , cascade = CascadeType.ALL , orphanRemoval = true)
	private List<freepost> freepost = new ArrayList<freepost>();
	
	public void setProfileSetting(profileSetting profileSetting) {
		this.profileSetting = profileSetting;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public profileSetting getProfileSetting() {
		return profileSetting;
	}

	public List<freepost> getFreepost() {
		return freepost;
	}

	public void setFreepost(List<freepost> freepost) {
		this.freepost = freepost;
	}
	
	
}
