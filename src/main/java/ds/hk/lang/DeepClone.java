package ds.hk.lang;

/**			Deep Cloning		<br/>
 * 
 * For deep cloning implement clone() method for all reference variable
 * And call from Actual method's (method running in main thread) clone() method
 */

public class DeepClone {


	public static void main(String[] args) throws CloneNotSupportedException {

		Test1 test = new Test1("First");
		
		C c1 = new C ("Hapheej", 33, test);
		
		C c2 = (C) c1.clone();
		
		System.out.println("C HashCode Before Clone: "+c1.hashCode());
		System.out.println("C HashCode After Clone: "+c2.hashCode());
		System.out.println();
		System.out.println("Test HashCode Before Clone: "+c1.getTest().hashCode());
		System.out.println("Test HashCode After Clone: "+c2.getTest().hashCode());
	}
}
