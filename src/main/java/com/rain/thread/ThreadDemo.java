package com.rain.thread;

public class ThreadDemo{
	public static void main(String[] args) {
		ThreadImpl thread = new ThreadImpl("first thread");
		/**
		 * 申请线程运行的必要资源,调用run(),启动线程
		 * */
		System.out.println(thread.getName());
		thread.start();
		
		ThreadImpl2 thread2 = new ThreadImpl2();
		thread2.start();
	}
}

class ThreadImpl extends Thread {
	/**
	 * 覆盖run()
	 * 	希望执行的操作放在run(),线程一旦执行就不能控制了
	 * */
	public ThreadImpl(String name){
		super(name);
	}
	@Override
	public void run() {
		super.run();
		for(int i = 0;i < 100;i ++){
			System.out.println("world " + i);
		}
	}
}

class ThreadImpl2 extends Thread {
	@Override
	public void run() {
		super.run();
		for(int i = 0;i < 100;i ++){
			System.out.println("helloworld " + i);
		}
	}
}