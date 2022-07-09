package ds.hk.final1;

/**			Final Class Inheritance
 * 
 * 	The type FinalClass cannot subclass the final class Final
 */

//public class FinalClass extends Final {
public class FinalClass {

	public static void main(String[] args) {
		new FinalClass().classAndMethodName();
	}
	
	void classAndMethodName() {
		
		System.out.println("Class Name: "+this.getClass().getName());
		System.out.println("Canonical Class Name: "+this.getClass().getCanonicalName());
		System.out.println("Simple Class Name: "+this.getClass().getSimpleName());
		System.out.println("Super Class Name: "+this.getClass().getSuperclass());
		System.out.println("Interface Name: "+this.getClass().getInterfaces());
	}
}

final class Final {
	
	Final() {
		super();
	}
}
