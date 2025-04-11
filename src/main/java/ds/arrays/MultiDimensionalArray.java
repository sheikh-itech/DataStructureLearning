package ds.arrays;

public class MultiDimensionalArray {

	
	public static void main(String[] args) {
		
		int[][] matrix1 = { {1, 2, 3}, {4, 5, 6} };
		
		int[][] matrix2 = new int [][] { {1, 2, 3}, {4, 5, 6} };
		
		System.out.println(matrix1);
		System.out.println(matrix2);
		
		int[][] matrix3 = new int [2][2];
		
		System.out.println(matrix3);
		
		
		// CE: Either initialize (new int [][] {}) or define boundaries (new int [2][2])
		//int[][] matrix4 = new int [][];
		
		
		int[][] matrix4 = new int [][] {};
		
		System.out.println(matrix4);
	}
}
