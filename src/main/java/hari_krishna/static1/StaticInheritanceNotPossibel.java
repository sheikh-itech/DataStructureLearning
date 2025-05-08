package hari_krishna.static1;

public class StaticInheritanceNotPossibel {

	/*	Static method in sub-class are knows as hidden methods not overridden	*/
	
	public static void main(String [] args) {
		B.m2();
		B.m1();
	}
}

class A {
	
	static void m1() {
		System.out.println("Super m1");
	}
	
	static void m2() {
		
		System.out.println("Super m2");
	}
}

class B extends A {
	
	static void m1() {
		System.out.println("Sub m1");
	}
}