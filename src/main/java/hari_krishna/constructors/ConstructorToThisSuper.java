package hari_krishna.constructors;

public class ConstructorToThisSuper {

	int x, y;
	
	ConstructorToThisSuper(int x){
		
		this(x, 10);	// Same class constructor call as First Statement
		
		this.x = x;
		System.out.println("X initialized");
	}
	
	ConstructorToThisSuper(int x, int y){
		
		super(); // Super constructor call as First Statement
		
		this.y = y;
		System.out.println("Y initialized");
	}
	
	public static void main(String[] args) {
		
		ConstructorToThisSuper demo = new ConstructorToThisSuper(5);
		System.out.println("X: "+demo.x+", Y: "+demo.y);
	}
}
