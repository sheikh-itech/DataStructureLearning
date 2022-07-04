package ds.hk.oops;

/**			Multilevel Inheritance
 * 		-----------------------------
 * 
 * Here class hierarchy/inheritance levels are up-to 3 or more
 * 
 * Parent => Child => Grand Child...
 */

public class InheritanceMultilevel {

	public static void main(String[] args) {
		
		new InheritanceMultilevel().m1();
	}
	
	void m1() {
		
		System.out.println("Hierarchy From GrandChildLevel\n----------------------------");
		ParentLevel grandChild = new GrandChildLevel();
		
		System.out.println("\nHierarchy From  ChildLevel\n---------------------------");
		ParentLevel child = new ChildLevel();
		
		System.out.println("\nHierarchy From ParentLevel\n---------------------------");
		ParentLevel parent = new ParentLevel();
		
		System.out.println();
		
		parent.m1();
		child.m1();
		grandChild.m1();
	}

}

class ParentLevel {
	
	{
		System.out.println("Object Created=> Parent Level Class");
	}
	
	void m1() {
		
		System.out.println("Method=> Parent Level Class");
	}
}

class ChildLevel extends ParentLevel {
	
	{
		System.out.println("Object Created=> Child Level Class");
	}
	
	void m1() {
		
		System.out.println("Method=> Child Level Class");
	}
}

class GrandChildLevel extends ChildLevel {
	
	{
		System.out.println("Object Created=> Grand Child Level Class");
	}
	
	void m1() {
		
		System.out.println("Method=> Grand Child Level Class");
	}

}