package com.rain.thread;

public class ResultSetInfo {
	public static void main(String[] args) {
		ResultSetDel resultSetDel = new ResultSetDel();
		Thread read = new Thread(new ReadOperation(resultSetDel));
		Thread write = new Thread(new WriteOperation(resultSetDel));
		
		read.start();
		write.start();
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class ResultSetDel{
	private int flag = 1;
	
	// 读取
	public void read(){
		synchronized(this){
			while(flag != 0){
				try {
					this.wait();
				} catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			flag = 1;
			this.notify();
			System.out.println(flag);
		}
	}
	
	// 操作
	public void operation(){
		synchronized(this){
			while(flag != 1){
				try {
					this.wait();
				} catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			flag = 0;
			this.notify();
			System.out.println(flag);
		}
	}
}

class ReadOperation implements Runnable{
	private ResultSetDel resultSetDel;
	public ReadOperation(ResultSetDel resultSetDel){
		super();
		this.resultSetDel = resultSetDel;
	}
	@Override
	public void run() {
		this.resultSetDel.read();
	}
}

class WriteOperation implements Runnable{
	private ResultSetDel resultSetDel;
	public WriteOperation(ResultSetDel resultSetDel){
		super();
		this.resultSetDel = resultSetDel;
	}
	@Override
	public void run() {
		this.resultSetDel.operation();
	}
}