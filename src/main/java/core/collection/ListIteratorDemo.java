package core.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**	ListIterator for bidirectional, only for List type
 * 
 * 	Can set/update, add, remove elements while accessing/reading
 *
 */
public class ListIteratorDemo {

	public static void main(String[] args) {
		
		List<Integer> nums = new ArrayList<>();
		nums.add(5); nums.add(3); nums.add(4);
		nums.add(6); nums.add(7); nums.add(9);
		
		ListIterator<Integer> itr = nums.listIterator();
		
		while(itr.hasNext()) {
			
			int val = itr.next();
			
			if(val%2==0)
				itr.remove();
			
			else if(val==9)
				itr.set(19);	//Updating value
			
			else if(val==3)
				itr.add(13);	//Adding new value
		}
		
		System.out.println(nums);
	}
}
