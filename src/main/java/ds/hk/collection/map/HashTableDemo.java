package ds.hk.collection.map;

import java.util.Hashtable;

/**			Hashtable		<br/><br/>
 * 
 * 	1. Can give negative key [This is key not Index in key-value]
 * 	2. HashTable is thread-safe
 * 	3. All its method are declared synchronized
 * 	4. Supports object cloning
 */

public class HashTableDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Hashtable<Integer, String> summary = new Hashtable<Integer, String>();
		summary.put(0, "hapheej");
		summary.put(1, "sheikh");
		summary.put(-2, "mansoori");
		System.out.println(summary);
		
		Object temp = summary.clone();
		
		Hashtable<Integer, String> summary1 = null;
		
		//Cannot perform instanceof check against parameterized type Hashtable<Integer,String>
		//Use the form Hashtable<?,?> instead 
		//since further generic type information will be erased at runtime
		//if(temp instanceof Hashtable<Integer, String>) {
		
		if(temp instanceof Hashtable<?, ?>) {	//if(temp instanceof Hashtable)=> Also work
			
			summary1 = (Hashtable<Integer, String>) temp;
		} 
		else return;
		
		System.out.println("Contains 'hapheej': "+summary1.contains("hapheej"));
	}
}
