package ds.reflection;

public class Data {
	
	private Data() {
		System.out.println("private constructor");
	}
	
	private Data(String msg) {
		System.out.println("String:: "+msg);
	}
	
	private Data(int msg) {
		System.out.println("int:: "+msg);
	}
	
	private Data(long msg) {
		System.out.println("long:: "+msg);
	}
	
	private Data(float msg) {
		System.out.println("float:: "+msg);
	}
	
	private Data(boolean msg) {
		System.out.println("boolean:: "+msg);
	}
	
	void init() {
		System.out.println("Data initialized");
	}
}
