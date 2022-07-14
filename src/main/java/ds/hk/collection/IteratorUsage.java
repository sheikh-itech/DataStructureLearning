package ds.hk.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *	Iterator is meant to retrieve data from "Non Indexed Collection"
 *	Like: Set, LinkedList bcz getXXX() not given here
 */

public class IteratorUsage {

	public static void main(String[] args) {
		
		Set<Integer> nums = new HashSet<>();
		nums.add(1);
		nums.add(11);
		nums.add(19);
		nums.add(7);
		nums.add(2);
		
		//This will remove '0' element but Not From '0' Index
		nums.remove(0);
		
		//Set is Not Index Based, So Iterator needed
		//nums.get(0);
		
		Iterator<Integer> itr = nums.iterator();
		int size = nums.size();
		while(itr.hasNext()) {
			System.out.println(itr.next());
			
			size--;
			if(size<=nums.size()/2)
				break;	//breaking to see functionality of forEachRemaining(action)
		}
		
		//This Iterator methods Iterates over Remaining Elements Only
		itr.forEachRemaining(action-> {
			System.out.println("Byte value of "+action+", byte: "+action.byteValue());
		});
		
		Iterator<Integer> itr1 = nums.iterator();
		while(itr1.hasNext()) {
			//If we first call remove() then next()
			//It will CE::IllegalStateException
			
			int n = itr1.next();
			itr1.remove();
			System.out.println(n+" removed");
		}
		System.out.println(nums);
	}
}
