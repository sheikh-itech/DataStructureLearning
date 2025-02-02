package core.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**	By default ReentrantLock do not manages order of locks
 * 	Thats why it is famous as unfair lock
 * 
 * 	Provide true to new ReentrantLock(true) for fair locks
 */
public class UnfairLockDemo {

	private final Lock unfairLock = new ReentrantLock();
	
	public static void main(String[] args) {

		UnfairLockDemo demo = new UnfairLockDemo();
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				demo.accessResource();
			}
		};
		
		new Thread(runnable, "Thread-1").start();
		new Thread(runnable, "Thread-2").start();
		new Thread(runnable, "Thread-3").start();
	}
	
	private void accessResource() {
		
		try {
			unfairLock.lock();
			System.out.println(Thread.currentThread().getName()+" acquired lock");
			
			Thread.sleep(1000);
		} catch(Exception ex) {
			System.out.println(Thread.currentThread().getName()+" interrupted");
			Thread.currentThread().interrupt();
		} finally {
			try {
				unfairLock.unlock();
				System.out.println(Thread.currentThread().getName()+" released lock");
			} catch(Exception ex) {
				System.out.println(Thread.currentThread().getName()+", Error: "+ex.getMessage());
			}
		}
	}
}
