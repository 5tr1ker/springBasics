package com.study.spring.base;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.study.spring.base.item.foodItem;

@Entity
public class ItemList {

	@Id @Column(name="ORDER_ID")
	private String orderID;
	
	@Column(name="ITEM_NAME")
	private String ItemName;
	
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name = "FOOD_LIST")
	private foodItem foodit;
	
	public foodItem getFoodit() {
		return foodit;
	}

	public void setFoodit(foodItem foodit) {
		this.foodit = foodit;
	}

	public ItemList() {
	}
	
	public ItemList(String item) {
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
