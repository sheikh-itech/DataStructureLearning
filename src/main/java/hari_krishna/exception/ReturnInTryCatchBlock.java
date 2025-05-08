package hari_krishna.exception;

public class ReturnInTryCatchBlock {

	public static void main(String[] args) {

		int result = demoMethod();
        System.out.println("Result: " + result);
	}

	public static int demoMethod() {
		
        try {
            System.out.println("In try block");
            return 1;
        } catch (Exception e) {
            System.out.println("In catch block");
            return 2;
        } finally {
            System.out.println("In finally block");
        }
        
        //System.out.println("");	CE:: Unreachable code
    }
	
	public static void demoMethod1() {
		
        try {
            System.out.println("In try block");
            return;
        } catch (Exception e) {
            System.out.println("In catch block");
            return;
        } finally {
            System.out.println("In finally block");
            //return;	Warn:: finally block does not complete normally
        }
        
        //System.out.println(""); CE:: Unreachable code
    }
}
