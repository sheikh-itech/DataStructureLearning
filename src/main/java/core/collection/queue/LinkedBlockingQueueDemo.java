package core.collection.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**	Initial capacity Integer.MaxValue
 * 	Thread-safe with separate locks for put and take operations
 * 	Bounded blocking queue backed by LinkedList
 * 	Double lock for both end for Enqueue & Dequeue operations
 * 	Higher concurrency for Producer-Consumer [Use if high number of threads]
 * 
 * 	Usage-> When blocking operations are required for both ends
 */
public class LinkedBlockingQueueDemo {

	public static void main(String[] args) {
		
		long currentTime = System.currentTimeMillis();
		
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
		
		Thread producer = new Thread(()-> {
			int count=0;
			while(true) {
				try {
					System.out.println("Produced: "+count);
					queue.put(count++);	//uses lock internally while put values
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("Producer interrupted...");
				}
				
				if((System.currentTimeMillis()-10000)>currentTime)
					break;
			}
		});
		
		Thread consumer = new Thread(()-> {
			while(true) {
				try {
					int value = queue.take();	//can wait & uses lock internally
					System.out.println("Consumed: "+value);
					Thread.sleep(1100);
				} catch (InterruptedException e) {
					System.out.println("Producer interrupted...");
				}
				
				if((System.currentTimeMillis()-10055)>currentTime)
					break;
			}
		});
		
		producer.start();
		consumer.start();
	}
}
