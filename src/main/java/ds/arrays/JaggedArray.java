package ds.arrays;

public class JaggedArray {

	public static void main(String[] args) {

		/*	[3][] => 3 rows & columns not defined	*/
		
		int[][] jaggedArray = new int[3][];
		
		jaggedArray[0] = new int[]{1, 2};
		jaggedArray[1] = new int[]{3, 4, 5, 3, 9};
		jaggedArray[2] = new int[]{6};

		
		System.out.println(jaggedArray);
	}
}
