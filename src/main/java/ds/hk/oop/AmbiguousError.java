package ds.hk.oop;

public class AmbiguousError {

	public static void main(String[] args) {

		AmbiguousError a = new AmbiguousError();
		
		//The method add(int, float) is ambiguous for the type AmbiguousError
		//a.add(10,  10);
		
		a.add(5f, 10);

	}
	
	void add(int a, float b) {
		
	}
	
	void add(float a, int b) {
		
	}

}
