package hari_krishna.exception;

public class ExceptionWithBlocks {

	/*	Can not throw Checked Exceptions from Blocks
	 * 	But can throw runtime exceptions from non-static block	*/
	
	{
        if(true) {
        	throw new RuntimeException("Unchecked exception");
        }
    }
	
	
	// Non-Static block
	{
		ExceptionWithBlocks obj = new ExceptionWithBlocks();
		//obj.test1();
		//CE:: Default constructor cannot handle exception type Exception thrown by implicit 
		//super constructor. Must define an explicit constructor
	}
	
	// Static block
	static {
		//ExceptionWithBlocks.test1(); CE:: Unhandled exception type Exception
	}
	
	private static void test1() throws Exception {
		System.out.println("Testing");
	}
	
	public static void main(String[] args) throws Exception {
		
		ExceptionWithBlocks.test1();
	}
}
