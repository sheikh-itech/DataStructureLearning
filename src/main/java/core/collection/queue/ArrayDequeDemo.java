package core.collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**	Double ended queue [Insertion & removal from both end]
 * 	Supports operations for both -> Queue and Stack
 *	More efficient then LinkedList based Queue
 *
 *	Null not allowed
 *	Low memory since Array implementation don't need nodes to track
 *	Faster iteration [high-performance queue implementation]
 *	No need to shift element in removal [Head & tail index adjust]
 *		[Since it is circular array having both head & tail both need to manage]
 *	Double size in resizing
 *
 *	addFirst, addLast, offerFist, offerLast (Offer methods are Without Exception)
 *	getFirst, getLast, peekFirst, peekLast (Peek methods are without Exception)
 */
public class ArrayDequeDemo {

	public static void main(String[] args) {

		/* ArrayDeque class is likely to be faster than when used as a stack, 
		 * and faster than LinkedList when used as a queue */
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		deque.add(5);
		deque.addFirst(7);
		deque.addLast(9);
		deque.addFirst(9);
		deque.addLast(11);
		//9,7,5,9,11
		deque.offer(12);	//adds element in tail
		deque.offerFirst(9);
		//9,9,7,5,9,11,12
		
		deque.pollLast();	//Without exception
		deque.removeFirst();	//Exception if empty
		//9,7,5,9,11
		deque.forEach(ele->System.out.print(ele+", "));
		
		
	}
}
