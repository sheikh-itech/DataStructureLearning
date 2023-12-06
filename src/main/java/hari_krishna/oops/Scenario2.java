package hari_krishna.oops;

public class Scenario2 {

	public static void main(String[] args) {

		new A5().m1();
	}
}

interface I4 {
	
	void m1();
}

interface I5 {
	
	void m1();
}

class A5 implements I4, I5 {

	@Override
	public void m1() {
		
		System.out.println("Same named mathod overriden from 2 interfaces");
	}
}
