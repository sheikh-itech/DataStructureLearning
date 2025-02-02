package core.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**	Reentrant helps to return lock if lock looking for same thread
 * 	This helps to prevent Dead-Lock condition
 * 
 * 	Dead-Lock: Reentrant helps to prevent deadlock condition
 * 
 * 	Reentrant manages lock count for every thread, that means how many times we acquired lock
 * 	only those many time we can close [otherwise error null since no lock available]
 */
public class ReentrantLockBenifitDemo {

	private final Lock lock = new ReentrantLock();
	
	public static void main(String[] args) {

		ReentrantLockBenifitDemo demo = new ReentrantLockBenifitDemo();
		
		demo.outerMethod();
	}
	
	private void outerMethod() {
		
		try {
			
			//lock.lockInterruptibly(); //Acquires the lock unless the current thread is interrupted
			
			lock.lock();//Waits till get lock without time limit
			
			System.out.println("Outer method executed with lock");
			
			innerMethod();
			
		} catch(Exception ex) {
			System.out.println(Thread.currentThread().getName()+", Error: "+ex.getMessage());
		} finally {
			try {
				lock.unlock();	// Unlock for lock-1
				lock.unlock();	// Unlock for lock-1
				lock.unlock();	// Error since only 2 times locked=> IllegalMonitorStateException
			} catch(Exception ex) {
				System.out.println(Thread.currentThread().getName()+", Error: "+ex);
			}
		}
	}
	
	// Dead lock taken care by Reentrant since same thread
	private void innerMethod() {
		
		try {
			lock.lock(); // Acquires lock since same thread lock that parent method having same
			
			System.out.println("Inner method executed since same thread lock....No deadlock condition");
			
		} catch(Exception ex) {
			System.out.println(Thread.currentThread().getName()+", Error: "+ex.getMessage());
		}
	}
}
