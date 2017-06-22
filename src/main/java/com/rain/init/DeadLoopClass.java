package com.rain.init;

public class DeadLoopClass {
	/**
	 * 虚拟机会保证一个类的<clinit>()方法在多线程的环境下呗正确地加锁，同步，如果
	 * 多个线程同时去初始化一个类，那么只有一个线程去初始化该类的<clinit>()方法，其他的
	 * 线程都需要阻塞等待，直到活动线程执行完毕；因此，若在一个类的<clinit>()方法中有耗时
	 * 较长的操作，就可能导致多个进程的阻塞。
	 * 下面就是一个例子
	 * */
	static{
		if(true){
			System.out.println(Thread.currentThread() + "init DeadLoopClass");
			while(true){
				
			}
		}
	}
	public static void main(String[] args) {
		Runnable script = new Runnable(){
			public void run() {
				System.out.println(Thread.currentThread() + " start");
				DeadLoopClass dlc = new DeadLoopClass();
				System.out.println(Thread.currentThread() + "run over");
			}
		};
		Thread first = new Thread(script);
		Thread second = new Thread(script);
		
		first.start();
		second.start();
	}
}
