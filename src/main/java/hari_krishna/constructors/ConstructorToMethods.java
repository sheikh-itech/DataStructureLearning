package hari_krishna.constructors;

public class ConstructorToMethods {

	int y;
	int x;
	
	/* Constructor can call both Static & Non-Static Methods */
	ConstructorToMethods(){
		x = m1();
		y = m2();
	}
	
	public static void main(String[] args) {

		ConstructorToMethods demo = new ConstructorToMethods();
		
		System.out.println(demo.x+"---"+demo.y);
	}

	static int m1() {
		 return 5;
	}
	
	int m2() {
		 return 15;
	}
}
