package ds.arrays.other;

import java.util.Arrays;

public class ArrayBinarySearch {

	public static void main(String[] args) {

		int[] arr = new int[1000];
		
		for(int i=0; i<1000; i++)
			arr[i] = (int) (Math.random()*10);
		
		Arrays.sort(arr);
		
        int index = Arrays.binarySearch(arr, 5);
        
        System.out.println("Element 5 found at index: " + index);
	}
}
