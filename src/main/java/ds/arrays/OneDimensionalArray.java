package ds.arrays;

public class OneDimensionalArray {

	public static void main(String[] args) {

		//variable	 assignment
		int[] arr = {10, 20, 30, 40};
		System.out.println(arr);
		
		
		//variable		    Object Creation		Assignment
		int[] arr1 = 		new int[] 			{10, 20, 30, 40};
		System.out.println(arr1);
		
		
		//variable		  Assignment
		String [] fruit = {"Apple", "Mango", "Graps"};
		System.out.println(fruit);

		
		//variable		   Object Creation		Assignment
		String [] fruits = new String [] 		{"Apple", "Mango", "Graps"};
		System.out.println(fruits);

		// CE: Either initialize (new int [] {}) or define boundaries (new int [2])
		//int[] arr2 = new int [];
		
		int[] arr2 = new int [2];
		
		System.out.println(arr2);
	}
}
