package ds.hk.collection.map;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
* 	Map implementation with a hash table, using reference-equality
* 	It checks 'References' rather then equals()
* 	Means K1, K2 are equal if -> K1==K2
* 
* 	This class is not a general-purpose Map implementation! because
* 	it intentionally Violates Map's general contract
* 
* 	A typical it, is topology-preserving object graph transformations,
* 	such as serialization or deep-copying
* 	Permits null values and key, Don't preserve any Order, Not Synchronized
*/
public class IdentityHashMapExample {

	public static void main(String[] args) {

		Map<String, String> pair = new IdentityHashMap<String, String>();
		
		pair.put(new String("abc"), "abc");
		pair.put(new String("abc"), "abc");
		pair.put(new String("abc"), "abc");
		pair.put(new String("abc"), "abc");
		pair.put(new String("abc"), "abc");
		pair.put(new String("abc"), "abc");
		pair.put(new String("abc"), "abc");
		pair.put(new String("abc"), "abc");
		pair.put(new String("abc"), "abc");
		
		System.out.println(pair);
		 
		pair = new HashMap<String, String>();
		
		pair.put(new String("abc"), "abc");
		pair.put(new String("abc"), "abc");
		pair.put(new String("abc"), "abc");
		pair.put(new String("abc"), "abc");
		System.out.println(pair);
	}
}
