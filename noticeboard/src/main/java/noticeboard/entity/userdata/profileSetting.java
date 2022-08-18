package noticeboard.entity.userdata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class profileSetting {
	
	@Id @GeneratedValue
	private long profileNumber;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PHONE")
	private String phone;

	

	public long getProfileNumber() {
		return profileNumber;
	}

	public void setProfileNumber(long profileNumber) {
		this.profileNumber = profileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
