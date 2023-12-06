package hari_krishna.static1;

/**
 * Variable shadowing means creating local variable with same name as class level variable
 * Here local variable gets priority
 * 
 */
public class VariableShadowing {
	
	static int value;

	public static void main(String[] args) {

		//Shadow variable
		int value = 10;
		
		//Can assign same variable but have no effect
		value = value;
		
		System.out.println("Local variable: "+value);
		System.out.println("Class variable: "+VariableShadowing.value);

	}

}
