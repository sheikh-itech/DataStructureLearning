package ds.hk.strings;

/**
 *	It can be used to return string from memory if it is created by a new keyword.
 *	It creates an exact copy of the heap string object in the String Constant Pool 
 */

public class StringsDemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		String s1 = "";
		String s2 = " ";
		String s3 = "abc";
		String s4 = new String("abc");
		
		StringBuffer sb1 = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer();
		sb2.append("abc");
		
		StringBuilder sb3 = new StringBuilder("abc");
		StringBuilder sb4 = new StringBuilder();
		sb4.append("abc");
		
		
		String s21 = new String("abc").intern();
		String s31 = new String("abc").intern();
		System.out.println("s21==s31: "+(s21==s31));
		System.out.println("new s2(abc): "+s21.hashCode());
		System.out.println("new s3(abc): "+s31.hashCode());
		
		String str1 = "xyz";
		String str2 = "xyz";	//This holds interned Object Reference
		System.out.println("str1==str2: "+(str1==str2));
		
		String str3 = new String("xyz1");
		String str4 = "xyz1";
		System.out.println("new String(xyz1)==(xyz1): "+(str3==str4));
		System.out.println("new String(xyz1) hash: "+str3.hashCode());
		System.out.println("(xyz1) hash: "+str4.hashCode());
	}
}
