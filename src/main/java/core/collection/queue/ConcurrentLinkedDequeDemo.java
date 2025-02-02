package core.collection.queue;

import java.util.concurrent.ConcurrentLinkedDeque;

/**	Supports lock-free, thread-safe operations [Opposite to LinkedBlockingQueue]
 * 	Double ended [Compare and swap technique since lock free]
 * 	Null not allowed
 * 	High throughput in concurrent environments
 * 
 * 	Usage-> Thread-safe, non-blocking double-ended queue
 */
public class ConcurrentLinkedDequeDemo {

	public static void main(String[] args) {

		ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>();
		
		deque.add("Ele-1"); deque.add("Ele-2"); deque.add("Ele-3");
		
		deque.addFirst("Ele-0"); 
		deque.addLast("Ele-10");
		
		deque.forEach(ele->System.out.println(ele));
	}
}
