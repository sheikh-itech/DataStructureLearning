package core.thread.executor;

import java.util.concurrent.CountDownLatch;

/**	All runners start at the same time after countDown() is called
 * 	
 * 	Prevents some threads from starting earlier than others
 */
public class CountDownLatchAllThreadsTogether {

	public static void main(String[] args) {

		// Only 1 signal needed to start all runners
		CountDownLatch latch = new CountDownLatch(1);

        Runner runner1 = new Runner(latch, "Runner-1");
        Runner runner2 = new Runner(latch, "Runner-2");
        Runner runner3 = new Runner(latch, "Runner-3");

        runner1.start();
        runner2.start();
        runner3.start();

        try {
			Thread.sleep(3000);	// Simulating preparation time
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
        System.out.println("Race Starting...");

        latch.countDown(); // Releases all waiting threads at the same time to 0
	}
}

class Runner extends Thread {
	
    private final CountDownLatch latch;

    public Runner(CountDownLatch latch, String name) {
        super(name);
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await(); // Wait until countdown reaches 0
            System.out.println(Thread.currentThread().getName() + " started running!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}