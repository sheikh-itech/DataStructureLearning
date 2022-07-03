package ds.hk.inner_class;

/**
 * Creation of different inner classes and their Object creation
 *
 */
@SuppressWarnings("unused")
public class DemoInnerClass {

	class A {	}
	
	private class B {	}
	
	protected class C { 	}
	
	public class D { 	}
	
	// Can Declare All Above In Static Also Tested
	static class AA {	}
	
	public static void main(String[] args) {

		DemoInnerClass da = new DemoInnerClass();
		DemoInnerClass.A a = da.new A();
		
		AA aa = new AA();
	}

}
