package hari_krishna.non_static;

public class SameObjectAsArgument {

	public static void main(String[] args) {

		SameObject o1 = new SameObject();
		
		o1.m1(o1);

		System.out.println("x: "+o1.x+", y: "+o1.y);
	}
}

class SameObject {
	
	int x=10, y=20;
	
	void m1(SameObject o) {
		
		o.x = 5;
		o.y = 6;
	}
}