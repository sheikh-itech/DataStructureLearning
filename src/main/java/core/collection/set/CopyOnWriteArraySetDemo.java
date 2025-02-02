package core.collection.set;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**	Thread-safe implementation of Set
 * 
 * 	Uses a copy-on-write mechanism: creates a new copy of the underlying array on every modification
 * 
 * 	Iterators are safe even if the set is being modified during iteration
 *
 *	When thread safety is required and modifications are infrequent
 */
public class CopyOnWriteArraySetDemo {

	public static void main(String[] args) {

		Set<String> set = new CopyOnWriteArraySet<>();
		set.add("Apple");
		set.add("Banana");
		
		System.out.println(set);
	}
}
