package ds.hk.non_static;


/**
 * We can access static member from null referenced variables 
 * [Static Members gets memory with class loading]
 * 
 * But its not the case with Non-Static members [Non Static with Object creation]
 * 
 *
 */

@SuppressWarnings("static-access")
public class Static_NonStatic_VariableAccessing {

	private String name;
	private static String address;
	
	public static void main(String[] args) {
		
		Static_NonStatic_VariableAccessing v2 = new Static_NonStatic_VariableAccessing();
		
		System.out.println("Name:" +v2.name);
		System.out.println("Address:" +v2.address);
		
		v2.staticMethod();
		v2.NonStaticMethod();
		
		
		Static_NonStatic_VariableAccessing v1 = null;
		
		System.out.println("Address:" +v1.address);
		
		//Null pointer access: The variable v1 can only be null at this location
		System.out.println("Name:" +v1.name);
		
		v1.staticMethod();
		
		//Exception in thread "main" java.lang.NullPointerException
		v1.NonStaticMethod();		

	}
	
	static void staticMethod() {
		
	}
	
	void NonStaticMethod() {
		
	}	
}
