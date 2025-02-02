package core.thread;

/**	A race condition occurs when two or more threads access shared resources
 * 	(like variables, objects, or memory) concurrently, and the outcome depends on the thread 
 * 	execution order. This can lead to inconsistent or unexpected results
 * 
 * 	A race condition occurs when two or more threads can access shared data and they try to 
 * 	change it at the same time
 * 
 * 	Can fix race conditions by synchronizing access to the shared resource
 */
public class RaceConditionExample {

	public static void main(String[] args) throws InterruptedException {

		Counter2 counter = new Counter2();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // The expected value is 2000, but due to the race condition,
        // the result may be less than 2000.
        System.out.println("Final count: " + counter.getCount());
	}
}

class Counter2 {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}