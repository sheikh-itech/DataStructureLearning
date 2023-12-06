package hari_krishna.oops;

/**
 * 1. interface can extends interface
 * 2. method call refer to interface method, Not all methods of implementing Class
 * 3. class implementing interface
 *
 */
public class IS_A_Interfaces {

	public static void main(String args[]) {
		
		Vehicle v = new Car();
		v.numberOfStrocks();
		
		FourWheelers f = new Car();
		f.dieselOrPetrol();
		f.numberOfStrocks();
	}
}

interface Vehicle {
	
	void numberOfStrocks();
}

interface FourWheelers extends Vehicle {

	//The blank final field v may not have been initialized
	//HAS-A Not Possible with interfaces
	
	//Vehicle v;
	
	void dieselOrPetrol();
}

class Car implements FourWheelers {

	@Override
	public void numberOfStrocks() {
		
		System.out.println("Four Strock Engine");
	}

	@Override
	public void dieselOrPetrol() {
		
		System.out.println("Diesel Engine");
	}
}