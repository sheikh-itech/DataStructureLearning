package core.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**	Executes tasks with delays or periodic execution
 * 	Best for timed or recurring tasks
 * 
 * 	newScheduledThreadPool(n):
 * 		Creates a thread pool that can schedule commands to run after a given delay, 
 * 		or to execute periodically
 */
public class ExecutorScheduledTasks {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		
		ExecutorService executor = Executors.newScheduledThreadPool(3);
		
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
