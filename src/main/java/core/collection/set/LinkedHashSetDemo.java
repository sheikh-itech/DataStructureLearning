package core.collection.set;

import java.util.Set;
import java.util.LinkedHashSet;

/**	Maintains insertion order
 * 	Slightly slower than HashSet due to maintaining order (O(1) for basic operations)
 */
public class LinkedHashSetDemo {

	public static void main(String[] args) {

		Set<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add("Apple");
		linkedHashSet.add("Banana");
		linkedHashSet.add("Cherry");
		
		System.out.println(linkedHashSet);
	}
}
