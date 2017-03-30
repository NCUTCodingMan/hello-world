package com.rain.abstractClass;

import java.math.BigInteger;

public class BigIntegerDemo {
	public static void main(String[] args) {
		BigInteger b1 = new BigInteger("4");
		// this | 1 << n (左移n位) 相或
		// 在当前数字的第n位上设置值(二进制操作)
		b1 = b1.setBit(1);
		System.out.println(b1);
		// this & 1 << n (左移n位) 相与
		// 检测当前数字第n位上实付有值(二进制操作)
		System.out.println(b1.testBit(2));
		
		BigInteger b2 = new BigInteger("0");
		b2 = b2.setBit(2);
		System.out.println(b2);
		
		System.out.println(b1.testBit(2));
	}
}