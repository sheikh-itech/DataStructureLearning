package core.thread.executor;

import java.util.concurrent.CountDownLatch;

/**	This example ensures that Phase 1 completes before Phase 2 starts
 */
public class CountDownLatchMultiPhaseSequence {

	public static void main(String[] args) {

		CountDownLatch phase1Latch = new CountDownLatch(3); // 3 tasks in Phase 1

        new Phase1Task(phase1Latch, "Task-1").start();
        new Phase1Task(phase1Latch, "Task-2").start();
        new Phase1Task(phase1Latch, "Task-3").start();

        new Phase2Task(phase1Latch, "Task-4").start();
        new Phase2Task(phase1Latch, "Task-5").start();
	}
}
class Phase1Task extends Thread {
	
    private final CountDownLatch latch;

    Phase1Task(CountDownLatch latch, String name) {
        super(name);
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " performing Phase 1...");
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
        System.out.println(Thread.currentThread().getName() + " completed Phase 1.");
        latch.countDown();
    }
}

class Phase2Task extends Thread {
    private final CountDownLatch latch;

    Phase2Task(CountDownLatch latch, String name) {
        super(name);
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await(); // Wait until Phase 1 tasks complete
            System.out.println(Thread.currentThread().getName() + " performing Phase 2...");
        } catch (InterruptedException ignored) {}
    }
}