package hari_krishna.basic;

public class LocalVariable {

	static int num1;
	
	public static void main(String[] args) {

		int num2;
		
		System.out.println("num1: "+num1); //0
		
		//CE::The local variable num2 may not have been initialized
		//System.out.println("num2: "+num2);
		
		num2 = 0;
		System.out.println("num2: "+num2);

	}

}
