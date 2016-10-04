package com.rain.clone;

import com.rain.domian.Person;

public class CloneDeepOrElse {
	public static void main(String[] args) throws Exception {
		Department re = new Department();
		Person person = new Person();
		person.setName("scott");
		person.setAddress("American H");
		person.setPhone("110");
		person.setSex('F');
		person.setAge(20);
		re.setPerson(person);
		Department rs = (Department)re.clone();
		System.out.println(rs.getPerson() == re.getPerson());
	}
}

class Department implements Cloneable {
	private Person person;
	private int id;
	private String name;
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Department re = new Department();
		re.setId(this.id);
		re.setName(this.name);
		Person person = new Person();
		person.setAddress(this.person.getAddress());
		person.setName(this.person.getName());
		person.setPhone(this.getPerson().getPhone());
		person.setSex(this.person.getSex());
		person.setAge(this.person.getAge());
		re.setPerson(person);
		return re;
	}
}