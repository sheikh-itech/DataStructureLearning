package hari_krishna.oops;

/**			Multiple Inheritance
 * 		-----------------------------
 * 
 * If two interface has same method name with
 * different reference Return Type(super-sub)
 * then we can implement both in single class
 * 
 * But if Return Type is Siblings then Not Possible
 */

public class Scenario5 {

	public static void main(String[] args) {

	}
}

interface I9 {
	
	Object add();
}

interface I10 {
	
	String add();
}

interface I11 {
	
	Integer add();
}

class Add1 implements I9, I10 {

	@Override
	public String add() {

		return null;
	}
}

/*class Add2 implements I10, I11 {

	@Override
	public String add() {

		return null;
	}
	
	@Override
	public Integer add() {

		return null;
	}
}*/