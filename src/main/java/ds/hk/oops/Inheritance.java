package ds.hk.oops;

/**			---Inheritance----
 * 
 * Here ChildClass using all public members of ParentClass
 * 
 * 1. Parent class loads first
 * 2. Child class loads and object created (inside it parent class members gets memory)
 * 
 */

public class Inheritance {

	public static void main(String[] args) {
		
		ParentClass p = new ChildClass();
		p.toString();
	}

}

class ParentClass {
	
	static {
		System.out.println("Parent Class");
	}
}

class ChildClass extends ParentClass {
	
	static {
		System.out.println("Child Class");
	}
}