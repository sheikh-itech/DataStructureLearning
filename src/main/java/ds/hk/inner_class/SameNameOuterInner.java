package ds.hk.inner_class;

public class SameNameOuterInner {

	//The nested type SameNameOuterInner cannot hide an enclosing type
	/*class SameNameOuterInner {
		
	}*/
	
	//The nested type SameNameOuterInner cannot hide an enclosing type
	/*static class SameNameOuterInner {
		
	}*/
	
	//The nested type SameNameOuterInner cannot hide an enclosing type
	void m1() {
		
		/*class SameNameOuterInner {
			
		}*/
	}
	
	static void m2() {
		
		//The nested type SameNameOuterInner cannot hide an enclosing type
		/*class SameNameOuterInner {
			
		}*/
	}
	
	public static void main(String[] args) {

	}
}
