package hari_krishna.inner_class;

/**
 * We have 4 types of Inner Classes
 * 
 * 1. Static Inner class
 * 2. Non Static Inner Class
 * 3. Method Local Inner class
 * 4. Anonymous Inner class
 * 
 * Note:: Compiler generates separate .class file for each Inner Class
 */

public class MajorTypeOfInnerClass {
	
	//1. Static Inner class
	static class StaticInnerClass {
		
	}
	
	//2. Non Static Inner Class
	class NonStaticInnerClass {
		
		//The method m1 cannot be declared static; 
		//static methods can only be declared in a static or top level type
		
		/*static void m1() {
			
		}*/
		
	}

	public static void main(String[] args) {

		//3. Method Local Inner class
		class MethodLocalInnerClass {
			
		}
		
		//4. Anonymous Inner class
		m1(new Thread() {});

	}
	
	static void m1( Thread a) {
		
	}

}
