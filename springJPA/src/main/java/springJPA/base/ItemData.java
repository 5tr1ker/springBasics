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
	private long Number;
	
	@Column(name = "ITEMNAME")
	private String Name;
	
	@Column(name = "COUNT")
	private int count;

	public long getNumber() {
		return Number;
	}

	public void setNumber(long number) {
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
