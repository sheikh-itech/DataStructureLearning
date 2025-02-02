package core.collection.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**	Once Map is initialized, can not modify values of Identity Map
 * 
 * 	It is part of the Guava library provided by Google
 * 	Does not allow null keys or values to avoid ambiguity
 */
public class ImmutableMapDemo {

	public static void main(String[] args) {

		Map<String, Integer> family = new HashMap<>();
		
		family.put("Arham", 3);
		family.put("Fatima", 1);

		/* 1. Adding Entries to Original Map also updates to Unmodifiable Map In This Approach */
		
		Map<String, Integer> fixedMap = Collections.unmodifiableMap(family);
		
		System.out.println("\n1. Unmodifiable map first way");
		System.out.println(fixedMap);
		
		//fixedMap.put("Hapheej", 35); //CE:: Unmodifiable map
		
		family.put("Hapheej", 35);
		
		System.out.println(fixedMap);
		
		/* 2. No way to Add New Entries */
		
		family = Map.of(
				"Arham", 3, 
				"Fatima", 1,
				"A", 2,
				"B", 4,
				"C", 5,
				"D", 6,
				"E", 7,
				"F", 8,
				"G", 9,
				"H", 10
				//"I", 11	//Only 10 elements allowed
				);
		
		System.out.println("\n2. Unmodifiable map second way");
		System.out.println(family);
		
		/* 3. No way to Add New Entries */
		
		family = Map.ofEntries(
				Map.entry("Arham", 3),
				Map.entry("Fatima", 1),
				Map.entry("Hapheej", 35),
				Map.entry("A", 12),
				Map.entry("B", 4),
				Map.entry("C", 5),
				Map.entry("D", 6),
				Map.entry("E", 7),
				Map.entry("F", 8),
				Map.entry("H", 9),
				Map.entry("I", 10),
				Map.entry("J", 11)
				);
		
		System.out.println("\n3. Unmodifiable map third way");
		System.out.println(family);
	}
}
