package core.collection.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**	element(): Inserts the specified element into this queue if it is possible to do so 
 * 			immediately without violating capacity restrictions
 * 			When using a capacity-restricted queue
 *
 *			LinkedList
 *	Implements both Queue and Deque interfaces
 *
 *	Allows many null elements
 *	Insertion order
 *
 *	Insertion order
 *	offer, poll: O(1)
 *
 *	Adds element to tail & removes from head
 */
public class QueueWithLinkedList {

	public static void main(String[] args) {

		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(15);	// Enqueue operation, adds in last
		queue.add(7);	// Enqueue operation, adds in last
		queue.add(12);	// Enqueue operation, adds in last
		
		queue.add(null);
		queue.add(null);
		
		queue.forEach(ele->System.out.print(ele+", "));
		System.out.println();
		
		// Dequeue operation, Retrieves and Removes head element, Exception if empty
		queue.remove();
		queue.peek(); 	// Or queue.getFirst(); //no exception if empty
		
		queue.element();//Retrieves head of queue, exception if empty
		
		queue.offer(14);	//Adds element
		queue.forEach(ele->System.out.print(ele+", "));
		System.out.println();
		
		queue.poll();	//Retrieves and removes head element
		
		queue.forEach(ele->System.out.print(ele+", "));
		
		
		/** Linked List As Deque **/
		
		Deque<Integer> deque = new LinkedList<>();
		deque.addFirst(10);
		deque.addLast(20);
		System.out.println(deque.removeLast());
	}
}
