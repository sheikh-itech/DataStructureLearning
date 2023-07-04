package ds.hk.collection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import learn.ds.beans.DataProvider;

/**
 *	1. Having static methods those operates ON Or Return Collection/Map [subclasses]
 *	2. NullPointerException if provided collections null
 *
 */
public class CollectionsUsage {

	public static void main(String[] args) {

		List<Integer> nums = getList();
		Collections.reverse(nums);
		System.out.println("Reversed List: "+nums);
		
		Collections.rotate(nums, 2);
		System.out.println("List after Rotation: "+nums);
		Collections.shuffle(nums);
		System.out.println("List after Shuffling: "+nums);
		Collections.shuffle(nums, new Random(10));
		System.out.println("Shuffle with Random: "+nums);
		
		//Immutable Set/List
		Set<Integer> num1 = Collections.singleton(10);
		List<Integer> num2 = Collections.singletonList(10);
		
		//java.lang.UnsupportedOperationException
		//num1.add(20);
		//java.lang.UnsupportedOperationException
		//num2.add(30);
		System.out.println(num1+"::"+num2);
		
		Collections.sort(nums);
		System.out.println("Sorted List: "+nums);
		
		Collections.sort(nums, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		System.out.println("List Reverse Sorted With Comparator: "+nums);
		
		Collections.swap(nums, 3, 2);	//Collections.swap(nums, 2, 3);
		System.out.println("Swaped index 3, 2: "+nums);
		
		//Always Sort before Binary Search, Otherwise Wrong Output
		Collections.sort(nums);
		System.out.println("List: "+nums);
		int index = Collections.binarySearch(nums, 5);
		System.out.println("Index of 5 'BinarySearch': "+index);
		List<Integer> list = DataProvider.getIntList(9);
		System.out.println("New List: "+list);
		nums.add(17);
		nums.add(18);
		nums.add(19);
		Collections.copy(list, nums);
		System.out.println("Copied Old List to New List: "+list);
		
		List<Integer> ints = Collections.emptyList();
		/** Like Empty List Also Create
		 * 1. emptyEnumeration()
		 * 2. emptyIterator()
		 * 3. emptyListIterator()
		 * 4. emptyMap()
		 * 5. emptyNavigableMap()
		 * 6. emptyNavigableSet()
		 * 7. emptySet()
		 * 8. emptySortedMap()
		 * 9. emptySortedSet()
		 */
		System.out.println(ints);
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
		map.put(6, "6");
		map.put(3, "3");
		map.put(2, "2");
		map.put(0, "0");
		System.out.println("LinkedHashMap: "+map);
		return map;
	}
	
	static Map<Integer, String> getTreeMap() {
		Map<Integer, String> map = new TreeMap<Integer, String>();
		map.put(5, "5");
		map.put(4, "4");
		map.put(2, "2");
		map.put(3, "3");
		map.put(1, "1");
		
		return map;
	}
	
	static Queue<Integer> getArrayDque() {
		ArrayDeque<Integer> ints = new ArrayDeque<>();
		ints.add(10);
		ints.add(11);
		ints.addLast(20);
		ints.addLast(12);
		ints.addFirst(0);
		return ints;
	}
	
	static List<Integer> getList() {
		List<Integer> nums = new ArrayList<>();
		nums.add(0);
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		nums.add(5);
		System.out.println(nums);
		return nums;
	}
}
