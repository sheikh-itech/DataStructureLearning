package hari_krishna.constructors;

/**	Constructor name should be same as class name
 * 	Should not have return type
 * 	Should not have modifiers
 * 	No return statement allowed
	---------------------------
	Access modifiers are allowed [default, private, protected, public]
	It can have parameters
	It can have throws clause
	It can have logic [except return statement]
	Can place return; in constructor [Dummy control return]
 */
public class ConstructorsDemo {

	ConstructorsDemo(){
		System.out.println("Default constructor");
	}
	
	private ConstructorsDemo(int x) {
		System.out.println("Private Constructor");
	}
	
	protected ConstructorsDemo(int x, int y) {
		System.out.println("Protected Constructor");
	}
	
	public ConstructorsDemo(int x, int y, int z) {
		System.out.println("Public constructor");
	}
	
	public static void main(String[] args) {
		
		ConstructorsDemo demo = new ConstructorsDemo();
		demo = new ConstructorsDemo(5);
		demo = new ConstructorsDemo(5, 5);
		demo = new ConstructorsDemo(5, 5, 5);
	}
}
