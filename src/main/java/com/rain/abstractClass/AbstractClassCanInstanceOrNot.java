package com.rain.abstractClass;

public class AbstractClassCanInstanceOrNot {
	public static void main(String[] args) {
		String s = "hello" + "world" + "java";
		String s1 = "hello";
		String s2 = "world";
		String s3 = s1 + s2;
	}
}

abstract class Fruit{
	public Fruit(){
		System.out.println("Fruit");
	}
	public abstract String color();
}

class Apple extends Fruit{
	public Apple(){
		super();
		System.out.println("Apple");
	}
	@Override
	public String color() {
		return "red or yellow or black";
	}
}