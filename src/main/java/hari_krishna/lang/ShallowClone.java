package hari_krishna.lang;

public class ShallowClone {

	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		Test test = new Test("First");
		
		B s1 = new B ("Hapheej", 33, test);
		s1.setTest(test);
		
		B s2 = (B) s1.clone();
		
		System.out.println("B HashCode Before Clone: "+s1.hashCode());
		System.out.println("B HashCode After Clone: "+s2.hashCode());
		System.out.println();
		System.out.println("Test HashCode Before Clone: "+s1.getTest().hashCode());
		System.out.println("Test HashCode After Clone: "+s2.getTest().hashCode());
	}
}
