package core.thread.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**	CountDownLatch is a synchronization mechanism in Java used to block threads until
 * 	a specific number of operations are completed
 * 
 *	await():
 *		The main thread blocks at latch.await() until all workers finish
 *		When we call countDown() and latch reaches zero, then main thread continues
 *
 *	countDown():
 *		Once count down finishes/0, it can not reset
 */
public class CountDownLatchDemo {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		service.submit(new DependentService());
		service.submit(new DependentService());
		service.submit(new DependentService());
		
		// This will give wrong time...since no get() or invokeAll() or not joined main thread
		System.err.println("All services finished (wrong result)..."
				+ (System.currentTimeMillis()-startTime)+" millisec");
		
		service.shutdown();
	
/* CountDownLatch with Executor Service */
		
		int numberOfServices = 3;
		
		startTime = System.currentTimeMillis();
		
		CountDownLatch latch = new CountDownLatch(numberOfServices);
	
		ExecutorService exeService = Executors.newFixedThreadPool(3);
		
		exeService.submit(new DependentService(latch));
		exeService.submit(new DependentService(latch));
		exeService.submit(new DependentService(latch));
		
		try {
			
			latch.await();	// waits for all tasks to be finished
			
		} catch (InterruptedException ex) {
			System.err.println("Error: "+ex.getMessage());
		}
		
		System.out.println("All dependent latch services finished..."
				+ (System.currentTimeMillis()-startTime)+" millisec");
		
		exeService.shutdown();

/* CountDownLatch with Thread */
		
		startTime = System.currentTimeMillis();
		
		latch = new CountDownLatch(numberOfServices);
		
		for(int i=0; i< numberOfServices; i++)
			new Thread(new DependentService1(latch)).start();
		
		try {
			
			/* Causes the current thread to wait until the latch has counted down to zero, 
			 * unless the thread is interrupted */
			latch.await();
			
			//Only waits for given time not for task completion, after time...main finishes itself
			//latch.await(5, TimeUnit.MILLISECONDS);
			
		} catch (InterruptedException ex) {
			System.err.println("Error: "+ex.getMessage());
		}
		
		System.out.println("All dependent threads finished..."
				+ (System.currentTimeMillis()-startTime)+" millisec");
	}
}

class DependentService implements Callable<String> {

	private CountDownLatch latch;
	
	public DependentService() {	}
	
	public DependentService(CountDownLatch latch) {
		this.latch = latch;
	}
	@Override
	public String call() throws Exception {

		Thread.sleep(2000);
		
		if(latch!=null)
			latch.countDown();	// Counts remaining latch jobs

		System.out.println(Thread.currentThread().getName()+" service started");
		
		return "Ok";
	}
}

class DependentService1 implements Runnable {

	private CountDownLatch latch;
	
	public DependentService1() {	}
	
	public DependentService1(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			System.out.println("Error: "+ex.getMessage());
			Thread.currentThread().interrupt();
		}

		System.out.println(Thread.currentThread().getName()+" service started");
		
		if(latch!=null)
			latch.countDown();	// Counts remaining latch jobs
	}
}