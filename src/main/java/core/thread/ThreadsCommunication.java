package core.thread;

/**	Thread communication saves CPU time & Resources
 *	wait, notify, notifyAll are methods for thread communication
 *	can call above three methods from synchronized methods or block
 *
 *	notify() sends signal to locked object that other waiting thread can not access
 *
 *	Thread Safe: Any object is thread safe if it guarantee that expected result won't come
 *				 and no race condition will happen, when multiple threads will try to access
 *				 object (code block/method)
 */
public class ThreadsCommunication {

	public static void main(String[] args) {

		SharedResource resource = new SharedResource();
		
		Thread producer = new Thread(new Producer(resource), "Thread-1");
		Thread consumer = new Thread(new Consumer(resource), "Thread-2");
		
		producer.start();
		consumer.start();
	}
}

class SharedResource {
	
	private int data;
	private boolean hasData;
	
	
	public synchronized void produce(int value) {	//lock on object for method
		
		while(hasData) {
			try {
				wait();
			} catch(InterruptedException ie) {
				System.err.println(Thread.currentThread().getName()+" interrupted");
				Thread.currentThread().interrupt();
			}
		}
		data = value;
		hasData = true;
		System.out.println("Produced: "+data);
		
		notify();
	}
	
	public synchronized int consume() {	//lock on object for method
		
		while(!hasData) {
			try {
				wait();
			} catch(InterruptedException ie) {
				System.err.println(Thread.currentThread().getName()+" interrupted");
				Thread.currentThread().interrupt();
			}
		}
		
		hasData = false;
		System.out.println("Consumed: "+data);

		notify();
		
		return data;
	}
}

class Producer implements Runnable {

	private SharedResource resource;
	
	public Producer(SharedResource resource) {
		this.resource = resource;
	}
	
	@Override
	public void run() {
		
		for(int i=0; i<10; i++)
			resource.produce(i);
	}
}

class Consumer implements Runnable {

	private SharedResource resource;
	
	public Consumer(SharedResource resource) {
		this.resource = resource;
	}
	
	@Override
	public void run() {
		
		for(int i=0; i<10; i++) 
			resource.consume();
	}
}