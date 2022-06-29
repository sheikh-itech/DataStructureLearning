package ds.hk.basic;

/**
 * 
 * Variables declared OR may be initialized 
 *
 */
public class VariableAccessError {

	VariableAccessError() {
		
	}
	
	int a = 10;
	{
		System.out.println("NSB a: "+a);
		//Cannot reference a field before it is defined
		//System.out.println("NSB B: "+b);
		
		//Below is alternate
		System.out.println("NSB B: "+this.b);
	}
	public static void main(String[] args) {

		VariableAccessError v = new VariableAccessError();
		System.out.println("Main Mtd a: "+v.a);
		System.out.println("Main Mtd b: "+v.b);

	}
	
	int b = 15;

}
