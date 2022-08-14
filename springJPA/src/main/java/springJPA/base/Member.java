package springJPA.base;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBER")
@AttributeOverrides({
	@AttributeOverride(name = "joinTime" , column = @Column(name = "JOINDATE"))
})
public class Member extends comonData {
	
	@Id
	@Column(name = "USERID")
	private String ID;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AGENCY")
	private AgencyVO agency;
	
	@OneToMany(mappedBy = "mvo" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@Column(name = "ORDER_DATA")
	private List<OrderData> order = new ArrayList<OrderData>();
	
	@Embedded
	private userInfo userInfo;
	
	@ElementCollection
	@CollectionTable(name = "FAMILY_INFO" , joinColumns = @JoinColumn(name = "USERID"))
	private List<familyInfo> familyinfo = new ArrayList<familyInfo>();

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public AgencyVO getAgency() {
		return agency;
	}

	public void setAgency(AgencyVO agency) {
		this.agency = agency;
	}

	public List<OrderData> getOrder() {
		return order;
	}

	public void setOrder(List<OrderData> order) {
		this.order = order;
	}

	public userInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(userInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<familyInfo> getFamilyinfo() {
		return familyinfo;
	}

	public void setFamilyinfo(List<familyInfo> familyinfo) {
		this.familyinfo = familyinfo;
	}

	
}
