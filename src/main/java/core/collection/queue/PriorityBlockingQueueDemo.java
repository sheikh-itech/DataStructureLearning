package core.collection.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**	Initially capacity 11
 * 	Head element will be based on priority
 * 		[In number case lowest number will be in head]
 * 	Binary heap as array & can grow dynamically
 *	Unbounded queue
 *
 *	Extends PriorityQueue with blocking capabilities
 *	Usage-> Priority-based blocking queue
 */
public class PriorityBlockingQueueDemo {

	public static void main(String[] args) {
		
		BlockingQueue<Integer> queue = new PriorityBlockingQueue<>();
		
		queue.add(9);
		queue.add(8);
		queue.add(2);
		queue.add(14);
		queue.add(3);
		
		queue.forEach(ele->System.out.print(ele+", "));
	}
}
