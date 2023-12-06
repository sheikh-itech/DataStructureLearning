package hari_krishna.inner_class;

public class SameInnerClassName {
	
	class InnerClass {
		
	}
	
	void m1() {
		
		class InnerClass {
			
		}
	}
	
	static void m2() {
		
		//Illegal modifier for the local class InnerClass; only abstract or final is permitted
		/*static class InnerClass {
			
		}*/
		
		class InnerClass {
			
		}
	}

	public static void main(String[] args) {

	}
}
