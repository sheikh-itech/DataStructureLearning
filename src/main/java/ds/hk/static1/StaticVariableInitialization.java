package ds.hk.static1;

/**
 * Static variables executes first, even before main method
 *
 */

public class StaticVariableInitialization {

	static int value1 = variableInitialize();
	
	//Cannot make a static reference to the non-static method variableInitialize_1() 
	//from the type StaticVariableInitialization
	//static int value2 = variableInitialize_1();
	
	public static void main(String[] args) {
		
		System.out.println("Inside main");
	}

	private static int variableInitialize() {
		
		System.out.println("Inside variableInitialize");
		return 10;
	}
	
	private int variableInitialize_1() {
		
		return 10;
	}

}
