package hari_krishna.inner_class;

public class MethodLocalInnerClass {

	void m1(int num) {
		
		class A {
			
			void m1() {
				
				System.out.println(num);
			}
			
			//The method m2 cannot be declared static;
			//static methods can only be declared in a static or top level type
			
			/*static void m2() {
				
			}*/
		}
		
		//Illegal modifier for the local class C; 
		//only abstract or final is permitted
		
		/*static class C {
			
		}*/
	}
	
	static void m2() {
		
		int num = 10;
		
		class B {
			
			void m1() {
				
				System.out.println(num);
			}
			
			//The method m2 cannot be declared static;
			//static methods can only be declared in a static or top level type
			
			/*static void m2() {
				
			}*/
		}
	}
	
	public static void main(String[] args) {
		
		//B cannot be resolved to a type
		// Method inner class available only that method
		//B b = new B();

	}
}
