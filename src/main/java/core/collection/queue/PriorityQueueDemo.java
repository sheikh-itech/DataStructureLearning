package core.collection.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**	An unbounded priority heap-based queue	[FIFO (First-In-First-Out)]
 * 	Ordered queue [Default ordering is natural]
 * 	Elements are ordered based on their natural order or a custom Comparator
 * 	Null not allowed
 * 	
 * 	offer, poll, peek: O(log n)
 * 
 * 		Internal Working
 * 	Works in min-heap based [In min heap parent element value is less then both child (left-right)]
 * 
 * 	O(n) -> Traverse all element
 * 	log(n)	-> Traverse half element
 */
public class PriorityQueueDemo {

	public static void main(String[] args) {

		//Default order is ascending for numbers
		PriorityQueue<Integer> nums = new PriorityQueue<>();
		
		nums.add(5);
		nums.add(12);
		nums.add(9);
		
		while(!nums.isEmpty())
			System.out.print(nums.poll()+", ");	//toString() not returns element in order
		
		nums.add(5);
		nums.add(12);
		nums.add(9);
		
		//Lowest priority first output-> 5, Numbers ordered in natural order so 5 is head
		System.out.println("\n"+nums.poll());
		System.out.println("-------------");
		
		//PriorityQueue<Integer> nums1 = new PriorityQueue<>((x, y) -> y-x); //Same as below
		PriorityQueue<Integer> nums1 = new PriorityQueue<>(Comparator.reverseOrder());
		nums1.add(5);
		nums1.add(12);
		nums1.add(9);
		
		while(!nums1.isEmpty())
			System.out.print(nums1.poll()+", ");
	}
}
