package core.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class CollectionsOperation {

	static List<Integer> list = new ArrayList<>();
	static List<Integer> list1;
	static Set<Integer> set = new HashSet<>();
	static List<String> names = new ArrayList<>();
	
	public static void main(String[] args) {
		init();
		
	// Only For List Based
		
		System.out.println("Actual List: "+list);
		
		Collections.sort(list); // Sort before binary search
		
		System.out.println("Sorted List: "+list);
		
		int search = Collections.binarySearch(list, 7);
		System.out.println("Binary Search: "+search);
		
		Collections.swap(list, 2, 3);
		System.out.println("After swap: "+list);
		
		Collections.shuffle(list);
		System.out.println("Shuffled List: "+list);
		
		Collections.sort(list);
		
		Collections.shuffle(list, new Random(12));
		System.out.println("Shuffled List: "+list);
		
		Collections.reverse(list);
        System.out.println("Reversed: "+list);
        
        //Elements moved toward end if distance > 0 and toward beginning if distance < 0
        
        Collections.rotate(list, 4);
        System.out.println("Rotate by 4: "+list);
        
        // To overcome IndexOutOfBoundsException: Source does not fit in dest
        list1 = new ArrayList<>(Collections.nCopies(list.size(), null));
        
        Collections.copy(list1, list);
        System.out.println("Copy List: "+list1);
        
		// Sort using a case-insensitive comparator
        names.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println("Sorted list: " + names);
        
        // Binary search with the same comparator
        int index = Collections.binarySearch(names, "Fatima", String.CASE_INSENSITIVE_ORDER);
        System.out.println("Index of 'Fatima': " + index);
        System.out.println("\n");
        
        
	// List, Set, Queue
		
		int min = Collections.min(list);
		System.out.println("Min: "+min);
		
		int max = Collections.max(set);
		System.out.println("Max: "+max);
		
		int freq = Collections.frequency(list, 5);
		System.out.println("Freq of 5: "+freq);
		
		// No common elements in both collection
		boolean dis = Collections.disjoint(list, set);
		System.out.println("list & set are DisJoint: "+dis);
		
		dis = Collections.disjoint(list, names);
		System.out.println("list & names are DisJoint: "+dis);
		
		Collection<Integer> common = Collections.synchronizedCollection(list);
		System.out.println("Syn Collection: "+common);
		
		common = Collections.unmodifiableCollection(list);
		System.out.println("Unmodifiable Collection: "+common);
		
		// Immutable list
		common = Collections.emptyList();
		System.out.println("Immutable Collection: "+common);
		
		Set<Integer> singleton = Collections.singleton(5);
		System.out.println("Singleton set: "+singleton);
		
		//Reverse order sort
		list.sort(Collections.reverseOrder());
		System.out.println("Reverse sort: "+list);
		
		list.sort((a, b) -> a-b);
		System.out.println("Comparator Sort: "+list);
	}
	
	private static void init() {
		list.add(5); list.add(1); list.add(2); list.add(7);
		list.add(4); list.add(3); list.add(6); list.add(9);
		list.add(5);
		
		set.add(4); set.add(1); set.add(2); set.add(3);
		set.add(8); set.add(7); set.add(5); set.add(9);
		
		names.add("Hapheej"); names.add("Fatima"); names.add("Arham");
		names.add("Dada");
	}
}
