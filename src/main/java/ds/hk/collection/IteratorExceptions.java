package ds.hk.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IteratorExceptions {

	public static void main(String[] args) {

		Set<Integer> nums = new HashSet<>();
		nums.add(1);
		nums.add(11);
		nums.add(19);
		nums.add(7);
		nums.add(2);
		
		Iterator<Integer> itr = nums.iterator();
		
		//RE=>java.lang.IllegalStateException
		//itr.remove();
		
		//This will also work fine
		itr.next();
		
		/**	hasNext() called to confirm End Of Iterator Or Not */
		
		while(itr.hasNext()) {
			
		//RE => java.util.ConcurrentModificationException
			//nums.add(0);
			itr.next();
		}
		
		//This will work fine bcz hashNext() & next() called for Iterator
		itr.remove();
	}
}
