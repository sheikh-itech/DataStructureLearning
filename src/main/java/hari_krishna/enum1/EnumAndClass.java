package hari_krishna.enum1;


/**
 * We can not define static members in non static class of Enum
 *
 */
public enum EnumAndClass {

	InnerEnum {
		
	};
	
	class EnumClass {
		
		private int num;
		
		/**
		 * The field num1 cannot be declared static in a non-static inner type, 
		 * unless initialized with a constant expression
		 */
		//private static int num1;
		
		EnumClass (int num) {
			this.num = num;
		}
		
		/**
		 * The method add [main method also] cannot be declared static;
		 * static methods can only be declared in a static or top level type
		 */
		
		/*public static void add() {
			
		}*/
		
		public void m1() {
			
			System.out.println(num);
		}
		
		void m2() {
			
		}
	}
}
