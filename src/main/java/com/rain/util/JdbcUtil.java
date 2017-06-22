package com.rain.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class JdbcUtil {
	public static final String url = "jdbc:mysql://127.0.0.1/aoku_0001";  
	public static final String name = "com.mysql.jdbc.Driver";  
	public static final String user = "root";  
	public static final String password = "tiger"; 
	public static void main(String[] args) {
		Connection conn;
		String sql = "select * from crawl02 limit 0,1000";
		try {  
	        Class.forName(name);//指定连接类型  
	        conn = DriverManager.getConnection(url, user, password);//获取连接  
	        ResultSet rs = conn.createStatement().executeQuery(sql);
	        InputStream is = null;
        	OutputStream os = new BufferedOutputStream(new FileOutputStream(new File("1.txt")));
	        while(rs.next()){
	        	Blob blob = rs.getBlob("screen_Name");
	        	is = blob.getBinaryStream();
	        	int i = 0;
	        	byte[] buffer = new byte[1024];
	        	while((i = is.read(buffer)) != -1){
	        		os.write(buffer);
	        	}
	        }
	        is.close();
        	os.close();
		} catch (Exception e) {  
	            e.printStackTrace();  
	    }  
	}
}
