package hari_krishna.collection;

import java.util.ArrayList;
import java.util.List;

/**		ArrayList		<br/>
 * 	
 * 	1. Non Thread Safe
 * 	2. Maintains Indexed/Insertion Order
 * 	3. Elements removal/addition from Mid, makes ArrayList slow 
 */

public class ArrayListDemo {

	public static void main(String[] args) {
		
		/** Array List Simple Object Creation */
		List<String> names = new ArrayList<>();
		names.add("Sheikh");
		names.add("Hapheej");
		names.add("Mansoori");
		
		/** ArrayList Object Creation With Capacity */
		List<String> capacity = new ArrayList<>(35);
		System.out.println("Size: "+capacity.size());
		/** ArrayList Object Creation From Other List/Collection */
		
		List<String> duplicate = new ArrayList<>(names);
		duplicate.add("Make Original");
		
	}
}
