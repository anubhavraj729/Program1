package com.myProject.Thread;

public class CurrentThreadDemo {

	public static void run() throws InterruptedException {
		for(int i=5;i>0;i--) {
			System.out.println(i);
			Thread.sleep(1000);
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Thread t = Thread.currentThread();
				
		System.out.println("Current Thread: "+ t);
		for(int i = 0;i<10;i++) {
			System.out.println(i);
			run();
			Thread.sleep(1000);
		}

	}

}
