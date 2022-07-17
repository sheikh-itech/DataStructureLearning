package ds.hk.collection.queue;

import java.util.ArrayDeque;
import java.util.Iterator;

/**			It Is Double Ended Array Queue
 * 
 *	1. Resizable-array implementation of the Deque interface 
 *	2. No Capacity Restrictions
 *	3. Not Thread-Safe
 *	4. Faster if used as Stack in place of Stack
 *	5. Faster if used as LinkedList in place of LinkedList
 *	6. Most ArrayDeque operations run in amortized constant time
 *	7. Exceptions include remove, removeFirstOccurrence, removeLastOccurrence, contains, 
 *	   iterator.remove(), and the bulk operations, all of which run in linear time
 *	8. Insertion Order
 *	9. Null not allowed :: NullPointerException
 */

public class ArrayDequeDemo {

	public static void main(String[] args) {

		ArrayDeque<Integer> nums1 = new ArrayDeque<>();
		nums1.add(98);
		nums1.add(99);
		
		ArrayDeque<Integer> nums = new ArrayDeque<>();		
		nums.add(0);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		nums.add(14);
		nums.add(89);
		nums.add(1);
		nums.addAll(nums1);
		nums.addFirst(11);
		nums.addLast(100);
		nums.offer(101);		//Inserts Element at the end of this deque
		nums.offerFirst(0);		//Inserts in Front
		nums.offerLast(102);	//Inserts Element at the end of this deque
		System.out.println(nums);
		
		System.out.println("Contains 11: "+nums.contains(11));
		System.out.println("First E: "+nums.getFirst());
		System.out.println("Last E: "+nums.getLast());
		
		//Retrieves, but does not remove First
		System.out.println("First->peek(): "+nums.peek());
		//Remove & Return First Element
		System.out.println("First->pop(): "+nums.pop());
		
		nums.push(33); //Inserts @Front Element
		System.out.println("Push to head"+nums);
		System.out.println("Removes the head: "+nums.remove());
		System.out.println("Remove First/head: "+nums.removeFirst());
		System.out.println("Remove Last/tail: "+nums.removeLast());
		System.out.println("Remove from other Collection: "+nums.removeAll(nums1));
		System.out.println("Remove First Occurance: "+nums.removeFirstOccurrence(0));
		System.out.println("To Array: "+nums.toArray());
		System.out.println("Is Empty: "+ nums.isEmpty());
		System.out.println(nums);
		System.out.println("Cloned Array Queue: "+nums1.clone());
		
		System.out.println("For Loop");
		nums.forEach(action->{
			System.out.print(action.intValue()+", ");
		});
		
		System.out.println("\nIterating Using Iterator");
		Iterator<Integer> itr = nums.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next()+", ");
		}
		
		ArrayDeque<String> names = new ArrayDeque<>();
		names.add("sheikh");
		names.add("hapheej");
		names.add("mansoori");
		//names.add(null);		//Not Allowed NullPointerException
		System.out.println(names);
	}
}
