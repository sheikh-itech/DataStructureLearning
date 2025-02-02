package core.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NeedOfExecutor {

	public static void main(String[] args) {
		
		Thread [] threads = new Thread[9];
		
		long startTime = System.currentTimeMillis();
		
		for(int i=1; i<10; i++)
			System.out.print(BasicExecutor.factorial(i)+", ");
		
		System.out.println("\nSingle Thread Final time: "+ (System.currentTimeMillis()-startTime));
		
		startTime = System.currentTimeMillis();
		
		for(int i=1; i<10; i++) {
			
			int effectiveFinal = i;	//effective final variable needed inside lambda
			
			threads[i-1] = new Thread(() ->{
				System.out.print(BasicExecutor.factorial(effectiveFinal)+", ");
			});
			threads[i-1].start();
		}
		
		for(int i=0; i<10; i++) {
			
			try {
				threads[i].join();
			} catch(Exception ex) {
				
			}
		}
		System.out.println("\nMulti Thread Final time: "+ (System.currentTimeMillis()-startTime));
		
		
	/* Instead of creating and managing self threads pool, Executors help us here */
		
		startTime = System.currentTimeMillis();
		
		ExecutorService executor = Executors.newFixedThreadPool(9);
		
		for(int i=1; i<10; i++) {
			
			int effectiveFinal = i;	//effective final variable needed inside lambda
			
			executor.submit(() ->{
				System.out.print(BasicExecutor.factorial(effectiveFinal)+", ");
			});
		}
		
/* shutdown()-> Initiates an orderly shutdown in which previously submitted tasks are 
 * executed, but no new tasks will be accepted
 * 
 * This method does not wait for previously submitted tasks to complete execution.
 * Use awaitTermination to do that
*/
		executor.shutdown();	// Prevents new tasks from being submitted
		
		try {
			// ✅ Waits for all tasks to complete, or 10 seconds, whichever first
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        	System.err.println(Thread.currentThread().getName()+" interrupted");
        }
		
		System.out.println("\nExecutor Final time: "+ (System.currentTimeMillis()-startTime));
		
	// with pool size 3
		
		startTime = System.currentTimeMillis();
		
		ExecutorService executor1 = Executors.newFixedThreadPool(3);
		
		for(int i=1; i<10; i++) {
			
			int effectiveFinal = i;	//effective final variable needed inside thread
			
			executor1.submit(() ->{
				System.out.print(BasicExecutor.factorial(effectiveFinal)+", ");
			});
		}
		
		executor1.shutdown();	// Prevents new tasks from being submitted
		
		try {
			// ✅ Waits for all tasks to complete, or 10 seconds, whichever first
            executor1.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        	System.err.println(Thread.currentThread().getName()+" interrupted");
        }
		
		System.out.println("\nExecutor Final time: "+ (System.currentTimeMillis()-startTime));
	}
}
