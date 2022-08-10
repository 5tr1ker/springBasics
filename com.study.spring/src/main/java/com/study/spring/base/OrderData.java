package com.study.spring.base;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(OrderId.class)
public class OrderData {
	
	@Id @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID")
	private MemberVO mvo;

	@Id @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_NUM") // 각 키 값
	private ItemList itemvo;

	public MemberVO getMvo() {
		return mvo;
	}

	public void setMvo(MemberVO mvo) {
		this.mvo = mvo;
	}

	public ItemList getItemvo() {
		return itemvo;
	}

	public void setItemvo(ItemList itemvo) {
		this.itemvo = itemvo;
	}

}
