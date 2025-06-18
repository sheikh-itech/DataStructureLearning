package core.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapCommonOperations {

	public static void main(String[] args) {

		Map<String, Integer> prices = new HashMap<>();
		
		prices.put("apple", 2);
		prices.put("banana", 3);

        System.out.println(prices);
        
        // Update existing key
        prices.compute("apple", (k, v) -> v == null ? 1 : v + 10);
        System.out.println(prices); // {apple=12, banana=3}

        // Add new key
        prices.compute("cherry", (k, v) -> v == null ? 1 : v + 10);
        System.out.println(prices); // {apple=12, banana=3, cherry=1}

        // Remove key if computed value is null
        prices.compute("banana", (k, v) -> null);
        System.out.println(prices); // {apple=12, cherry=1}
        
        // Print each key-value pair
        prices.forEach((key, value) -> System.out.println(key + ": " + value));
        
        // If "apple" exists, increase price by 5
        prices.merge("apple", 5, (oldVal, newVal) -> oldVal + newVal); // apple = 17

        // If "orange" does not exist, add it with price 7
        prices.merge("orange", 7, (oldVal, newVal) -> oldVal + newVal); // orange = 7
        
        System.out.println(prices);
        
        //prices.replaceAll(null); //NullPointerException
        prices.replaceAll((k, v)-> v+1); //Update values by 1

        System.out.println(prices);
        
        prices.replaceAll((k, v)-> null); //clear
        
        System.out.println(prices);
        
        //EntrySet
        
        Set<Entry<String, Integer>> entrySet = prices.entrySet();
        
        entrySet.removeIf(e-> e.getValue()==null);
        
        System.out.println(prices);
	}
}
