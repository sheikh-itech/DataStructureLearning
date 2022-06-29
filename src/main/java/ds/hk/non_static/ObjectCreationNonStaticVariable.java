package ds.hk.non_static;


/**
 * 
 * This will throw: Exception in thread "main" java.lang.StackOverflowError
 * Because Object creation in Non Static Variable leads to recursive call
 * [Every time Constructor call, calls Non Static Variable to initialize 
 * so object creation call happen again N again]
 *
 */

public class ObjectCreationNonStaticVariable {

	ObjectCreationNonStaticVariable obj = new ObjectCreationNonStaticVariable();
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		ObjectCreationNonStaticVariable obj = new ObjectCreationNonStaticVariable();

	}

}
