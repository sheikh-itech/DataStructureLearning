package core.collection.set;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**	Implements Set using a red-black tree
 * 	Maintains elements in sorted order (natural or custom via a Comparator)
 * 	Does not allow null elements
 * 	Logarithmic time (O(log n)) for basic operations
 * 
 *  When duplicates are not allowed, and elements need to be sorted
 */
public class TreeSetDemo {

	public static void main(String[] args) {

		Set<String> treeSet = new TreeSet<>();

		treeSet.add("Banana");
		treeSet.add("Apple");
		treeSet.add("Cherry");
		
		System.out.println(treeSet);
		
		/* Not recommended since synchronized & internally red black tree overhead */
		Set<String> syncSet = Collections.synchronizedSet(treeSet); //Very Bad Idea
		
		for(String fruit:syncSet)
			System.out.println(fruit);
	}
}
