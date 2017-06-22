package com.rain.thread;

/**
 * 多线程同步问题
 * */
public class FetchMoney {
	public static void main(String[] args) {
		Bank bank = new Bank();
		
		MyThread1 thread1 = new MyThread1(bank);
		MyThread1 thread2 = new MyThread1(bank);
		
		thread1.start();
		thread2.start();
	}
}

class Bank{
	private int money = 1000;
	public synchronized int getMoney(int number){
		if(number < 0){
			return -1;
		}else if(number > money){
			return -2;
		}else{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			money -= number;
			return money;
		}
	}
}

class MyThread1 extends Thread{
	Bank bank;
	public MyThread1(Bank bank) {
		super();
		this.bank = bank;
	}
	@Override
	public void run() {
		System.out.println(bank.getMoney(800));
	}
}