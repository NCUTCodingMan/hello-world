package com.rain.abstractClass;

public class ByteDemo {
	
	public static void main(String[] args) {
		int i = 0;
		
		i = i ++;
		
		/*
				我们分析一下字节码
				0: sipush 234 //将常量234压入操作数栈
				3: istore_1 //将操作数栈中的数值存到局部变量区1号位置上
				4: iload_1 //将局部变量区1号位置上的值压入操作数栈
				5: iinc 1, 1 //将局部变量区1号位置上的数值增1
				8: istore_1 //将操作数栈中的数值存到局部变量区1号位置上
		*/
	}
	
	public void a(Byte a){
		++ a;
	}
}