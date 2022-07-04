package ds.hk.oops;

/**			Multiple Inheritance
 * 		-----------------------------
 * 
 * If two interface has same method name with
 * different reference Return Type(Siblings)
 * then we Can Not implement both in single class
 */

public class Scenario6 {

	public static void main(String[] args) {

	}
}

interface I12 {
	
	String add();
}

interface I13 {
	
	Integer add();
}

/*class Add2 implements I11, I12 {

	@Override
	public String add() {

		return null;
	}
	
	@Override
	public Integer add() {

		return null;
	}
}*/