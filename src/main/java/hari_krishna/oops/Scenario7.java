package hari_krishna.oops;

/**			Multiple Inheritance
 * 		----------------------------
 * 
 * Same method name with different checked exception also not allowed
 */

public class Scenario7 {

	public static void main(String[] args) {

		System.out.println(In1.num);
	}
}

interface In1 {
	
	int num = 10;
	void m1() throws InterruptedException;
}

interface In2 {
	
	void m1() throws ClassNotFoundException;
}

/*
class Cl1 implements In1, In2 {

	//Exception InterruptedException is not compatible with throws clause in In2.m1()
	@Override
	public void m1() throws InterruptedException {
		
	}
	
	//Duplicate method m1() in type Cl1
	@Override
	public void m1() throws ClassNotFoundException {
		
	}
}*/