package ds.java8lambda;

public class Lambda_Functional_Interface {

	public static void main(String[] args) {

	}
}


@FunctionalInterface	//Used to mark interface as Functional with Single Method definition
interface LambdaDemo  {
	
	void activity();	//Own method
	
	boolean equals(Object obj); //Overriding defined in Object [Not Own Method]
	
	String toString(); //Overriding method
	
	//Default method for backward compatibility
	default void defaultActivity1() {
		System.out.println("defaultActivity-1");
	}
	default void defaultActivity2() {
		System.out.println("defaultActivity-2");
	}
	default void defaultActivity3() {
		System.out.println("defaultActivity-3");
	}
}