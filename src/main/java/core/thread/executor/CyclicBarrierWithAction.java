package core.thread.executor;

import java.util.concurrent.CyclicBarrier;

/**	CyclicBarrier is a synchronization mechanism that allows a group of threads to wait for 
 * 	each other at a common barrier point [await()] before proceeding further
 * 
 * 	The barrier action runs once all threads reach the barrier
 * 
 * 	Use the barrier action to execute a task once all threads reach the barrier
 * 	Useful for merging results, logging, or preparing data
 */
public class CyclicBarrierWithAction {

	public static void main(String[] args) {

		int numberOfServices = 4;
		
		Runnable barrierAction = new Runnable() {
			
			@Override
			public void run() {
				
				System.err.println("All systems are up and running...");
				System.err.println("System startup completed...");
			}
		};
		CyclicBarrier barrier = new CyclicBarrier(numberOfServices, barrierAction);
		
		Thread webServer = new Thread(new SubSystem("Web Server", 2000, barrier));
		Thread uiServer = new Thread(new SubSystem("UI Server", 2500, barrier));
		Thread dbServer = new Thread(new SubSystem("DB Server", 4500, barrier));
		Thread msgServer = new Thread(new SubSystem("Messaging Server", 2500, barrier));
		
		webServer.start();
		uiServer.start();
		dbServer.start();
		msgServer.start();
		
	}
}

class SubSystem implements Runnable {

	private String name;
	private int initializationTime;
	private CyclicBarrier barrier;
	
	public SubSystem(String name, int initializationTime, CyclicBarrier barrier) {
		
		this.name = name;
		this.initializationTime = initializationTime;
		this.barrier = barrier;
	}
	
	@Override
	public void run() {
		
		try {
			
			System.out.println(name + " initialization started...");
			
			Thread.sleep(initializationTime); // Assume loading time
			
			System.out.println(name + "Initialization complete...");
			
			barrier.await();	// All threads reach here then Barrier Action Performed
		} catch(Exception ex) {
			System.err.println("Error: "+ex.getMessage());
		}
	}
}