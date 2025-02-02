package core.collection.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**	Thread-safe, lock-free implementation
 * 	Elements are ordered in FIFO
 * 	Allows Null elements
 *	High throughput(faster) in concurrent environments
 *	Usage-> When a thread-safe queue is required without blocking
 */
public class ConcurrentLinkedQueueDemo {

	public static void main(String[] args) {

		long currentTime = System.currentTimeMillis();
		
		//Compare and swap technique
		
		ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
		
		Thread producer = new Thread(()-> {
			int count=0;
			while(true) {
				try {
					System.out.println("Produced: "+count);
					queue.add(count++);	//put not available since non blocking
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
					//take not available since non blocking
					System.out.println("Consumed: "+queue.poll());
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
