package com.study.spring.base;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(OrderId.class)
public class OrderData {
	
	@Id @ManyToOne 
	@JoinColumn(name = "ID")
	private MemberVO mvo;

	@Id @ManyToOne
	@JoinColumn(name = "ORDER_NUM") // 각 키 값
	private ItemVO itemvo;

	public MemberVO getMvo() {
		return mvo;
	}

	public void setMvo(MemberVO mvo) {
		this.mvo = mvo;
	}

	public ItemVO getItemvo() {
		return itemvo;
	}

	public void setItemvo(ItemVO itemvo) {
		this.itemvo = itemvo;
	}

}
