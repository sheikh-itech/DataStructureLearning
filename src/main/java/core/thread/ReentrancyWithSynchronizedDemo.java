package core.thread;

public class ReentrancyWithSynchronizedDemo {

	public static void main(String[] args) {
		
		ReentrancyWithSynchronizedDemo demo = new ReentrancyWithSynchronizedDemo();
		
		// Method/Object reference -> demo::methodA
		new Thread(demo::methodA, "Thread-1").start();

	}
	
	private synchronized void methodA() {
		
		System.out.println(Thread.currentThread().getName()+" locked method A");
		
		methodB();	//Reentranting same thread lock in Method-B inside Method-A
		
		System.out.println(Thread.currentThread().getName()+" running method A");
	}
	
	private synchronized void methodB() {
		
		System.out.println(Thread.currentThread().getName()+" locked method B");
		System.out.println(Thread.currentThread().getName()+" running method B");
	}
}
