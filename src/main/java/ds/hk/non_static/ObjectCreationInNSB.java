package ds.hk.non_static;

/**
 * 
 * This will throw: Exception in thread "main" java.lang.StackOverflowError
 * Because Object creation in Non Static Block leads to recursive call
 * [Every time Constructor call, calls NSB so object creation call happen again N again]
 *
 */

@SuppressWarnings("unused")
public class ObjectCreationInNSB {
	
	{	
		ObjectCreationInNSB obj = new ObjectCreationInNSB();
	}

	public static void main(String[] args) {

		ObjectCreationInNSB obj = new ObjectCreationInNSB();

	}

}
