package hari_krishna.collection.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *	All operations are thread-safe, But retrieval operations do not entail locking
 *	It does not lock the entire table like Hashtable
 *	It operates same like Hashtable except for Synchronization
 *	ConcurrentHashMap class is thread-safe
 *	In ConcurrentHashMap, the Object is divided into a number of segments/buskets according
 *	to the concurrency level
 *	The default concurrency-level of ConcurrentHashMap is 16
 *	Retrieval operation do not lock Object
 *	
 *	Null Insertion not allowed, for keys and values both
 *	Do not throw ConcurrentModificationException
 *	Its Iterator can be accessed by Single thread at a time
 *	
 */

public class ConcurrentHashMapExample {

	public static void main(String[] args) {

		Map<String, String> names = new ConcurrentHashMap<String, String>();
		
		//names.put(null, null);	java.lang.NullPointerException
		
		names.put("a", "value");
		fill(names);
		System.out.println(names);
	}
	
	private static void fill(Map<String, String> names) {
		
		for(int i=0; i<10000; i++) {
			names.put(i+"", i+"");
		}
	}
}
