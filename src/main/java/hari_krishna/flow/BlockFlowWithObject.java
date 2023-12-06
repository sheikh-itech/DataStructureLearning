package hari_krishna.flow;

/**
 * @author Hapheej
 * This class shows flow of blocks and method invocation with
 * creating an Instance/Object
 * Non Static blocks executed while Object creation initialization
 * 
 */
public class BlockFlowWithObject {

	BlockFlowWithObject() {
		
		System.out.println("Constructor");
	}
	
	{
		System.out.println("Non Static Block");
	}
	
	static {
		System.out.println("Static Block");
	}
	
	public static void main(String[] args) {

		System.out.println("Main Method");
		new BlockFlowWithObject();

	}
}
