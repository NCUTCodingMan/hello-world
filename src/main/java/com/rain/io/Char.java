package com.rain.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 若一段字符仅仅包含中文并且不包含换行的时候可以使用字节流对字符进行处理，此时每个中文3个字节
 * 每次截取不会存在截取一般的问题。但是若存在英文字符，UTF-8是变长编码，英文字符仅仅占一个
 * 字节，所有会出现中文论码的情况
 * */
public class Char {
	public static void main(String[] args) throws Exception {
		FileInputStream is = new FileInputStream(new File("demo.txt"));
		byte[] buffer = new byte[12];
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while((i = is.read(buffer)) != -1){
			sb.append(new String(buffer,"UTF8"));
		}
		System.out.println(sb);
		System.out.println("----------------------------");
		is.close();
		is = new FileInputStream(new File("demo.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String s = null;
		while((s = br.readLine()) != null){
			System.out.println(s);
		}
		is.close();
		br.close();
	}
}
