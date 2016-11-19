package com.rain.thread;

/**
 * synchronized代码块
 * 
 * synchronized block与synchronized function的差异
 * 	synchronized block属于细粒度,锁的只是一个小区域的代码
 * 	synchronized function会控制整个方法,某一时刻只能一个线程访问该synchronized方法
 * 在使用synchronized的时候需要仔细考虑一下,到底是使用synchronized function还是synchronized block
 * */
public class SynchronizedBlock {
	public static void main(String[] args) {
		ThreadExample1 e = new ThreadExample1();
		
		MyThread4 thread1 = new MyThread4(e);
		MyThread5 thread2 = new MyThread5(e);
		
		thread1.start();
		thread2.start();
	}
}

class ThreadExample1{
	// obj无意义的,只是用来加上锁的对象,来实现代码的同步执行
	private Object obj = new Object();
	public void execute(){
		/**
		 * 声明synchronized block
		 * 
		 * */
		synchronized(this){
			for(int i = 0;i < 30;i ++){
				System.out.println("hello " + i);
			}
		}
	}
	public void execute2(){
		synchronized(this){
			for(int i = 0;i < 30;i ++){
				System.out.println("world " + i);
			}
		}
	}
}

class MyThread4 extends Thread{
	ThreadExample1 e;
	public MyThread4(ThreadExample1 e){
		this.e = e;
	}
	public void run() {
		e.execute();
	}
}

class MyThread5 extends Thread{
	ThreadExample1 e;
	public MyThread5(ThreadExample1 e){
		this.e = e;
	}
	public void run() {
		e.execute2();
	}
}