package com.study.spring.base.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "GAME_DATA")
@DiscriminatorValue("GAME")
public class game extends Item{

	private int useAge;

	public int getUseAge() {
		return useAge;
	}

	public void setUseAge(int useAge) {
		this.useAge = useAge;
	}
}
