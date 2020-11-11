package com.myProject.Thread;

// An example of deadlock.
// Note: Don't run this program.
// Press ctrl + C to end the program

class A{
	synchronized void foo(B b) {
		String name = Thread.currentThread().getName();
		System.out.println(name + " entered A.foo");
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			System.out.println("A Interrupted");
		}
		System.out.println(name + "trying to call B.last()");
		b.last();
	}
	synchronized void last() {
		System.out.println("Inside A.last");
	}
}

class B{
	synchronized void bar(A a) {
		String name = Thread.currentThread().getName();
		System.out.println(name + "entered B.bar");
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			System.out.println("N Interrupted");
		}
		System.out.println(name + " trying to call A.last()");
		a.last();
	}
	synchronized void last() {
		System.out.println("Inside A.last");
	}
}
public class Deadlock implements Runnable{
	
	A a = new A();
	B b = new B();
	
	Deadlock(){
		Thread.currentThread().setName("MainThread");
		Thread t = new Thread(this,"Racing Thread");
		t.start();
		
		a.foo(b);
		System.out.println("Back is in main Thread");
	}
	
	public void run() {
		b.bar(a);
		System.out.println("Back in the other Thread");
	}
	public static void main(String[] args) {
		new Deadlock();
	}

}
