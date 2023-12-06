package hari_krishna.enum1;

/**
 * 
 * Class definition should not be first declaration inside Enum
 * Before It declare Constructor
 *
 */
public enum EnumAndStaticClass {
	
	//Syntax error on token "class", delete this token
	
	/*class StaticClass {
		
	}*/
	
	EnumAndStaticClass(){
		
	}; //Must end with semicolon otherwise Compiler Error 
	
	static class StaticClass {
		
		int a;
		static int b;
		
		static void m1() {
			
		}
		
		void m2() {
			
		}
		
		public static void main(String args[]) {
			
		}
	}
	
}
