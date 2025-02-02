package core.collection.map;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**	It uses == operator for object comparison rather then equals()
 * 
 * 	Reference equality (==) instead of object equality (equals) when comparing keys and values
 * 
 * 	Uses System Identity Hash Code -> System.identityHashCode()
 * 
 * 	Because of 'double equality check' it adds duplicate object as key if different Memory Address
 * 
 * 	Same Constant Pooled object considered as same key since same Memory Address
 * 
 * 	IdentityHashMap is highly efficient for scenarios where reference equality is required and object identity is critical
 */
public class IdentityHashMapDemo {

	public static void main(String[] args) {

		String key1 = new String("key");
		String key2 = new String("key");
		
		String key3 = "key";	//String Constant Pool
		String key4 = "key";	//String Constant Pool
		String key5 = key4;
		
		Map<String, Integer> hashMap = new HashMap<>();
		
		hashMap.put(key1, 1);	//Adds new entry
		hashMap.put(key2, 2);		//Replaces values
		hashMap.put(key3, 3);	//Adds new entry
		hashMap.put(key4, 4);		//Replaces values
		hashMap.put(key5, 5);		//Replaces values
		
		System.out.println("Entries in HashMap");
		System.out.println(hashMap);
		
		Map<String, Integer> identityHashMap = new IdentityHashMap<>();
		
		identityHashMap.put(key1, 1);
		identityHashMap.put(key2, 2);
		identityHashMap.put(key3, 3);
		identityHashMap.put(key4, 4);
		identityHashMap.put(key5, 5);
		
		System.out.println("Same Entries in IdentityHashMap");
		System.out.println(identityHashMap);
		
		System.out.println("\nString Hash Code");
		System.out.println(key1.hashCode());
		System.out.println(key2.hashCode());
		
		System.out.println("\nSystem Hash Code");
		System.out.println(System.identityHashCode(key1));
		System.out.println(System.identityHashCode(key2));
	}
}
