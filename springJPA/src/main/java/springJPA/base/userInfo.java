package springJPA.base;


import java.util.Objects;

import javax.persistence.Embeddable;

// 값 타입
@Embeddable
public class userInfo {

	private String address;
	private Integer familycount;
	private String job;
	
	public userInfo(String address , Integer familycount , String job) {
		this.address = address;
		this.familycount = familycount;
		this.job = job;
	}
	
	public userInfo() {
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(address, familycount, job);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		userInfo other = (userInfo) obj;
		return Objects.equals(address, other.address) && Objects.equals(familycount, other.familycount)
				&& Objects.equals(job, other.job);
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getFamily() {
		return familycount;
	}
	public void setFamily(Integer familycount) {
		this.familycount = familycount;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
}
