package com.rain.thread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableObject {
	public static void main(String[] args) throws Exception {
		FileOutputStream os = new FileOutputStream(new File("local.txt"));
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(new Person(1,"rain",'M'));
		oos.writeObject(new Person(2,"scott",'M'));
		oos.close();
		
		FileInputStream is = new FileInputStream(new File("local.txt"));
		ObjectInputStream ois = new ObjectInputStream(is);
		Person person = (Person)ois.readObject();
		System.out.println(person);
		ois.close();
	}
}

@SuppressWarnings("serial")
class Person implements Serializable{
	private int id;
	private String name;
	private char sex;
	public Person(int id, String name, char sex) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
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
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", sex=" + sex + "]";
	}
}