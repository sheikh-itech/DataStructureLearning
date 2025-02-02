package core.thread.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**	ScheduledExecutorService is better than 'Timer' because it supports multiple threads, 
 * 	Callable, Future, and proper exception handling
 * 
 * 	schedule(Runnable, delay, TimeUnit):
 * 		Submits a one-shot task that becomes enabled after the given delay
 * 
 * 	schedule(Callable<V>, delay, TimeUnit)
 * 		Submits a value-returning one-shot task that becomes enabled after the given delay
 * 
 * 	scheduleAtFixedRate(Runnable, initialDelay, period, TimeUnit)
 * 		Fixed intervals, High-frequency tasks
 * 		Tasks can overlap if execution time > period
 * 		Submits a periodic action that becomes enabled first after given initial delay, 
 * 		and subsequently with the given period, even if previous task not finished
 * 
 * 	scheduleWithFixedDelay(Runnable, initialDelay, delay, TimeUnit)
 * 		Waits for previous task to finish + delay
 * 		No overlap, always waits
 * 		Long-running tasks
 * 		Submits a periodic action that becomes enabled first after given initial delay, 
 * 		and subsequently with the given delay between the termination of one execution and 
 * 		the commencement of the next
 */
public class ScheduledExecutorServiceDemo {

	public static void main(String[] args) {

		ScheduledExecutorService schedular = Executors.newScheduledThreadPool(5);
		
		schedular.schedule(
				() -> System.out.println("Runnable task scheduled to run after 3 sec"),
				3, 
				TimeUnit.SECONDS
			);
		
		
		ScheduledFuture<?> future1 = schedular.scheduleAtFixedRate(
				() -> System.out.println("Runnable FixedRate Task runs after 5 sec & every 2 sec"),
				5,
				2,
				TimeUnit.SECONDS
			);
		
		System.out.println("Is future1 done: "+future1.isDone());
		
		schedular.scheduleWithFixedDelay(
					() -> System.out.println("Runnable FixedDelay Task runs after 5 sec & every 2 sec"),
					5,
					3,
					TimeUnit.SECONDS
				);
		//schedular.shutdown();
		
		/* Alternate shutdown to run fixedRate scheduler, 
		 * since periodic scheduler may not added in queue at the time shutdown called */
		schedular.schedule(
				()->{
					System.out.println("Initiating shutdown...");
					schedular.shutdown();
				}, 
				20, 
				TimeUnit.SECONDS
			);
	}
}
