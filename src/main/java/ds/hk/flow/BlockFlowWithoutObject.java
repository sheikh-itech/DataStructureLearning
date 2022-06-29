package ds.hk.flow;

/**
 * @author Hapheej
 * This class shows flow of blocks and method invocation without
 * creating any Instance/Object
 */
public class BlockFlowWithoutObject {


	BlockFlowWithoutObject() {
		
		System.out.println("Constructor");
		
		staticMethod();
		nonStaticMethod();
	}
	
	{
		System.out.println("Non Static Block");
		staticMethod();
		nonStaticMethod();
	}
	
	{
		System.out.println("Static Block");
		staticMethod();
		nonStaticMethod();
	}
	
	static void staticMethod() {
		
		System.out.println("Static Method");
	}
	
	void nonStaticMethod() {
		
		System.out.println("Non Static Method");
	}
	
	public static void main(String[] args) {

		System.out.println("Main Method");
		staticMethod();
		//nonStaticMethod(); //Can't make static to non-static reference call

	}

}
