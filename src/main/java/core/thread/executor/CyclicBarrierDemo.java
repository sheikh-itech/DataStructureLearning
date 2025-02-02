package core.thread.executor;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/* Here, 3 worker threads wait at a barrier before continuing */

public class CyclicBarrierDemo {

	public static void main(String[] args) {

		int numThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(numThreads);

        // Creating 3 worker threads
        new Worker(barrier, "Worker-1").start();
        new Worker(barrier, "Worker-2").start();
        new Worker(barrier, "Worker-3").start();
	}
}

class Worker extends Thread {
	
    private final CyclicBarrier barrier;

    public Worker(CyclicBarrier barrier, String name) {
        super(name);
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " reached the barrier...");
        try {
            barrier.await(); // Wait for other threads to reach the barrier
            
            System.out.println(Thread.currentThread().getName() + " passed the barrier!");
            
        } catch (InterruptedException | BrokenBarrierException e) {
            System.err.println("Error: "+e.getMessage());
        }
    }
}