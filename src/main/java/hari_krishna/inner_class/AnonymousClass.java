package hari_krishna.inner_class;

public class AnonymousClass {

	// Class Level Anonymous must assigned to variable
	/*new A() {
		
		public void m1() {
			System.out.println("Anonymous Class");
		}
	};*/
	
	A a = new A() {
		
		public void m1() {
			System.out.println("Anonymous Class, Class Level");
		}
	};
	
	static A a1 = new A() {
		
		public void m1() {
			System.out.println("Static Anonymous Class, Class Level");
		}
	};
	
	void m1() {
		// We must return object to use it from outside
		A a = new A() {
			
			public void m1() {
				System.out.println("Non Static Anonymous Class inside m1()");
			}
		};
		
		a.m1();
	}
	
	static A m2() {
		
		return new A() {
			
			public void m1() {
				System.out.println("Static Anonymous Class inside m2()");
			}
		};
	}
	
	public static void main(String[] args) {

		AnonymousClass.m2().m1();
		
		AnonymousClass cls = new AnonymousClass();

		cls.m1(); 
		cls.a.m1(); //Anonymous method calling from Outer Class reference
		AnonymousClass.a1.m1(); ////Anonymous method calling from Outer Class name
	}
}

class A {
	
	void m1() {	}
}
