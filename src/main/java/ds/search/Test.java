package ds.search;

/**
 * @author Hapheej
 *
 */
public class Test {

	public static void main(String[] args) {
		System.out.println("Sorted List search started over same set of data");
		System.out.println("-------------------------------------------\n");
		ListSearch.linearSearch(4999999);
		ListSearch.binarySearch(4999999);
		System.out.println("\nSorted Array search started over same set of data");
		System.out.println("-------------------------------------------\n");
		ArraySearch.linearSearch(4999999);
		ArraySearch.binarySearch(4999999);
	}
}
