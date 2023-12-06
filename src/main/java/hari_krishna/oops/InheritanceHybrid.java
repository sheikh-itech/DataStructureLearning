package hari_krishna.oops;

public class InheritanceHybrid {

	public static void main(String[] args) {

		Parent p = new Child$1();
		p = new Child$3();
		p.toString();
	}
}

//Hierarchical Inheritance
class Parent {
	
	static {
		
		System.out.println("Parent Loaded");
	}
}

class Child$1 extends Parent {
	
	static {
		
		System.out.println("Child$1 Of Parent Loaded");
	}
}

class Child$2 extends Parent {
	
	static {
		
		System.out.println("Child$2 Of Parent Loaded");
	}
}

//Single Level Inheritance
class Child$3 extends Child$2 {
	
	static {
		
		System.out.println("Child$3 Of Child$2 Loaded");
	}
}
