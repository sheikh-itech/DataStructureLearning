package core.collection;

import java.util.Arrays;
import java.util.List;

public class ArraysOperation {

	static int[] arr = new int[] {5, 4, 7, 6, 2, 1, 3, 9, 8};
	static int[] arr1 = new int[] {5, 4, 7, 6, 2, 1, 3, 9, 8};
	static int[] arr2 = new int[] {5, 4, 7, 6, 2, 1, 3, 9, 8};
	
	static Integer[] arr3 = new Integer[] {5, 4, 7, 6, 2, 1, 3, 9, 8};
	static Integer[] arr4 = new Integer[] {5, 4, 7, 6, 2, 1, 3, 9, 8};
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		int fromIndex = 5;
		int toIndex = 7;
	
	// 1. Sort
		
		Arrays.sort(arr, fromIndex, toIndex);
		System.out.println("Partial Sort: " + Arrays.toString(arr));
		
		Arrays.sort(arr);
		//Arrays.sort(arr, (a, b)-> a-b); Works for Integer not int
		System.out.println("Sorted: " + Arrays.toString(arr));
	
	// 2. Parallel Sort
		
		Arrays.parallelSort(arr1);
		System.out.println("Parallel Sort: " + Arrays.toString(arr1));
		
		Arrays.parallelPrefix(arr1, (x, y) -> x + y);	// prefix sum
		System.out.println("Parallel P Sort: " + Arrays.toString(arr1));
		
	// 3. Searching
			
		int index = Arrays.binarySearch(arr, 1);
		System.out.println("Index of 1: "+index);
		
		index = Arrays.binarySearch(arr, fromIndex, toIndex, 7);
		System.out.println("Index of 7: "+index);
		
	// 4. Copying
		
		int [] temp1 = Arrays.copyOf(arr, 5);
		System.out.println("Copied arr: "+Arrays.toString(temp1));
		
		// toIndex is exclusive, fill zero for out of Index
		temp1 = Arrays.copyOfRange(arr, fromIndex, 11/*toIndex*/);
		System.out.println("Range copied arr: "+Arrays.toString(temp1));
		
	//4. Filling
		
		Arrays.fill(arr1, fromIndex, toIndex, 1);
		System.out.println("Filled arr: "+Arrays.toString(arr1));
		
		Arrays.fill(arr1, 0);
		System.out.println("Filled arr: "+Arrays.toString(arr1));
		
	// 5. Comparing
		
		boolean equal = Arrays.equals(arr, arr2);
		System.out.println("equals(arr, arr2): "+equal);
		
		Arrays.sort(arr2);
		equal = Arrays.equals(arr, arr2);
		System.out.println("Sorted equals(arr, arr2): "+equal);
		
		int compare = Arrays.compare(arr, arr2);              // lexicographic
		System.out.println("compare(arr, arr2): "+compare);
		
		equal = Arrays.equals(arr3, arr4);
		System.out.println("equals(arr3, arr4): "+equal);
		
		equal = Arrays.deepEquals(arr3, arr4);     // recursive compare for objects
		System.out.println("deepEquals(arr3, arr4): "+equal);
		
	// 6. Hashing
		
		System.out.println("Hashcode: "+Arrays.hashCode(arr));
		System.out.println("DeepHashCode: "+Arrays.deepHashCode(arr3));
		
	// 7. Converting to List / Stream
		
		List<int[]> list = Arrays.asList(arr1); // Not work properly with primitive
		
		List<Integer> list1 = Arrays.asList(arr3);
		System.out.println("Integer[] to List: "+list1);
		
		boolean res = Arrays.stream(arr3).allMatch(ele -> ele > 0);
		System.out.println("All ele>0: "+res);
		
		res = Arrays.stream(arr3, fromIndex, toIndex).allMatch(ele -> ele > 0);
		System.out.println("All ele>0: "+res);
		
	// 8. Setting Elements (Java 8+)
		
		Arrays.setAll(arr1, i -> 5);
		System.out.println("setAll: "+Arrays.toString(arr1));
		
		Arrays.parallelSetAll(arr1, i -> 7);
		System.out.println("parallelSetAll: "+Arrays.toString(arr1));
		
	// 9. Parallel Operations
		
		Arrays.parallelSort(arr4);
		System.out.println("parallelSort: "+Arrays.toString(arr4));
		
		Arrays.parallelPrefix(arr4, (x, y) -> x+y);
		System.out.println("parallelPrefix: "+Arrays.toString(arr4));
		
	// 10. Miscellaneous
		
		System.out.println("deepToString: "+Arrays.deepToString(arr3));
		System.out.println("mismatch index: "+Arrays.mismatch(arr3, arr4));
	}
}
