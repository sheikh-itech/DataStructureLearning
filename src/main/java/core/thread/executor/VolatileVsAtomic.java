package core.thread.executor;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileVsAtomic {

	public static void main(String[] args) throws Exception {

		/* try with and without volatile keyword for flag in SharedResource */
		
		SharedResource obj = new SharedResource();
		
		Thread writer = new Thread(()->{
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.err.println("Error: "+e.getMessage());
				Thread.currentThread().interrupt();
			}
			obj.setFlag();
		});
		
		Thread reader = new Thread(()-> obj.printFlag());
		
		writer.start();
		reader.start();
		
		Thread.sleep(3000);
		
		/* Each thread manages its own state by caching variable state
		 * thats why obj.printFlag() not printing anything */
		
		/* To overcome this problem use volatile variables */
		
		/* Volatile variable can force to don't cache state locally to threads but
		 * It can not stop thread overlapping variable state change */
		
		Counter count = new Counter();
		
		Thread t1 = new Thread(()->{
			for(int i=1; i<=1000; i++)
				count.increase();
		});
		
		Thread t2 = new Thread(()->{
			for(int i=1; i<=1000; i++)
				count.increase();
		});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println("Volatile Count shoul be 2000: "+count.print());
		
		/* Try this with Atomic Variable for concurrency */
		
		Counter1 count1 = new Counter1();
		
		Thread t3 = new Thread(()->{
			for(int i=1; i<=1000; i++)
				count1.increase();
		});
		
		Thread t4 = new Thread(()->{
			for(int i=1; i<=1000; i++)
				count1.increase();
		});
		
		t3.start();
		t4.start();
		t3.join();
		t4.join();
		
		System.out.println("Atomic Count shoul be 2000: "+count1.print());
	}
}

class SharedResource {
	
	//private boolean flag;
	private volatile boolean flag;	// Threads can't cache it
	
	public void setFlag() {
		flag = true;
		System.out.println("Flag is true now");
	}
	
	public void resetFlag() {
		flag = !flag;
		System.out.println("Flag is false now");
	}
	
	public void printFlag() {
		
		while(!flag) {
			
		}
		
		if(flag)
			System.out.println("Flag is true");
	}
}

class Counter {
	
	private volatile int count;
	
	void increase() {
		count++;
	}
	
	int print() {
		
		return count;
	}
}

class Counter1 {
	
	private AtomicInteger count = new AtomicInteger();
	
	void increase() {
		count.incrementAndGet();
	}
	
	int print() {
		
		return count.intValue();
	}
}