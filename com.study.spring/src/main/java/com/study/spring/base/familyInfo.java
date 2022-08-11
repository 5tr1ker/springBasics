package com.study.spring.base;

import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class familyInfo {

	private String name;
	private String sex;
	private int age;
	
	public familyInfo() {
		
	}
	
	public familyInfo(String name, String sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(age, name, sex);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		familyInfo other = (familyInfo) obj;
		return Objects.equals(age, other.age) && Objects.equals(name, other.name) && Objects.equals(sex, other.sex);
	}
}
