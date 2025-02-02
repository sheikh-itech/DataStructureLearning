package core.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {

	private int counter = 0;
	
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	
	private final Lock readLock = lock.readLock();
	private final Lock writeLock = lock.readLock();
	
	public static void main(String[] args) {

		ReentrantReadWriteLockDemo demo = new ReentrantReadWriteLockDemo();
		
		Runnable readTask = new Runnable() {
			
			@Override
			public void run() {

				for(int i=0; i<10; i++) {
					
					System.out.println(Thread.currentThread().getName()+", Read: "+demo.getCount());
				}
			}
		};
		
		Runnable writeTask = new Runnable() {
			
			@Override
			public void run() {

				for(int i=0; i<10; i++) {

					System.out.println(Thread.currentThread().getName()+", write called");
					
					demo.increment();
				}
			}
		};
		
		Thread th1 = new Thread(writeTask, "Thread1");
		Thread th2 = new Thread(readTask, "Thread2");
		Thread th3 = new Thread(readTask, "Thread3");
		
		th1.start();	th2.start();	th3.start();
		
		try {
			th1.join();		th2.join();		th3.join();
		} catch (Exception ex) {
			System.err.println(Thread.currentThread().getName()+", Error: "+ex.getMessage());
		}
		
	}
	
	public void increment() {
		
		try {
			writeLock.lock();
			counter++;
			//Thread.sleep(10);
		} catch(Exception ex) {
			System.err.println(Thread.currentThread().getName()+", Error: "+ex.getMessage());
		} finally {
			writeLock.unlock();
		}
	}
	
	public int getCount() {
		
		try {
			readLock.lock();
			return counter;
		} catch(Exception ex) {
			System.err.println(Thread.currentThread().getName()+", Error: "+ex.getMessage());
		} finally {
			readLock.unlock();
		}
		return counter;
	}
}
