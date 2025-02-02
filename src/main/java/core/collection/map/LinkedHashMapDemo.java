package core.collection.map;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**	Linked Hash Map is Ordered Map
 *	By default it is double linked list thats why a bit slow
 */
public class LinkedHashMapDemo {

	public static void main(String[] args) {

		//Default Capacity(16), Load Factor (0.75) and accessOrder (false)
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		map.put("Orange", 75);
		map.put("Banana", 60);
		map.put("Mango", 90);
		
		System.out.println("Access order false");
		
		for(Entry<String, Integer> items : map.entrySet())
			System.out.println(items.getKey()+": "+items.getValue());
		
		//Custom Capacity(10), Load Factor (0.5) and accessOrder (true)
		LinkedHashMap<String, Integer> map1 = new LinkedHashMap<>(10, 0.5f, true);
		map1.put("Orange", 75);
		map1.put("Banana", 60);
		map1.put("Mango", 90);
		map1.put("Apple", 120);
		
		map1.get("Orange");	//True Access Order will keep it in last once item get done
		map1.get("Mango");
		
		//Keeps least recently used items in last means Banana & Apple
		
		System.out.println("Access order true");
		
		for (Entry<String, Integer> items : map1.entrySet())
			System.out.println(items.getKey() + ": " + items.getValue());
		
	}
}
