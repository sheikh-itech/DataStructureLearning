package core.collection.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**	Thread Safe
 * 	Uses a fixed-size array to store elements
 * 	Usage-> When a bounded blocking queue is needed
 * 	Simplify concurrency  problem like-> Consumer-Producer
 * 	Waits for queue to become not-empty
 * 	Bounded blocking queue backed by Circular array
 * 	Single lock [Produced & Consumer shares single lock OR Enqueue & Dequeue shares single lock]
 * 
 * 	put-> Blocks if queue is full until space become available
 * 	take -> Blocks if queue empty until elements become available
 * 	offer-> Waits for space available until specified time
 * 
 * 	Usage-> When a bounded blocking queue is needed
 */
public class ArrayBlockingQueueDemo {

	public static void main(String[] args) {

		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);
		
		queue.add(4);
		queue.add(7);
		//queue.add(9);	//CE::Queue full
		
		queue.offer(9);	//No CE, but since queue full, it will not add element

		try {
			//Retrieve & remove element from head
			queue.take();	//Waits if required to fetch element
		} catch (InterruptedException e) {}	
		
		System.out.println(queue);
		
		System.out.println("Producer-Consumer\n-----------------");
	//Producer-Consumer
		
		BlockingQueue<Integer> conProd = new ArrayBlockingQueue<>(2);
		
		Thread producer = new Thread(new Producer(conProd));
		Thread consumer = new Thread(new Consumer(conProd));
		producer.start();
		consumer.start();
	}
}

class Producer implements Runnable {

	private BlockingQueue<Integer> queue;
	private int value;
	
	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
		
		while(true) {
			try {
				System.out.println("Producer produced: "+value);
				queue.put(value++);
				Thread.sleep(500);
			} catch(Exception ex) {
				Thread.currentThread().interrupted();
				System.out.println("Producer interupted");
			}
		}
	}
}

class Consumer implements Runnable {

	private BlockingQueue<Integer> queue;
	
	public Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
		
		while(true) {
			try {
				int value = queue.take();
				System.out.println("Consumer consumed: "+value);
				Thread.sleep(700);
			} catch(Exception ex) {
				Thread.currentThread().interrupted();
				System.out.println("Consumer interupted");
			}
		}
	}
}