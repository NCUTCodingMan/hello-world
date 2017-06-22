package com.rain.serializable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import com.rain.domian.Person;

public class SerializableObject {
	public static void main(String[] args) throws Exception {
		File file = new File("serializable.txt");
		if(file.exists()){
			System.out.println("file exist");
		}
		FileOutputStream op = new FileOutputStream("serializable.txt");
		ObjectOutput oos = new ObjectOutputStream(op);
		Person person = new Person();
		person.setName("scott");
		person.setAddress("American H");
		person.setPhone("110");
		person.setSex('F');
		person.setAge(20);
		oos.writeObject(person);
		oos.flush();
		oos.close();
	}
}