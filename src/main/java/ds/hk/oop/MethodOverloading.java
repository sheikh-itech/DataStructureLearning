package ds.hk.oop;

/**
 * Over loaded methods are always called from their reference type class
 * 
 */
public class MethodOverloading {

	public static void main(String[] args) {
		
		A2 a = new A2();
		a.add(5, 7);
		a.add(5987L, 5);
		
		System.out.println("\nOver loaded methods called from reference type class");
		a = new B2();
		a.add(50, 17);	//From A2 class, Not from B2
		a.add(59L, 5);	//From A2 class, Not from B2
		
		System.out.println();
		B2 b = new B2();
		b.add(5f, 8.0);
		b.add(5.8, 4);

	}

}

class A2 {
	
	public void add(int a, int b) {
		System.out.println("Int=> a+b: "+(a+b));
	}
	
	public void add(long a, long b) {
		System.out.println("Long=> a+b: "+(a+b));
	}
}

class B2 extends A2 {
	
	public void add(float a, float b) {
		System.out.println("Float=> a+b: "+(a+b));
	}
	
	public void add(double a, double b) {
		System.out.println("Double=> a+b: "+(a+b));
	}
}
