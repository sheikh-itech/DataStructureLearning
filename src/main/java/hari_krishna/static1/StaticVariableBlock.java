package hari_krishna.static1;

public class StaticVariableBlock {

	static int a = m1();
	
	static {
		System.out.println("Static Block");
	}
	
	static int b = m1();
	
	static {
		System.out.println("Static Block");
		//System.out.println("C initialized, C: "+c); CE: Cannot reference a field before it is defined
		System.out.println("C initialized, C: "+StaticVariableBlock.c);
	}
	
	static int c = 15;
	
	public static void main(String[] args) {
		
		System.out.println("Main method");
	}
	
	static int m1() {
		
		System.out.println("Static variable");
		return 10;
	}
}
