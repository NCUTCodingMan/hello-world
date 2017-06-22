package com.rain.domian;

import java.io.Serializable;

public class Person implements Serializable{
	private static final long serialVersionUID = -7344036548630647439L;
	private String name;
	private String address;
	private int age;
	private char sex;
	private transient String phone;
	public Person(){}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}