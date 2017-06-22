package com.rain.thread;

/**
 * 定义在Object中的两个方法
 * wait(),notify() final -- 没法重写
 * 在调用两个方法的时候,需要获取对象锁,因此对两个方法的调用需要放在synchronized方法或者synchronized块中;当线程执行
 * 了wait()时,会释放掉对象的锁;在没有调用notify(),该进程不会被唤醒
 * 
 * sleep()是定义在Thread中的,当调用此方法的时候,暂停现有线程的执行,但是并不会释放对象的锁;过了指定的毫秒数之后,该线程
 * 接着执行
 * */
public class ProductorAndConsumer {
	public static void main(String[] args) {
		Resource resource = new Resource();
		
		Producter productor = new Producter(resource);
		Consumer consumer = new Consumer(resource);
		// 当存在两个线程的时候,是不会出现问题的,两个线程之间通过是否对对象上锁
		// Producter生产完,唤醒Consumer消费,二者之间协调
		consumer.start();
		productor.start();
		
		/**
		 *  当存在4个线程的时候,并不能保证Consumer消费完唤醒Producter生产,可能其他的线程使用Consumer消费
		 *  这里即唤醒一个线程的时候需要对其进行条件检测,而不是使用if检测一次
		 */
		Producter productor_alias = new Producter(resource);
		Consumer consumer_alias = new Consumer(resource);
		
		productor_alias.start();
		consumer_alias.start();
	}
}

/**
 * wait()余notify()是成对出现的
 * */
class Resource{
	private int count;
	public int getCount(){
		return count;
	}
	public synchronized void consume(){
		while(count != 1){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count --;
		System.out.println(count);
		notify();
	}
	
	public synchronized void produce(){
		while(count != 0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count ++;
		System.out.println(count);
		notify();
	}
}

class Consumer extends Thread{
	private Resource resource;
	public Consumer(Resource resource){
		this.resource = resource;
	}
	@Override
	public void run() {
		super.run();
		for(int i = 0;i < 20;i ++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resource.consume();
		}
	}
}

class Producter extends Thread{
	private Resource resource;
	public Producter(Resource resource){
		this.resource = resource;
	}
	@Override
	public void run() {
		super.run();
		for(int i = 0;i < 20;i ++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resource.produce();
		}
	}
}