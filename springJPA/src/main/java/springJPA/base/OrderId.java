package springJPA.base;


import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class OrderId implements Serializable {

	private String mvo;
	private String itemvo;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderId other = (OrderId) obj;
		return Objects.equals(itemvo, other.itemvo) && Objects.equals(mvo, other.mvo);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(itemvo, mvo);
	}
	
	public OrderId() {
		
	}

	public String getMvo() {
		return mvo;
	}

	public void setMvo(String mvo) {
		this.mvo = mvo;
	}

	public String getItemvo() {
		return itemvo;
	}

	public void setItemvo(String itemvo) {
		this.itemvo = itemvo;
	}
	
	
}
