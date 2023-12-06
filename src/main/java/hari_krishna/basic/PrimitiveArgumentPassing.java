package hari_krishna.basic;

public class PrimitiveArgumentPassing {

	public static void main(String[] args) {
		
		add(10, (byte)5); //Will call add(int, int)
		add((short)10, 5); //Will call add(int, int)
		System.out.println();
		add((byte)10, (byte)5); 
		add((short)10, (short)5);
		add(10, 5);
		add(10l, 5);
		add(10f, 5);
		add(10d, 5);
	}
	
	static void add(byte a, byte b) {
		System.out.println("byte::a+b: "+ (a+b));
	}
	
	static void add(short a, short b) {
		System.out.println("short::a+b: "+ (a+b));
	}
	
	static void add(int a, int b) {
		System.out.println("int::a+b: "+ (a+b));
	}
	
	static void add(long a, long b) {
		System.out.println("long::a+b: "+ (a+b));
	}
	
	static void add(float a, float b) {
		System.out.println("float::a+b: "+ (a+b));
	}
	
	static void add(double a, double b) {
		System.out.println("double::a+b: "+ (a+b));
	}

}
