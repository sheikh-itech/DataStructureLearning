package ds.hk.oops;

/**			hierarchical Inheritance
 * 		---------------------------------
 * 
 * Drives multiple subclasses from single Parent class
 */

public class InheritanceHierarchical {

	public static void main(String[] args) {
		
		ParentHierarchi p = new ParentHierarchi();
		p.m1();
		
		p = new Child1();
		p.m1();
		
		p = new Child2();
		p.m1();
	}

}

class ParentHierarchi {
	
	static {
		System.out.println("Parent Class Loaded");
	}
	
	void m1() {
		
		System.out.println("Method =>Parent Class\n");
	}
}

class Child1 extends ParentHierarchi {
	
	static {
		System.out.println("Child1 Class Loaded");
	}

	void m1() {
		
		System.out.println("Method =>Child1 Class\n");
	}
}

class Child2 extends ParentHierarchi {
	
	static {
		System.out.println("Child2 Class Loaded");
	}
	
	void m1() {
		
		System.out.println("Method =>Child2 Class\n");
	}
}