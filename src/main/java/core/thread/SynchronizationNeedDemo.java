package core.thread;

/**	Counter value may never be 20000 because 
 * 	both thread may be accessed same counter at certain time [Shared variable access]
 *
 *	This is the reason Synchronization required
 *
 *	Synchronization is used to prevent thread interference and data inconsistency
 */
public class SynchronizationNeedDemo {

	public static void main(String[] args) {

		Counter counter = new Counter();
		
		CountThread t1 = new CountThread(counter);
		CountThread t2 = new CountThread(counter);
		CountThread t3 = new CountThread(counter);
		
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

class Counter {
	
	private int count = 0;

	public int getCount() {
		return count;
	}

	public void increment() {
		count++;
	}
}

class CountThread extends Thread {
	
	private Counter counter;
	
	public CountThread(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {

		for(int i=0; i<1000; i++)
			counter.increment();
	}
}