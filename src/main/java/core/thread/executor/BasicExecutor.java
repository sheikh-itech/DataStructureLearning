package core.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BasicExecutor {

	public static void main(String[] args) {

		// Create a pool of 3 threads
		ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            executor.execute(new MyTask()); // Submitting tasks
        }

        executor.shutdown(); // Stop accepting new tasks after completion
	}
	
	public static int factorial(int num) {
		
		try {
			// Simulating heavy computation
			Thread.sleep(1000); // 1 second, just to assume heavy task
		} catch(InterruptedException ie) {
			
		}
		int result=1;
		
		for(int i=1; i<=num; i++)
			result *= i;
		
		return result;
	}
}

class MyTask implements Runnable {
	
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " executing task...");
    }
}