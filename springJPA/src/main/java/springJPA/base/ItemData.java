package springJPA.base;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITEMDATA")
public class ItemData {

	@Id @GeneratedValue
	@Column(name = "ITEMNUMBER")
	private Integer Number;
	
	@Column(name = "ITEMNAME")
	private String Name;
	
	@Column(name = "COUNT")
	private int count;
	
	// 생성 메소드 
	public static ItemData createitem(String name , int count) {
		ItemData id = new ItemData();
		id.setName(name);
		id.setCount(count);
		return id;
	}

	public Integer getNumber() {
		return Number;
	}

	public void setNumber(Integer number) {
		Number = number;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
