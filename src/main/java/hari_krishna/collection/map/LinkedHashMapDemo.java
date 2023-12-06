package hari_krishna.collection.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *	1. Implements Hash-table and linked-list
 *	2. Maintains doubly-linked list running through all of its entries
 *	3. Maintains Insertion Order
 *	4. Even maintains Insertion Order for Comparable Objects
 *	5. If need to return data to Client in Insertion Order Use Linked Hash Map 
 *	6. It is Not Thread Safe
 */
public class LinkedHashMapDemo {

	private static final int MAX_ENTRIES = 2;
	
	public static void main(String[] args) {
		//WithOut Comparable
		Pair p = new Pair(1, "sheikh");
		
		Map<Integer, Pair> pairs = new LinkedHashMap<>();
		pairs.put(p.getId(), p);
		
		p = new Pair(3, "hapheej");
		pairs.put(p.getId(), p);
		
		p.setName("mansoori");
		pairs.put(p.getId(), p);	//Replace if key already exist
		
		p = new Pair(0, "hapheej");
		pairs.put(p.getId(), p);
		
		p = new Pair(2, "hapheej");
		pairs.put(p.getId(), p);
	
		System.out.println(pairs);
		
		//With Comparable
		Pair1 p1 = new Pair1(2, "hapheej");
		Map<Integer, Pair1> pair = new LinkedHashMap<>();
		
		pair.put(p1.getId(), p1);
		
		p1 = new Pair1(0, "sheikh");
		pair.put(p1.getId(), p1);
		
		p1 = new Pair1(1, "mansoori");
		pair.put(p1.getId(), p1);
		
		System.out.println(pair);
		
		System.out.println("LinkedHashMap of Same Names: "+new LinkedHashMap<>(m1()));
		
		Map<Integer, Pair> pair1 = new LinkedHashMap<Integer, Pair>(16, 0.75f, false);
		pair1.put(2, new Pair(2, "hapheej"));
		pair1.put(1, new Pair(1, "sheikh"));
		pair1.put(3, new Pair(3, "mansoori"));
		System.out.println(pair1);
		
		Set<Entry<Integer, Pair>> entrySet = pair1.entrySet();
		entrySet.forEach(action->{
			System.out.println(action.getKey()+": "+action.getValue());
		});
		
		
		//Method removeEldestEntry, ensures maximum allowed entry
		//It removes previous entries if we add beyond MAX allowed
		
		Map<Integer, Pair> max2Pairs = new LinkedHashMap<Integer, Pair>() {

			protected boolean removeEldestEntry(Map.Entry<Integer, Pair> eldest)
            {
                return size() > MAX_ENTRIES;
            }
        };
        
        max2Pairs.put(1, new Pair(1, "sheikh"));
        max2Pairs.put(2, new Pair(2, "hapheej"));
        max2Pairs.put(3, new Pair(3, "mansoori"));
        max2Pairs.put(4, new Pair(4, "Vahleen"));
        System.out.println("max2Pairs: "+max2Pairs);
	}
	
	static Map<Integer, String> m1() {
		
		Map<Integer, String> names = new HashMap<Integer, String>();
		names.put(2, "hapheej");
		names.put(1, "sheikg");
		names.put(3, "mansoori");
		
		System.out.println("HashMap of Names: "+names);
		
		return names;
	}
}
