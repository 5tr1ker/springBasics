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

	@Column(name = "OPTION1")
	private int option1;
	
	@Column(name = "OPTION2")
	private int option2;
	
	static public profileSetting createprofileSetting() {
		profileSetting ps = new profileSetting();
		ps.setOption1(1);
		ps.setOption2(4);
		return ps;
	}
	
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

	public int getOption1() {
		return option1;
	}

	public void setOption1(int option1) {
		this.option1 = option1;
	}

	public int getOption2() {
		return option2;
	}

	public void setOption2(int option2) {
		this.option2 = option2;
	}
	
	
}
