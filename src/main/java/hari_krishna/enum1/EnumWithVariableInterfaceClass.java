package hari_krishna.enum1;

public enum EnumWithVariableInterfaceClass {

	NUM1, NUM2, NUM3, NUM4, NUM5;
	
	static EnumWithVariableInterfaceClass.B b;
	
	A a;
	
	/**
	 * Variable declaration should not be first Statement in Enum
	 */
	
	int num1;
	static int num2;
	
	EnumWithVariableInterfaceClass() {
		
		System.out.println("Enum Constructor");
	}
	
	void m1() {
		
		System.out.println("Non Static Method Inside Enum");
	}
	
	static void m2() {
		
		System.out.println("Static Method Inside Enum");
	}
	
	{
		System.out.println("Non Static Block Inside Enum");
		a = new A();
	}
	
	static {
		System.out.println("Static Block Inside Enum");
	}
	
	class A {
		
		{
			System.out.println("Non Static Class Inside Enum");
		}
		
		public void m1() {
			System.out.println("Non Static Method Inside Enum Class");
		}
	}
	
	static class B {
		
		static {
			System.out.println("Static Class Inside Enum");
		}
		
		public static void main(String args[]) {
			
			b = new EnumWithVariableInterfaceClass.B();
			//a = new EnumWithVariableInterfaceClass.A();
		}
	}
}
