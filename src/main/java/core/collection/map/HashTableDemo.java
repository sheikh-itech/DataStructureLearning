package core.collection.map;

import java.util.Enumeration;
import java.util.Hashtable;

/**	Legacy Class
 * 	Null key-values not allowed
 * 	All methods are synchronized, means it is thread-safe
 * 	
 * 	*It is now replaced by ConcurrentHashMap*
 * 	
 * 	Only Linked List in case of Collision
 * 
 * 	Average-case complexity: O(1)
 * 
 * 	Slower compared to HashMap in single-threaded use
 */
public class HashTableDemo {

	public static void main(String[] args) {

		Hashtable<Integer, String> table = new Hashtable<>();
		table.put(1, "Bob");
		table.put(2, "Sofiya");
		table.put(3, "Alice");
		
		System.out.println(table);
		
		Enumeration<Integer> keys = table.keys();
		Enumeration<String> values = table.elements();
	}
}
