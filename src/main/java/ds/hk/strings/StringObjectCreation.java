package ds.hk.strings;

public class StringObjectCreation {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		byte [] bytes = {12, 34, 56, 67, 89, 12, 45, 4, 56, 45};
		char [] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
		StringBuffer sb1 = new StringBuffer("abc");
		StringBuilder sb2 = new StringBuilder("abc");
		
		
		String s1 = null;
		String s2 = "";
		String s3 = " ";
		String s4 = "abc";
		String s = new String("null");
		String s5 = new String(s4);
		String s6 = new String(bytes);
		String s7 = new String(bytes, 2, 5);
		String s8 = new String(chars);
		String s9 = new String(chars, 4, 3);
		String s10 = new String(sb1);
		String s11 = new String(sb2);
		
		//The constructor String(String) is ambiguous
		//String s12 = new String(null);
		
		//It will Give NPE because => s1 is null
		String s13 = new String(s1);
		
		//It will also give NPE
		String s14 = new String((String)null);
		
	}
}
