package core.collection.map;

import java.util.SortedMap;
import java.util.TreeMap;

/**	Null key not allowed bcz Required in Comparison
 * 
 * 	Sorted, navigable map, maintains Natural Sorting Order
 * 	
 * 	Supports custom comparator for a different sorting order
 * 
 * 	Internally, TreeMap is implemented as a red-black tree, a self-balancing binary search tree
 *
 *	lowerKey(K key) => Lower key <
 *	floorKey(K key) => Lower key or equals <=
 *
 *	Put, Get & Remove have a time complexity of O(log n) due to the underlying red-black tree
 *
 *	Slightly more memory usage compared to HashMap due to the tree structure
 */
public class SortedMapDemo {

	public static void main(String[] args) {

		SortedMap<String, Integer> names = new TreeMap<>();
		
		names.put("Zaid", 1);
		names.put("Sofia", 2);
		names.put("Bob", 3);
		names.put("Alice", 4);
		
		System.out.println(names);
		
		//Specific to SortedMap that not belongs to Map
		
		System.out.println(names.firstKey());
		System.out.println(names.lastKey());
		System.out.println(names.headMap("Bob"));
		System.out.println(names.tailMap("Bob"));
		
		SortedMap<String, String> names1 = new TreeMap<>();
		names1.put("A", null);
	}
}
