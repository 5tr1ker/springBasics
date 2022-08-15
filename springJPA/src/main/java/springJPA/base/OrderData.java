package springJPA.base;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "ORDER_DATA")
@SuppressWarnings("static-access")
// @IdClass(OrderId.class)
public class OrderData {
	
	@Id @GeneratedValue
	@Column(name = "ORDER_NUMBER")
	private long orderNumber; // 주문번호
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID")
	private Member mvo; // 주문 회원

	@OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@Column(name = "ORDER_NUM")
	private List<ItemData> itemvo = new ArrayList<ItemData>(); // 주문한 아이템
	
	@Enumerated
	private OrderStatus orderStat; // 주문 상태
	
	// 상품 주문 ( 생성 메소드 ) 비즈니스 모델
	public OrderData addItem(Member member , ItemData itdata) {
		OrderData od = new OrderData();
		od.setMvo(member);
		itemvo.add(itdata); // 데이터 추가
		// itdata.setOrderData(this) 코드엔 없지만.. 연관관계
		
		od.setOrderStat(orderStat.Receipt);
		return od;
	}
	
	// 주문 취소
	public void ordercancer(OrderData od) {
		if(od.getOrderStat() == OrderStatus.Receipt) {
			throw new RuntimeException("이미 배송중입니다.");
		}
		od.setOrderStat(orderStat.CANCLE);
	}
	
	public enum OrderStatus {
		Receipt , SHIPPING , CANCLE
	}
	
	
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
	public List<ItemData> getItemvo() {
		return itemvo;
	}

	public void setItemvo(List<ItemData> itemvo) {
		this.itemvo = itemvo;
	}

	public OrderStatus getOrderStat() {
		return orderStat;
	}

	public void setOrderStat(OrderStatus orderStat) {
		this.orderStat = orderStat;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}


}
