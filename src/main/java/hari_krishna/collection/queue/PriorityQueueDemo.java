package hari_krishna.collection.queue;

import java.util.Iterator;
import java.util.PriorityQueue;

/**			PriorityQueue Should be Comparable Type
 * 
 *	1. Natural Sorting Or Comparator provided @ Definition Time
 *	2. Nulls Not Allowed :: NPException
 *	3. Does Not Permit Non Comparable Objects :: ClassCastException
 *	4. Object cab be created with -> SortedSet, Collection, InitialCapacity,
 *	   Other PriorityQueue, Comparator
 *	5. Operations poll, remove, peek, and element access the element at the head of the queue
 *	6. priority queue is unbounded, but has an internal capacity
 *	7. Not Thread-Safe
 *	8. Duplicates Allowed
 */

public class PriorityQueueDemo {

	public static void main(String[] args) {
		
		PriorityQueue<Patient> queue1 = new PriorityQueue<>();
		queue1.add(new Patient(102, "sheikh", true));
		queue1.add(new Patient(103, "hapheej", false));
		
		PriorityQueue<Patient> queue = new PriorityQueue<>();
		queue.add(new Patient(102, "sheikh", false));
		queue.add(new Patient(101, "sheikh", false));
		queue.add(new Patient(101, "sheikh", true));
		queue.add(new Patient(103, "hapheej", false));
		
		queue.offer(new Patient(104, "hapheej", false)); //Inserts @ last of queue
		System.out.println(queue);
		System.out.println("Queue Contains(): "+queue.contains(new Patient(101, "sheikh", false)));
		
		System.out.println("Remove head Element: "+queue.remove());//Removes&Retrieves the head
		System.out.println("Remove Element: "+queue.remove(new Patient(104, "hapheej", false)));
		System.out.println("RemoveAll From Other Collection: "+queue.removeAll(queue1));
		
		queue.add(new Patient(106, "hapheej", false));
		queue.add(new Patient(105, "hapheej", false));
		
		queue.forEach(action->{
			System.out.println("{"+action.getNumber()+", "+action.getName()+", "+action.isSerious()+"}");
		});
		
		Iterator<Patient> itr = queue.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("Remove head poll()"+queue.poll());
		System.out.println(queue);
	}
}
