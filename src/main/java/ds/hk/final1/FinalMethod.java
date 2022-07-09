package ds.hk.final1;

public class FinalMethod extends FinalTest {

	public static void main(String[] args) {

	}
	
	/** Cannot override the final method from FinalTest \n
	final void m1() { 	} \n
	
	// Cannot override the final method from FinalTest \n
	final static void m2() { 	} */
}

class FinalTest {
	
	final void m1() {
		
	}
	
	final static void m2() {
		
	}
}