package ds.hk.oop;

/**
 * We can Initialize Final variables inside either Static OR Non-Static blocks
 *
 */
public class StaticFinalVariable {
	
	static final int CONSTANT;
	final long LONG_CONSTANT;
	
	static {
		CONSTANT = 20;
	}
	
	{
		LONG_CONSTANT = 30;
	}

	public static void main(String[] args) {
		
		//The final field StaticFinalVariable.CONSTANT cannot be assigned
		//CONSTANT = 20;

	}

}
