package hari_krishna.oops;

/**
 * We can only call method those are defined in interface 
 * using that interface reference variable
 * 
 * We Can Not call implementing class own method, from interface reference variable
 *
 */
public class IS_A_ClassInterface {

	public static void main(String[] args) {

		System.out.println("Interface Reference::Class Object");
		System.out.println("---------------------------------");
		
		Human h = new Indian();
		h.behaviour();
		
		//The method quality() is undefined for the type Human
		//h.quality();
		
		System.out.println("\nClass Reference::Class Object");
		System.out.println("--------------------------------");
		
		Indian i = new Indian();
		i.behaviour();
		i.quality();
	}

}

interface Human {
	
	void behaviour();
}

class Indian implements Human {
	
	@Override
	public void behaviour() {
		System.out.println("Interface method implemented by class:: behaviour()");
	}
	
	void quality() {
		System.out.println("Class own method:: quality()");
	}
}