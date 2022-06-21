package ds.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Hapheej
 *
 */
public class ListSearch {
	
	private List<Integer> list = new ArrayList<>();
	private static ListSearch search;
	
	private static void initialize() {
		if(search==null)
			search = new ListSearch();
		if(!search.list.isEmpty())
			return;
		for(int i=0;i<5000000;i++) {
			search.list.add(i);
		}
	}
	
	public static int linearSearch(int num) {
		initialize();
		long time1 = System.currentTimeMillis();
		for(int i=0;i<5000000;i++) {
			if(search.list.get(i)==num) {
				System.out.println("Sorted List linear search ["+search.list.get(i)+"]-> "+(System.currentTimeMillis()-time1)+" sec");
				return search.list.get(i);
			}
		}
		System.out.println("Sorted List linear search [-1]-> "+(System.currentTimeMillis()-time1)+" sec");
		return -1;
	}
	
	public static void binarySearch(int num) {
		initialize();
		long time1 = System.currentTimeMillis();
		int res = Collections.binarySearch(search.list, num);
		System.out.println("Sorted List binary search ["+res+"]-> "+(System.currentTimeMillis()-time1)+" sec");
	}
}
