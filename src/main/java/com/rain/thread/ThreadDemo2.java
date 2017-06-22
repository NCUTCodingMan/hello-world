package com.rain.thread;

public class ThreadDemo2 {
	public static void main(String[] args) {
		Thread thread = new Thread(new MyThread());
		thread.start();
		/**
		 * 使用匿名内部类方式创建Runnable对象
		 * */
		Thread thread1 = new Thread(new Runnable(){
			public void run() {
				for(int i = 0;i < 100;i ++){
					System.out.println("world " + i);
				}
			}
		});
		thread1.start();
	}
}

/**
 * 继承Runnable接口
 * */
class MyThread implements Runnable{
	public void run() {
		for(int i = 0;i < 100;i ++){
			System.out.println("helloworld " + i);
		}
	}
}
