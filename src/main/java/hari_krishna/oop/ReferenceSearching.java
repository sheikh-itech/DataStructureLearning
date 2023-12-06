package hari_krishna.oop;

public class ReferenceSearching {

	public static void main(String[] args) {

		Example e = new Example();
		Sample s = new Sample();
		
		e.m1(e); //On reference of e, passing e
		s.m1(e); //On reference of s, passing e
		e.m1(s); //On reference of e, passing s
		s.m1(s); //On reference of s, passing s

		/**
		 * Output
		 * 
		 *  In Example
		 *	In Example
		 *	In Example
		 *	In Sample
		 */
	}

}

class Example {
	
	void m1(Example e) {
		
		System.out.println("In Example");
	}
}

class Sample extends Example {
	
	//Overloaded Method bcz we can define both method in single class
	void m1(Sample s) {
		
		System.out.println("In Sample");
	}
}