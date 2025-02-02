package core.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**	ReentrantLock fair lock true then it manages order of locks
 * 	
 * 	Fair lock helps in Starvation condition
 * 
 * 	In fair lock First-Come-First-Out order maintained
 * 
 * 	synchronized do not provide fair lock
 */
public class FairLockDemo {

	private final Lock fairLock = new ReentrantLock(true);
	
	public static void main(String[] args) {

		FairLockDemo example = new FairLockDemo();
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				example.accessResource();
			}
		};
		
		new Thread(runnable, "Thread-1").start();
		new Thread(runnable, "Thread-2").start();
		new Thread(runnable, "Thread-3").start();
	}
	
	private void accessResource() {
		
		try {
			fairLock.lock();
			System.out.println(Thread.currentThread().getName()+" acquired lock");
			
			Thread.sleep(1000);
		} catch(Exception ex) {
			System.out.println(Thread.currentThread().getName()+" interrupted");
			Thread.currentThread().interrupt();
		} finally {
			try {
				fairLock.unlock();
				System.out.println(Thread.currentThread().getName()+" released lock");
			} catch(Exception ex) {
				System.out.println(Thread.currentThread().getName()+", Error: "+ex.getMessage());
			}
		}
	}
}
