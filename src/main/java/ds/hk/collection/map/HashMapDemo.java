package ds.hk.collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *	Map.Entry required for iteration purpose, Map is Not Iterable
 *
 *	BiFunction -> (a, b) -> { return a+b; }
 *				  (a, b) -> a+b;
 *	SingleFunction -> (a) -> { return a+1; }
 *					  (a) -> return a+1;
 *
 *	1. Maintains Natural Sorting Order
 */

public class HashMapDemo {

	public static void main(String[] args) {
		
		Map<Integer, String> entry1 = new HashMap<Integer, String>();
		Map<Integer, String> entry2 = new HashMap<Integer, String>();
		
		entry1.put(1, "sheikh");
		entry1.put(3, "dummy");
		entry1.put(2, "hapheej");
		entry1.put(4, "dummy");
		entry1.put(5, null);
		entry1.put(null, null);
		entry1.put(null, null);	//No Effect bcz Duplicate Entry
		System.out.println("Map1: "+entry1);
		
		entry2.put(3, "mansoori");
		entry2.put(null, null);
		entry2.put(6, "dummy");
		entry2.put(7, "dummy");
		entry2.put(8, null);
		System.out.println("Map2: "+entry2);
		
		entry1.putAll(entry2);	//Adds/Replaces values respective to keys
		
		entry1.putIfAbsent(4,"replaced");	//Adds if value is null
		entry1.putIfAbsent(5,"replaced");	//Adds if value is null
		System.out.println(entry1);
		
		entry2.remove(null);
		entry2.remove(6, "dummy");
		System.out.println(entry2);
		
		Set<Integer> keySets = entry1.keySet();
		keySets.forEach(key ->{
			System.out.print(key+", ");
		});
		System.out.println();
		
		//Map Not Iterable, But Map.Entry is Iterable & support forEach 
		
		Set<Map.Entry<Integer, String>> sets = entry1.entrySet();
		
		//forEach(Consumer<? super Entry<Integer, String>> action)
		sets.forEach(action ->{
			System.out.print(action.getKey()+"="+action.getValue()+", ");
		});
		System.out.println();
		
		Iterator<Map.Entry<Integer, String>> itr = sets.iterator();
		Entry<Integer, String> entry;
		while(itr.hasNext()) {
			entry = itr.next();
			System.out.print(entry.getKey()+"="+entry.getValue()+", ");
		}
		System.out.println();
		
		//compute(Integer key, BiFunction<? super Integer, ? super String, ? extends String> remappingFunction)
		entry2.compute(7, (key, val)-> val.concat(" edited"));
		System.out.println(entry2);
		
		entry2.computeIfAbsent(8, (key) -> entry2.get(key)+"_NULL");
		System.out.println(entry2);
		
		System.out.println("Containd key 8: "+entry2.containsKey(8));
		System.out.println("Containd value null_NULL: "+entry2.containsValue("null_NULL"));
		System.out.println("entry2.equals(entry1): "+entry2.equals(entry1));
		
		System.out.println(entry2.getOrDefault(9, "NULL"));	//Get Default if found null value
		
		entry2.merge(9, "NULL", (v1, v2)->v1+v2);	//Seems useless function
		
		entry2.replace(9, "NULL_1");
		System.out.println(entry2);
		
		Collection<String> values = entry2.values();
		System.out.println("Collection of values: "+values);
		
		
		
		entry2.replaceAll((v1, v2)->v2=null);	//Replaces all values to null
		System.out.println(entry2);
		entry1.clear();
		entry2.clear();
	}
}
