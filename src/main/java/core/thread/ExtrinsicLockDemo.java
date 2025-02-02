package core.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**	ExtrinsicLock needed to acquire more control over lock & release
 * 
 * 	There may be need for lock in certain lines not in method
 */
public class ExtrinsicLockDemo {

	public static void main(String[] args) {

		Account account = new Account();
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				
				account.withdraw(50);
			}
		};
		
		new Thread(runnable, "Thread-1").start();	// Thread 1
		new Thread(runnable, "Thread-2").start();	// Thread 2
		new Thread(runnable, "Thread-3").start();	// Thread 3
	}
}

class Account {
	
	private float balance=200;
	private final Lock lock = new ReentrantLock();
	
	public void withdraw(int amount) {
		
		System.out.println(Thread.currentThread().getName()+" trying to withdraw...");
		
		try {
			
			// lock.lock()=> waits without time limit to acquire lock
			
			/* If lock free then acquires it with 1000 milliseconds 
			 * If current thread not interrupted by other thread */
			if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
				
				if(amount > balance)
					System.err.println(Thread.currentThread().getName()+" Insufficient balance");
				
				try {
					Thread.sleep(3000);
				} catch(InterruptedException ex) {
					System.err.println(Thread.currentThread()
							.getName()+", Error: "+ex.getMessage());
					Thread.currentThread().interrupt(); // To inform that thread interrupted
				}
				
				balance -= amount;
				
				System.out.println(Thread.currentThread()
						.getName()+" Amount "+amount +" withdraw completed...");
			} else {
				System.out.println(Thread.currentThread()
						.getName()+" Could not acquire lock, will try later...");
			}
		} catch (InterruptedException e) {
			
			System.err.println(Thread.currentThread().getName()+", Error: "+e.getMessage());
			Thread.currentThread().interrupt(); // To inform that thread interrupted
			
		} finally {
			try {
				lock.unlock();
			} catch(Exception ex) {
				System.err.println(Thread.currentThread().getName()+", Error: "+ex.getMessage());
			}
		}
	}
}