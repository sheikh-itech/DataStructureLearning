package core.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**	Creates threads as needed, reuses idle threads
 * 	Best for many short-lived tasks
 * 
 * newCachedThreadPool():
 * 	Creates a thread pool that creates new threads as needed, but will reuse previously 
 * 	constructed threads when they are available
 */
public class ExecutorDynamicPool {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
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
