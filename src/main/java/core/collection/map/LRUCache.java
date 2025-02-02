package core.collection.map;

import java.util.Map;
import java.util.LinkedHashMap;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

	private int capacity;
	
	public LRUCache(int capacity) {
		super(capacity, 0.5f, true);	//accessOrder true for to remove least used entry
		this.capacity = capacity;
	}

	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		
		return size()>capacity;	//Removes least used element if more then capacity
	}
	
	public static void main(String[] args) {
		
		LRUCache<String, Integer> map = new LRUCache<>(3);
		
		map.put("Hapheej", 35);
		map.put("Arham", 3);
		map.put("Fatima", 1);
		map.put("Dadi", 55);
		
		System.out.println("Removes least used entry after 4 entry");
		
		for(Map.Entry<String, Integer> names : map.entrySet())
			System.out.println(names.getKey()+": "+names.getValue());
		
		map.clear();
		
		map.put("Arham", 3);
		map.put("Hapheej", 35);
		map.put("Fatima", 1);
		
		map.get("Arham");	//Get call means latest used
		
		map.put("Dadi", 55);
		
		System.out.println("Removes least used entry after Get call");
		
		for(Map.Entry<String, Integer> names : map.entrySet())
			System.out.println(names.getKey()+": "+names.getValue());
	}
}
