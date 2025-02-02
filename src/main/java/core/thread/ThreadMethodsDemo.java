package core.thread;

public class ThreadMethodsDemo extends Thread {

	public static void main(String[] args) throws Exception {

		ThreadMethodsDemo t1 = new ThreadMethodsDemo();
		ThreadMethodsDemo t2 = new ThreadMethodsDemo();
		ThreadMethodsDemo t3 = new ThreadMethodsDemo();
		
		t1.setName("Thread-1");
		t1.setPriority(MIN_PRIORITY);
		
		t2.setName("Thread-2");
		t2.setPriority(NORM_PRIORITY);
		
		t3.setName("Thread-3");
		t3.setPriority(MAX_PRIORITY);
		
		t1.start();	// Thread method
		t2.start();
		t3.start();
		
		t2.interrupt();	//Stop thread in current state

		t1.join(); // Thread method, main thread waits for t1 thread to complete
		
		System.out.println("Main thread, print's after Thread-1 completion");
		
		Thread t = new Thread();	//Can instantiate Thread class directly but useless
		t.start();
	}

	@Override
	public void run() {

		for(int i=1; i<6; i++) {
			
			System.out.println("Name: "+getName()+", priority: "+getPriority()+", count: "+i);
			
			try {
				Thread.sleep(1000);	// Thread method
				
	// Hint to processor that you can give change to other thread, Processor can ignore it
				Thread.yield();
				
			} catch (InterruptedException e) {
				System.err.println("Thread "+getName()+" "+e.getMessage());
			}
		}
	}
}
