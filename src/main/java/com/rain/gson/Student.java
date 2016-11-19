package com.rain.gson;

public class Student {
	String name;
	Student s;
	int age;
	int sno;
	public Student(){
		
	}
	public Student(String name, int age, int sno) {
		super();
		this.name = name;
		this.age = age;
		this.sno = sno;
		this.s = new Student();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String toString(){
		return this.sno + "..." + this.age + "..." +  this.name;
	}
}
