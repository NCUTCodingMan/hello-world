package com.rain.init;

/**
 * 1.初始化阶段是执行狗朝气<clinit>()的时候,自动收集类中所有类变量的赋值动作与静态语句块中合成产生的
 * 	收集的顺序由语句在源文件中出现的顺序锁决定的，静态语句块只能访问到定义在静态语句块之前的变量，但是可以在
 * 	其中为变量赋值
 * 2.在子类的<clinit>()方法之前,其父类的<clinit>()会提前执行完毕，即父类中的静态代码块优先于子类的
 * 	静态变量的赋值
 * 3.接口中不能使用静态代码块，<clinit>()对接口而言也不是必须得。
 * */
public class Garter{
	public static void main(String[] args) {
		System.out.println(Sub.B);
	}
}

class Parent {
	public static int A = 1;
	static{
		A = 2;
	}
	
}

class Sub extends Parent{
	public static int B = A;
}
