package core.thread.executor;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**	Since CyclicBarrier is reusable, we can use it for multi-phase processing
 * 	
 * 	The barrier resets automatically after each phase
 * 	
 * 	Useful for simulations, parallel computations, or multi-stage workflows,
 * 	database migration or parallel web scraping
 * 
 * Barrier Reset:
 * 		If a thread is interrupted while waiting, the barrier is broken, 
 * 		and other threads waiting will throw BrokenBarrierException
 * 	
 * 	Use barrier.reset() to manually reset the barrier
 */
public class CyclicBarrierMultiPhase {

	public static void main(String[] args) {

		CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("All threads reached the barrier! Moving to next phase..."));

        new PhaseTask(barrier, "Thread-1").start();
        new PhaseTask(barrier, "Thread-2").start();
        new PhaseTask(barrier, "Thread-3").start();
	}
}

class PhaseTask extends Thread {
	
    private final CyclicBarrier barrier;

    public PhaseTask(CyclicBarrier barrier, String name) {
        super(name);
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + " completed phase " + i);
                barrier.await(); // Wait/reset for all threads at the end of each phase
            }
        } catch (InterruptedException | BrokenBarrierException ex) {
            
            if (ex instanceof BrokenBarrierException && barrier.isBroken()) {
                System.err.println("Barrier is broken! Resetting...");
                barrier.reset();
            }
        }
    }
}