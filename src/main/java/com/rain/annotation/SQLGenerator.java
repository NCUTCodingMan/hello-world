package com.rain.annotation;

import java.lang.reflect.Field;

import com.rain.domian.Department;

public class SQLGenerator {
	public static String sqlGenerator(Object obj){
		Class<?> clazz = obj.getClass();
		Table table = clazz.getAnnotation(Table.class);
		StringBuilder sb = new StringBuilder();
		sb.append("create table " + table.name() + "(");
		sb.append("\n");
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields){
			field.setAccessible(true);
			SQLInteger sqlInteger = field.getAnnotation(SQLInteger.class);
			String name = null;
			int length = 0;
			boolean primaryKey = false;
			boolean uniqueKey = false;
			boolean foreignKey = false;
			if(sqlInteger != null){
				name = sqlInteger.name();
				length = sqlInteger.length();
				primaryKey = sqlInteger.primaryKey();
				uniqueKey = sqlInteger.uniqueKey();
				foreignKey = sqlInteger.foreignKey();
				sb.append(name + " int(" + length + ")");
				if(primaryKey){
					sb.append(" primary key");
				}
				if(uniqueKey){
					sb.append(" unique key");
				}
				if(foreignKey){
					sb.append(" foreign key");
				}
				sb.append("\n");
			}
			SQLString sqlString = field.getAnnotation(SQLString.class);
			if(sqlString != null){
				name = sqlString.name();
				length = sqlString.length();
				primaryKey = sqlString.primaryKey();
				uniqueKey = sqlString.uniqueKey();
				foreignKey = sqlString.foreignKey();
				sb.append(name + " varchar(" + length + ")");
				if(primaryKey){
					sb.append(" primary key");
				}
				if(uniqueKey){
					sb.append(" unique key");
				}
				if(foreignKey){
					sb.append(" foreign key");
				}
				sb.append("\n");
			}
		}
		sb.append(");");
		return sb.toString();
	}
	public static boolean difference(String iinString){
		int begin = 1;
		int end = iinString.length();
		boolean flag = false;
		while(iinString.substring(begin, end).length() != 0 && begin < iinString.length()){
			String prefix = iinString.substring(begin - 1,begin);
			if(iinString.substring(begin, end).contains(prefix)){
				flag = true;
				break;
			}else{
				++ begin;
			}
		}
		return flag;
	}
	public static String reverse(String iniString){
		int begin = 1;
		int loop = iniString.length() / 2 - 1;
		String s = "";
		int i = 0;
		while(i <= loop){
			String head = iniString.substring(begin -1,begin);
			String tail = iniString.substring(iniString.length() - begin,iniString.length() - begin + 1);
			s = iniString.substring(0,begin - 1) + tail + iniString.substring(begin,iniString.length() - begin) + head + iniString.substring(iniString.length() - begin + 1,iniString.length());
			iniString = s;
			i ++;
			begin ++;
		}
		return s;
	}
	public static void main(String[] args) {
		int _1M = 1024 * 1024;
		byte[] allocation_1,allocation_2,allocation_3;
		allocation_1 = new byte[1 * _1M];
		allocation_2 = new byte[2 * _1M];
		allocation_3 = new byte[6 * _1M];
	}
}
