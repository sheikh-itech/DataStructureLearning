package ds.search;

/**
 * @author Hapheej
 *
 */
public class ArraySearch {
	
	private int []arr;
	private static ArraySearch search;
	
	private static void initialize() {
		if(search==null) {
			search = new ArraySearch();
			search.arr = new int[5000000];
		}
		
		for(int i=0;i<search.arr.length;i++) {
			search.arr[i] = i;
		}
	}
	
	public static int linearSearch(int num) {
		initialize();
		long time1 = System.currentTimeMillis();
		for( int i=0; i<search.arr.length; i++) {
			if(search.arr[i]==num) {
				System.out.println("Sorted Array linear search ["+num+"]-> "+(System.currentTimeMillis()-time1)+" sec");
				return search.arr[i];
			}
		}
		System.out.println("Sorted Array linear search [-1]-> "+(System.currentTimeMillis()-time1)+" sec");
		return -1;
	}
	
	public static int binarySearch(int num) {
		initialize();
		long time=System.currentTimeMillis();
		int start=0;
		int last=search.arr.length-1;
		int mid=-1;
		while(start<=last) {
			mid=(start+last)/2;
			if(search.arr[mid]==num) {
				System.out.println("Sorted Array binary search ["+num+"]-> "+(System.currentTimeMillis()-time)+" sec");
				return mid;
			}
			if(search.arr[mid]>num)
				last=mid+1;
			else
				start=mid+1;
		}
		System.out.println("Sorted Array binary search [-1]-> "+(System.currentTimeMillis()-time)+" sec");
		return -1;
	}
}
