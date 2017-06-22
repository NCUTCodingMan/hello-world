package com.rain.thread;

/**
 * 关于synchronized,关键是对谁上锁
 * */
public class SynchronizedDemo {
	public static void main(String[] args) {
		ThreadExample e = new ThreadExample();
		Thread thread1 = new MyThread2(e);
		/*
		 * 当e指向其他的对象时,输出是有变化的
			e = new ThreadExample();
		*/
		Thread thread2 = new MyThread3(e);
		thread1.start();
		thread2.start();
	}
}

class ThreadExample{
	public synchronized void execute(){
		for(int i = 0;i < 30;i ++){
			System.out.println("hello " + i);
		}
	}
	public synchronized void execute2(){
		for(int i = 0;i < 30;i ++){
			System.out.println("world " + i);
		}
	}
	/**
	 * 静态的synchronized方法
	 * 	static对synchronized的影响,静态方法属于类本身而不是对象
	 * 	当一个线程执行 static synchronized方法的时候,锁的是当前类的Class对象(Class对象仅仅只有一个)
	 * 	因此当多个线程去执行多个对象所属的类的static synchronize方法的时候,也是顺序执行的,锁的是当前类所属的Class对象
	 * 	即当一个线程执行方法完毕之后,其他的线程才能执行该static synchronized方法
	 * */ 
	public static synchronized void execute3(){
		for(int i = 0;i < 30;i ++){
			System.out.println("really " + i);
		}
	}
}

/*
class MyThread2 implements Runnable{
	ThreadExample e;
	public MyThread2(ThreadExample e){
		this.e = e;
	}
	public void run() {
		e.execute();
	}
}

class MyThread3 implements Runnable{
	ThreadExample e;
	public MyThread3(ThreadExample e){
		this.e = e;
	}
	public void run() {
		e.execute3();
	}
}
*/
class MyThread2 extends Thread{
	ThreadExample e;
	public MyThread2(ThreadExample e){
		this.e = e;
	}
	public void run() {
		e.execute();
	}
}

class MyThread3 extends Thread{
	ThreadExample e;
	public MyThread3(ThreadExample e){
		this.e = e;
	}
	public void run() {
		e.execute3();
	}
}