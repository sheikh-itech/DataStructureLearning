package hari_krishna.arrays;

@SuppressWarnings("unused")
public class ArrayDeclaration {

	private int[] numbers, integers;
	private int []names;
	private int  []names1;
	private int   []names2;
	private int  		[]names3;
	private int [] name;
	private int address[];
	private int addresses [];
	private int[]design;	//Even this is valid declaration
	
	int []num1, num2;
	int num3[], num4;
	int num5, num6[];
	
	final int []finalarray = {1};
	final int []finalarray1 = new int[10];
	
	Object obj1 = new int[5]; /**Object super class for primitive array*/
	
	Object[] obj2 = new A[5];	/**Object[] super class for referenced array*/
	
	//Syntax error on token "num8", delete this token
	//int num7, []num8;
	
	//private []int num;	//CE:: Not valid declaration
	//private int [5]num;	//Syntax error on token "5", delete this token
	
	public static void main(String[] args) {

		//Type mismatch: cannot convert from double to int
		//int [] num = new int[10.5];
		
		//Type mismatch: cannot convert from double to int
		//double [] num = new double[10.5];
		
		int [][] num = new int[5][];
		
		//Cannot specify an array dimension after an empty dimension
		//int [][] num1 = new int[][5];	//Base/first array size compulsory
		
	}
}

class A {
	
}