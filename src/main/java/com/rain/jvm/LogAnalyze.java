package com.rain.jvm;

/**
 * 检测堆区,方法区内存回收信息
 * 	jvm参数 
 * 		(1)设置堆区不扩展(-Xms20M -Xmx20M)
 * 		(2)设置新生代Eden,Survivor的容量比例为8:1.即Eden空间大小为8M
 * 		(3)打印GC详情(-XX:+PrintGCDetails)
 * 		-Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 
 * 		-XX:+PrintGCDetails
 * 	新生代的GC策略为复制算法,当发生GC时,尝试将Eden,Survivor空间存活的对象转移到另一块Survivor空间.若是Survivor
 * 	空间的大小不足以存放存活对象,将会向Old申请担保空间,直接进入Old.
 * */
public class LogAnalyze {
	private static int _1M = 1024 * 1024;
	public static void main(String[] args) {
		byte[] allocation_1,allocation_2,allocation_3,allocation_4;
		allocation_1 = new byte[2 * _1M];
		allocation_2 = new byte[22 * _1M];
		allocation_3 = new byte[1 * _1M];
//		allocation_4 = new byte[22 * _1M];
		// -Xms40M -Xmx40M -Xmn30M -XX:SurvivorRatio=8 -XX:+PrintGCDetails
	}
}