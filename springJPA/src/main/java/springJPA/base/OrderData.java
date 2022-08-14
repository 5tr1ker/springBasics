package springJPA.base;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
// @IdClass(OrderId.class)
public class OrderData {
	
	@Id
	@Column(name = "ORDER_NUMBER")
	private long orderNumber;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID")
	private Member mvo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_NUM") // 각 키 값
	private ItemData itemvo;
	
	public OrderData(int ordernumber) {
		this.orderNumber = ordernumber;
	}
	
	public OrderData() {
		
	}

	public Member getMvo() {
		return mvo;
	}
	
	public long getOrderNumber() {
		return this.orderNumber;
	}

	// 연관관계 메소드
	public void setMvo(Member mvo) {
		this.mvo = mvo;
		mvo.getOrder().add(this);
	}

	public ItemData getItemvo() {
		return itemvo;
	}

	public void setItemvo(ItemData itemvo) {
		this.itemvo = itemvo;
	}

}
