package ds.hk.collection.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

/**		TreeMap has around 35 methods
 * 
 *	1. A Red-Black tree based NavigableMap implementation
 *	2. Sorted according to the natural ordering of its keys
 *	3. Or sorted by Comparator provided while MAP creation
 *	4. Provides guaranteed log(n) time cost
 *	5. Must be consistent with equals()
 *	6. Unique entries only
 *	7. Ascending by default, It is not Synchronized
 *	8. Fail-Fast: Concurrent Modification Not Allowed 
 */

public class TreeMapDemo {

	public static void main(String[] args) {
		
		Map<Integer, Pair> pairs = new TreeMap<Integer, Pair>();
		pairs.put(1, new Pair(1, "abc1"));
		pairs.put(5, new Pair(5, "abc5"));
		pairs.put(4, new Pair(4, "abc4"));
		pairs.put(3, new Pair(3, "abc3"));
		pairs.put(2, new Pair(2, "abc2"));
		System.out.println("Pairs: "+pairs);
		
		Map<Integer, String> names = new TreeMap<Integer, String>();
		
		names.put(3, "mansoori");
		names.put(2, "hapheej");
		names.put(1, "sheikh");
		System.out.println(names);
		
		TreeMap<Integer, String> map = new TreeMap(getHashMap());
		System.out.println("TreeMap From HashMap: "+map);
		map = new TreeMap(getLinkedHashMap());
		System.out.println("TreeMap from LinkedHashMap: "+map);
		
		int ceilingKey =  map.ceilingKey(4);	//NPException if Index out of range
		System.out.println("ceilingKey of 4: "+ceilingKey);
		System.out.println("Contains key 3: "+map.containsKey(3));
		System.out.println("Contains value 3: "+map.containsValue(3));
		System.out.println("TreeMap Clone: "+ map.clone());
		
		//Reverse Order Keys
		NavigableSet<Integer> key = map.descendingKeySet();
		System.out.println("Reverse Order Keys: "+key);
		
		//Reverse Order TreeMap
		NavigableMap<Integer, String> temp = map.descendingMap();
		System.out.println("Reversed Map: "+temp);
		
		System.out.println("First key: "+map.firstKey());
		System.out.println("First Entry: "+map.firstEntry());
		
		System.out.println("Floor key of 3: "+map.floorKey(3));
		System.out.println("Floor Entry of 3: "+map.floorEntry(3));
		
		System.out.println("Get Value 3: "+map.get(3));
		System.out.println("Get Head Map of 3: "+map.headMap(3));
		System.out.println("Inclusive Head Map of 3: "+map.headMap(3, true));
		
		System.out.println("Last entry: "+map.lastEntry());
		System.out.println("last key: "+map.lastKey());
		
		System.out.println("Sub TreeMap: "+map.subMap(2, 5));
		Set<Entry<Integer, String>> entrymap = map.entrySet();
		entrymap.forEach(action->{
			System.out.println(action.getKey()+": "+action.getValue());
		});
	}
	
	static Map<Integer, String> getHashMap() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "1");
		map.put(5, "5");
		map.put(3, "3");
		map.put(2, "2");
		map.put(0, "0");
		System.out.println("HashMap: "+map);
		return map;
	}
	
	static Map<Integer, String> getLinkedHashMap() {
		Map<Integer, String> map = new LinkedHashMap<>();
		map.put(1, "1");
		map.put(5, "5");
		map.put(3, "3");
		map.put(2, "2");
		map.put(0, "0");
		System.out.println("LinkedHashMap: "+map);
		return map;
	}
}
