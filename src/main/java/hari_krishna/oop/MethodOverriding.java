package hari_krishna.oop;

public class MethodOverriding {

	/**
	 * Over-ridden classes always executed from their initialized object
	 * Not from their reference type variable
	 * 
	 */
	public static void main(String[] args) {
		
		A1 a = new A1();
		a.print();
		
		a = new B1();
		a.print();
		
		a = new C1();
		a.print();
	}

}

class A1 {
	
	public void print() {
		System.out.println("Super class A");
	}
}

class B1 extends A1 {
	
	public void print() {
		System.out.println("Sub-Class B");
	}
}

class C1 extends B1 {
	
	public void print() {
		System.out.println("Child-Class C");
	}
}