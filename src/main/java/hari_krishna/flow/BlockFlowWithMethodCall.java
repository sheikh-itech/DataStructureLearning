package hari_krishna.flow;

/**
 * 
 * Method call flow/detail from Blocks and Constructor
 */
public class BlockFlowWithMethodCall {
	

	BlockFlowWithMethodCall() {
		
		System.out.println("Constructor");
		staticMethod("Static Mtd from Constructor");
		nonStaticMethod("Non Static Mtd from Constructor");
	}
	
	{
		System.out.println("Non Static Block");
		staticMethod("Static Mtd from Non Static Block");
		nonStaticMethod("Non Static Mtd from Non Static Block");
	}
	
	static {
		System.out.println("Static Block");
		staticMethod("Static Mtd from Static Block");
		//Cann't make static to non-static call
		//nonStaticMethod("Non Static Mtd from Static Block");
	}
	
	static void staticMethod(String msg) {
		
		System.out.println(msg);
	}
	
	void nonStaticMethod(String msg) {
		
		System.out.println(msg);
	}
	
	public static void main(String[] args) {

		System.err.println("Main Method --> Object creation started");
		new BlockFlowWithMethodCall();

	}
}
