package hari_krishna.non_static;

public class DifferentObjectAsArgument {

	public static void main(String[] args) {

		DifferentObject d1 = new DifferentObject();
		DifferentObject d2 = new DifferentObject();
		
		d1.m1(d2);
		
		System.out.println("x: "+d1.x+ ", y: "+d1.y);
		System.out.println("x: "+d2.x+ ", y: "+d2.y);
	}
}

class DifferentObject {
	
	int x=10, y=20;
	
	void m1(DifferentObject o) {
		
		o.x = 5;
		o.y = 6;
	}
}