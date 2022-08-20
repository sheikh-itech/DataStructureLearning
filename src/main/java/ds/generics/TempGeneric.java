package ds.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TempGeneric<A> {
	
	private A a;
	private List<A> names;
	
	public TempGeneric() {
		names = new ArrayList<A>();
	}

	public static void main(String[] args) {
		List<String> names = Arrays.asList("abc", "bcd", "cba");
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5);
		String [] arr1 = new String[]{"abc", "bca", "cab", "bac"};
		Integer[] arr2 = new Integer[] {5, 4, 2, 3, 1};
		
		generic(arr1);
		System.out.println(generic1(arr2));
		System.out.println(generic2(names));
		System.out.println(generic2(nums));
		
		TempGeneric<Integer> numList = new TempGeneric<Integer>();
		numList.a = 5;
		numList.names.add(1);
		System.out.println(numList);
	}

	public static <T> void generic(T[] arr) {
		for(T t:arr) {
			System.out.print(t+", ");
		}
		System.out.println();
	}
	
	public static <T> T[] generic1(T[] arr) {
		Arrays.sort(arr);
		return arr;
	}
	
	public static <T> Set<T> generic2(List<T> list) {
		Set<T> set = new HashSet<T>();
		for(T t:list) {
			set.add(t);
		}
		return set;
	}
}
