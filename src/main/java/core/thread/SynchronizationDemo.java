package core.thread;

/**	Counter1 value should be now 20000 because 
 * 	both thread now accessing synchronized method
 *
 *	This is the reason Synchronization required
 *
 *	Synchronization is used to prevent thread interference and data inconsistency
 */
public class SynchronizationDemo {

	public static void main(String[] args) {

		Counter1 counter = new Counter1();
		
		CountThread1 t1 = new CountThread1(counter);
		CountThread1 t2 = new CountThread1(counter);
		CountThread1 t3 = new CountThread1(counter);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			// Joining both thread so that can get counter value after t1, t2 completion
			t1.join();
			t2.join();
			t3.join();
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		
		//Compare SynchronizationDemo vs SynchronizationNeedDemo output
		System.out.println("Counter incremented: "+counter.getCount()+" times");
	}
}

class Counter1 {
	
	private int count = 0;

	public int getCount() {
		return count;
	}

	// Locking using synchronized keyword
	public synchronized void increment() {
		count++;
	}
}

class CountThread1 extends Thread {
	
	private Counter1 counter;
	
	public CountThread1(Counter1 counter) {
		this.counter = counter;
	}

	@Override
	public void run() {

		for(int i=0; i<1000; i++)
			counter.increment();
	}
}