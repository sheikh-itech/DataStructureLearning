package core.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**	Executes tasks one at a time
 * 	Best for sequential execution (e.g., logging)
 * 
 * 	newSingleThreadExecutor()
 * 		Creates an Executor that uses a single worker thread operating off an unbounded queue
 * 		If one interrupted or fails, new one take care of task
 * 		Tasks are guaranteed to execute sequentially
 */
public class ExecutorSingleThread {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
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
