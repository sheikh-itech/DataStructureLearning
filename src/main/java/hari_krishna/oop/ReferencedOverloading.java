package hari_krishna.oop;

/**
 * 
 * If method overloaded with super and subclass type in same file/class,
 * then in method call JVM always gives priority to subclass overloaded method
 *
 */
public class ReferencedOverloading {

	public static void main(String[] args) {

		Test t = new Test();
		
		t.m1(new Example1());
		t.m1(new Sample1());
		t.m1(null);
		
		//--Output--
		//In Sample
		//In Sample
		//In Sample
	}

}

class Test {
	
	void m1(Example1 e) {
		
		System.out.println("In Sample");
	}
	
	void m1(Sample1 s) {
	
		System.out.println("In Sample");
	}
}

class Example1 {

}

class Sample1 extends Example1 {

}