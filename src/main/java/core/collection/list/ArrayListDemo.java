package core.collection.list;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {

	/**	Internal Working when add element
	 *  
	 * 	1. Check Capacity
	 *  	Before adding element checks capacity, if full increases size
	 *  2. Resize If Needed
	 *  	If capacity is full, creates new array [Growth Factor - 1.5 times of current]
	 *  	and copy old elements to new and adds new element too
	 *  	Time complexity O(n)
	 *  3. Add element
	 *  	Adds newly coming element to end or specified position
	 *  
	 *  Internal Working when Removing element
	 *  
	 *  1. Check Bounds
	 *  	Checks bounds of removing element
	 *  2. Remove Element
	 *  	Remove element & if required shift all greater index element by 1 to left
	 *  3.Reduce Size
	 *  	Reduce size decrement by 1 if needed
	 */
	
	public static void main(String[] args) throws Exception {
		
		//1. List Creation
		
		List<String> names = new ArrayList<>();
		names.add("Arham");
		System.out.println("Size: "+names.size());
		
		//To get capacity
		Field field = ArrayList.class.getDeclaredField("elementData");
		field.setAccessible(true);
		Object[] elementData = (Object[]) field.get(names);
		System.out.println("Names capacity: "+elementData.length);
		
		//2. List Creation
		
		//Specify size to overcome overhead of element copy [If idea about input]
		List<String> names1 = new ArrayList<>(100);
		System.out.println("Size: "+names1.size());

		elementData = (Object[]) field.get(names1);
		System.out.println("Names1 capacity: "+elementData.length);
		
		//3. List Creation java 9
		
		List<Integer> nums = List.of(1, 2, 3, 4, 5);
		//nums.add(4); //CE::UnsupportedOperationException
		System.out.println("Fixed size list: "+nums.size());
		
		
		/**	Arrays.asList() returns fixed size list means
		 *  can not add new element on it but can replace element
		 *  Since it is Arrays$ArrayList
		 */
		List<String> fixedSizeList = Arrays.asList("Monday", "Tuesday");
		//fixedSizeList.add("Wednesday"); //CE::UnsupportedOperationException
		fixedSizeList.set(1, "Wednesday"); //Works fine
		
		String[] days = {"Monday", "Tuesday"};
		fixedSizeList = Arrays.asList(days);
		//fixedSizeList.add("Thursday"); //CE::UnsupportedOperationException
		
		System.out.println("Class of names1: "+names1.getClass().getName());
		System.out.println("Class of fixedSizeList: "+fixedSizeList.getClass().getName());
		
		
		// Convert Fixed to Modifiable
		List<Integer> num1 = new ArrayList<>(nums);
		
		//Defaults removes Index not values
		List<Integer> nums1 = new ArrayList<>();
		nums1.add(1);nums1.add(2);nums1.add(3);nums1.add(7);
		nums1.add(9);nums1.add(4);nums1.add(7);nums1.add(4);
		
		//It removes 4th indexed value
		nums1.remove(4);
		System.out.println(nums1);
		
		// To remove actual value instead of indexed value
		nums1.remove(Integer.valueOf(4));
		System.out.println(nums1);
		
		Object[] nums2 = nums.toArray();
		
		//Specify type 'new Integer[0]' for int array, zero element array to specify type only
		Integer[] nums3 = nums.toArray(new Integer[0]);
		
		//Sort ArrayList
		
		Collections.sort(nums1);
		System.out.println("Sorted list: "+nums1);
	}

}
