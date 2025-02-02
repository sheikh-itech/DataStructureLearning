package core.thread.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceFuture {

	public static void main(String[] args) {

		ExecutorService executor =  Executors.newSingleThreadExecutor();

		//Runnable run = () -> 45; -> run method don't return anything
		
		Runnable run = () -> System.out.println("Future example");
		
		Callable<Integer> callable = () -> 45;
		
		Future<Integer> future1 = executor.submit(callable);
		
		Future<?> future2 = executor.submit(run);
		
		try {
			//Future get() method blocks thread to finish
			System.out.println("Callable Future: "+future1.get());
			
			//future.get(1000, TimeUnit.MILLISECONDS);
			
			System.out.println("Runnable Furute: "+future2.get());
		} catch (Exception ex) {
			System.out.println(Thread.currentThread().getName()+" interrupted");
		}
		
		//Returns true if this task was cancelled before it completed normally
		System.out.println("Is Cancelled: "+future1.isCancelled());
		
		/* Returns true if this task completed.Completion may be due to normal termination, 
		 * an exception, or cancellation -- in all of these cases, it will return true */
		System.out.println("Is done: "+future1.isDone());
		
		//Attempts to cancel execution of this task, if running, but no guarantee
		future1.cancel(true);
		
		
		Callable<Integer> callable1 = () -> {
			
			try {
				Thread.sleep(3000);
			} catch(Exception ex) {
				System.err.println("Error: "+ex.getMessage());
			}
			System.out.println("Callable3 runed after cancel...");
			return 47;
		};
		
		Future<Integer> future3 = executor.submit(callable1);
		try {
			Thread.sleep(3001);
		} catch (InterruptedException e) {
			System.err.println("Error: "+e.getMessage());
		}
		
		future3.cancel(true);
		System.out.println("Future3 cancled: "+future3.isCancelled());
		
		executor.shutdownNow();
		
		/* Attempts to stop all actively executing tasks, halts the processing of waiting 
		 * tasks, and returns a list of the tasks that were awaiting execution*/
	}
}
