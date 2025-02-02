package core.collection.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**	Unique elements
 *  Un-ordered elements
 *  Allows null elements
 *	Allows single Null
 *	O(1)-> Add, Remove, Contains
 */
public class HashSetDemo {

	public static void main(String[] args) {

		Set<Integer> nums = new HashSet<>();
		nums.add(5); nums.add(7); nums.add(9);
		nums.add(2); nums.add(6); nums.add(17);
		nums.add(null); nums.add(null);			//Only Single Null, replaces duplicate
		
		System.out.println(nums);
		
		Set<Integer> syncNums = Collections.synchronizedSet(nums);
		
		System.out.println(syncNums);
		
		//Number of Elements not restricted like in map
		nums = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11); 
	}
}
