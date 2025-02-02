package core.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**	Traverses the collection in a forward-only direction
 * 	Can remove elements during iteration using remove method
 * 
 * 	For-Each Loop internally uses Iterator
 * 
 * 	Index base Access->	Not supported
 * 
 * 	If the underlying collection is structurally modified while iterating 
 * 	(other than through the iterator's remove() method), 
 * 	the iterator throws a ConcurrentModificationException
 */
public class IteratorDemo {

	public static void main(String[] args) {

		List<Integer> nums = new ArrayList<>();
		nums.add(5); nums.add(3); nums.add(4);
		nums.add(6); nums.add(7); nums.add(9);
		
		Iterator<Integer> itr = nums.iterator();
		
		while(itr.hasNext()) {
			
			if(itr.next()%2==0)
				itr.remove();
		}
		
		System.out.println(nums);
	}
}
