package core.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**	Creates a fixed number (n) of threads
 *	Best for CPU-bound tasks (limited resources)
 *	
 *	newFixedThreadPool(n):
 *	Creates a thread pool that reuses a fixed number of threads operating off a shared 
 *	unbounded queue,
 *	Threads in the pool will exist until it is explicitly shutdown
 */
public class ExecutorFixedSizePool {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		
		// Fixed pool size 3
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for(int i=1; i<10; i++) {
			
			int effectiveFinal = i;	//effective final variable needed inside thread
			
			executor.submit(() ->{
				System.out.print(BasicExecutor.factorial(effectiveFinal)+", ");
			});
		}
		
		executor.shutdown();	// Prevents new tasks from being submitted
		
		try {
			// ✅ Waits for all tasks to complete, or 10 seconds, whichever first
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        	System.err.println(Thread.currentThread().getName()+" interrupted");
        }
		
		System.out.println("\nExecutor Final time: "+ (System.currentTimeMillis()-startTime));
	}
}
