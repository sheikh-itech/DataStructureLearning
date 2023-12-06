package hari_krishna.inner_class;

public class NonStaticInnerClass {

	class NonStatic {
		
		private void m1() {
			System.out.println("Non Static Inner Class Method");
		}
		
		//The method m2 cannot be declared static;
		//static methods can only be declared in a static or top level type
		
		/*static void m2() {
			
		}*/
	}
	
	public static void main(String[] args) {

		NonStaticInnerClass.NonStatic ns = new NonStaticInnerClass().new NonStatic();
		ns.m1();

	}

}
