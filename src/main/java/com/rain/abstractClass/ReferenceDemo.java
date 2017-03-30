package com.rain.abstractClass;

public class ReferenceDemo {
	public static void main(String[] args) {
		ReferenceDemo demo = new ReferenceDemo();
		demo.first();
		
		A a = new A();
		Integer a1 = 1;
		Integer a2 = 2;
		a.swap(a1, a2);
		System.out.println(a1 + ".." + a2);
	}
	public void first(){
		A a = new A();
		a.setI(20);
		int i = 10;
		second(a,i);
		System.out.println(a.getI());
	}
	public void second(A a,int i){
		i = 0;
		A a1 = new A();
		a.setI(15);
		a = a1;
		System.out.println(i + "..." + a.getI());
	}
}

class A{
	private int i = 15;
	public A(){}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public void swap(Integer a,Integer b){
		Integer temp = b;
		b = a;
		a = temp;
	}
}