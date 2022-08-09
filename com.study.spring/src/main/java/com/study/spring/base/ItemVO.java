package com.study.spring.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemVO {

	@Id @Column(name="ORDER_ID")
	private String orderID;
	
	@Column(name="ITEM_NAME")
	private String ItemName;
	
	public ItemVO() {
	}
	
	public ItemVO(String item) {
		ItemName = item;
	}
	
	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	
}
