package com.rain.string;

import java.lang.reflect.Field;

/**
 * 判断字符串是否可变
 * */
public class WetherChange {
	/**
	 * String的不可变性是通过其value[]来体现的
	 * 通过反射直接修改String中的value[]
	 * */
	public static void main(String[] args) throws Exception {
		String s = "hello world";
		
		String x = new String("hello world");
		
		String s1 = "hello world";
		
		Class<String> clazz = String.class;
		Field field = clazz.getDeclaredField("value");
		
		field.setAccessible(true);
	
		char[] value = (char[])field.get(s);
		
		value[5] = '_';
		
		System.out.println("s = " + s + "\t" + "s1 = " + s1);
		
		System.out.println(s1 == s);
		
		System.out.println(x);
	}
}