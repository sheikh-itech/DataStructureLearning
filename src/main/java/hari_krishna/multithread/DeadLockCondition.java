package hari_krishna.multithread;

public class DeadLockCondition extends Thread {

	static FirstClass fc = new FirstClass();
	static SecondClass sc = new SecondClass();
	
	public static void main(String[] args) throws InterruptedException {
		
		DeadLockCondition dc = new DeadLockCondition();
		dc.start();
		
		fc.first(sc);
	}
	
	@Override
	public void run() {
		try {
			sc.second(fc);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class FirstClass {
	
	public synchronized void first(SecondClass obj) throws InterruptedException {
		
		Thread.sleep(100);
		
		obj.lastMethod();
	}
	
	public synchronized void lastMethod() {
		System.out.println("Inside FirstClass lastMethod");
	}
}

class SecondClass {
	
	public synchronized void second(FirstClass obj) throws InterruptedException {
		
		Thread.sleep(100);
		
		obj.lastMethod();
	}
	
	public synchronized void lastMethod() {
		System.out.println("Inside SecondClass lastMethod");
	}	
}