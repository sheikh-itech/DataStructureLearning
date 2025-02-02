package core.thread;

/**	If existing class already extends any class in this scenario we can use Runnable
 * 	Since multiple inheritance not supported in java with classes
 */
public class ThreadCreationDemo {

	public static void main(String[] args) {

		Thread1 thread1 = new Thread1();	// Own class
		thread1.start();
		
		Thread2 thread2 = new Thread2();	// Own class
		
		Thread thread = new Thread(thread2);
		thread.start();
		
		for( ; ; )	//Infinite loop
			System.out.println("Main Thread");
		
	}
}

class Thread1 extends Thread {

	@Override
	public void run() {
		
		for( ; ; )	//Infinite loop
			System.out.println("Hello from another thread1");
	}
}

class Thread2 implements Runnable {

	@Override
	public void run() {
		for( ; ; )	//Infinite loop
			System.out.println("Hello from another thread2");
	}
}