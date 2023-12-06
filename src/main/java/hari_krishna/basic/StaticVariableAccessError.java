package hari_krishna.basic;

/**
 * 
 * Until main method called, static variables defined after their use
 * If we access, we can access only their default values not actual ones
 *
 */
public class StaticVariableAccessError {

	private static int a = 10;
	
	static {
		System.out.println("a: "+a);
		
		//Cannot reference a field before it is defined
		//System.out.println(b);
		
		System.out.println("b: "+StaticVariableAccessError.b);
		System.out.println("b: "+getB());
		
	}
	
	public static void main(String[] args) {
		System.out.println("b: "+b);

	}
	
	static int getB() {
		return StaticVariableAccessError.b;
	}
	
	private static int b = 10;

}
