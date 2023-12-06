package hari_krishna.basic;

/**
 * Executing finalize() method for garbage Collection
 */

public class GarbageCollection {

	public static void main(String[] args) {

		A1 a1 = new A1("Test");
		a1.getName();
		a1 = null;
		
		System.gc();
		
		A2 a2 = new A2(new String[]{"Test1", "Test2"});
		a2.getName();
		a2 = null;
		
		Runtime.getRuntime().gc();
		
		for (long a = 0; a < 9999; a++) {
			
		}
		System.out.println("loop done");
	}
}

class A1 {
	
	private String name;
	
	A1(String name) {
		
		this.name = name;
	}
	
	public String getName() {
		
		return this.name;
	}
	
	@Override
	public void finalize() {
		this.name = null;
		System.out.println("Name variable cleaned");
	}
}

class A2 {
	
	private String []name;
	
	A2(String []name) {
		
		this.name = name;
	}
	
	public String[] getName() {
		
		return this.name;
	}
	
	@Override
	public void finalize() {
		this.name = null;
		System.out.println("Name[] variable cleaned");
	}
}