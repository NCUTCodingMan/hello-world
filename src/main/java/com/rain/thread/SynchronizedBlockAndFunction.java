package com.rain.thread;

public class SynchronizedBlockAndFunction {
	public static void main(String[] args) {
		Equipment e = new Equipment();
		
		Crumble c = new Crumble(e);
		Leed l = new Leed(e);
		
		c.start();
		l.start();
	}
}

class Equipment{
	private boolean flag = true;
	public void equip(){
		synchronized (this) {
			while(flag != false){
				try {
					/**
					 * Causes the current thread to wait until another thread 
					 * invokes the java.lang.Object.notify() method or 
					 * the java.lang.Object.notifyAll() method for this object. 
					 * In other words, this method behaves exactly as if it simply performs the call wait(0). 
					 * */
					// 造成当前执行的进程等待,等待的过程中释放对象锁
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			flag = true;
			this.notify();
			System.out.println(flag);
		}
	}
	
	public void takeoff(){
		synchronized (this) {
			while(flag != true){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			flag = false;
			this.notify();
			System.out.println(flag);
		}
	}
}

class Crumble extends Thread{
	private Equipment e;
	public Crumble(Equipment e) {
		this.e = e;
	}
	@Override
	public void run() {
		super.run();
		for(int i = 0;i < 30;i ++){
			e.equip();
		}
	}
}

class Leed extends Thread{
	private Equipment e;
	public Leed(Equipment e) {
		this.e = e;
	}
	@Override
	public void run() {
		super.run();
		for(int i = 0;i < 30;i ++){
			e.takeoff();
		}
	}
}