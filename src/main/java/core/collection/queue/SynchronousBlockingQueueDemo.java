package core.collection.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**	Creates a SynchronousQueue with nonfair access policy
 * 
 * 	Each insert operation must wait for corresponding remove operation by another thread 
 * 	& vice-versa
 *	It can not store elements, Capacity of at most one element
 */
public class SynchronousBlockingQueueDemo {

	public static void main(String[] args) {

		BlockingQueue<String> queue = new SynchronousQueue<>();
		
		Thread producer = new Thread(()->{
			try {
				
				System.out.println("Producer waiting to transfer");
				queue.put("Hello");
				System.out.println("Producer transfered message...");
			} catch(Exception ignored) {
				Thread.currentThread().interrupted();
				System.out.println("Producer interrupted....");
			}
		});
		
		Thread consumer = new Thread(()->{
			try {
				
				System.out.println("Consumer waiting to receive");
				String msg = queue.take();
				System.out.println("Consumer received message: "+msg);
			} catch(Exception ignored) {
				Thread.currentThread().interrupted();
				System.out.println("Consumer interrupted....");
			}
		});
		
		producer.start();
		consumer.start();
	}
}
