package com.rain.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

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
