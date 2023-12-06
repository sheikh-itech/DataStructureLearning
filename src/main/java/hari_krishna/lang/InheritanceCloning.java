package hari_krishna.lang;

@SuppressWarnings("unused")
public class InheritanceCloning extends Test3 implements Cloneable {

	public InheritanceCloning(String testName) {
		super(testName);
	}

	private boolean isClonined;
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		InheritanceCloning clone1 = new InheritanceCloning("Dummy");
		
		InheritanceCloning clone2 = clone1.clone();
		clone2.isClonined = true;
		
		System.out.println("InheritanceCloning Before Clone: "+clone1.hashCode());
		System.out.println("InheritanceCloning After Clone: "+clone2.hashCode());
		System.out.println();
		System.out.println("Super Class Test3 Before Clone: "+ clone1.hashCode());
		System.out.println("Super Class Test3 After Clone: "+ clone2.hashCode());

	}
	
	protected InheritanceCloning clone() throws CloneNotSupportedException {
		
		return (InheritanceCloning) super.clone();
	}
}

class Test3 {
	
	private String testName;
	
	public Test3(String testName) {
		
		this.testName = testName;
	}

	public String getName() {
		return testName;
	}

	public void setName(String testName) {
		this.testName = testName;
	}
	
	public Test3 getTest() {
		
		return /*(Test3) */this;
	}
}