package hari_krishna.strings;

public class StringPool {

	public static void main(String[] args) {

		String ss1 = new String("abc");	//This will Create in HeapMemory
		String ss2 = new String("abc");	//This will Create in HeapMemory
		
		String s1 = "abc";		//This will create in String Constant Pooled Area
		
		String s2 = "abc";		//s1 & s2 will refer same object
		
		String s3 = "abc";	//s3 also refer same object
		
		String s4 = m1();	//s4 also refer same object
		
		String s5 = "abcabc";	//Different/new object
		
		String s6 = s1+s2;	//Different/new object
		
		String s7 = "abc"+"abc";	//s7 will refer to s5
		
		System.out.println("s1==s2: "+(s1==s2));
		System.out.println("s1==s3: "+(s1==s3));
		System.out.println("s1==s4: "+(s1==s4));
		System.out.println("s1==ss1: "+(s1==ss1));
		System.out.println("s5==s6: "+(s5==s6));
		System.out.println("s5==s7: "+(s5==s7));
		System.out.println();
		System.out.println("ss1==ss2: "+(ss1==ss2));
	}
	
	static String m1() {
		String s = "abc";
		return s;
	}
}
