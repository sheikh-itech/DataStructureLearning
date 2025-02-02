package core.collection.list;

import java.util.LinkedList;

/**	Insertion & Deletion
 * 		Better for frequent insertion & deletion in middle because element shift not required
 * 		only pointer address changes
 * 	Random Access
 * 		Slower random access because it need to traverse each element till actual one
 * 	Memory Overhead
 * 		It requires more memory because it stores reference to next node for each node &
 * 		previous node
 */
public class LinkedListDemo {

	public static void main(String[] args) {

		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(7);
		list.addLast(22);	//O(1)
		list.add(5);
		list.add(6);
		list.addFirst(7);	//O(1)
		list.add(1, 12);
		
		System.out.println(list);
		
		list.get(2);	//O(n)
		list.getLast();	//O(1)
		
		System.out.println("\nLast element: "+list.getLast());
		
		list.removeIf(x -> x%6==0);
		
		System.out.println(list);
	}
}
