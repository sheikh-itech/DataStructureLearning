package ds.hk.strings;

public class StringCommonOperation {

	public static void main(String[] args) {

		String s1 = "";
		String s2 = " ";
		String s3 = new String();
		String s4 = new String(" ");
		
		System.out.println("s1.isBlank(): "+s1.isBlank());
		System.out.println("s1.isEmpty(): "+s1.isEmpty());
		System.out.println("s2.isBlank(): "+s2.isBlank());
		System.out.println("s2.isEmpty(): "+s2.isEmpty());
		System.out.println("s3.isBlank(): "+s3.isBlank());
		System.out.println("s4.isEmpty(): "+s4.isEmpty());
		
		String s5 = "abc";
		String s6 = "abc";
		String s7 = "Abc";
		String s8 = "Abcdefg";
		
		System.out.println("s5==s6: "+(s5==s6));
		System.out.println("s5.equals(s6): "+s5.equals(s6));
		System.out.println("s6.equals(s7): "+s6.equals(s7));
		System.out.println("s6.equalsIgnoreCase(s7): "+s6.equalsIgnoreCase(s7));
		
		System.out.println("s5.compareTo(s6): "+s5.compareTo(s6));
		System.out.println("s6.compareToIgnoreCase(s7): "+s6.compareToIgnoreCase(s7));
		System.out.println("s7.compareTo(s8): "+s7.compareTo(s8));
		System.out.println("s7.compareToIgnoreCase(s8): "+s7.compareToIgnoreCase(s8));
		
		String s = "Java Programming Language , Java Language Programming";
		
		System.out.println("startsWith(\"java\"): "+s.startsWith("java"));
		System.out.println("startsWith(\"Java\"): "+s.startsWith("Java"));
		System.out.println("charAt(12): "+s.charAt(10));  //11 number element
		
		//System.out.println(s.substring(-1, 10));	//CE::Bonds
		
		s = s.replace("Java", "java");
		System.out.println(s);
		s = s.replace("java", "Java");
		System.out.println(s);
		s = s.replaceAll("Java", "java");
		System.out.println(s);
		s= s.replaceFirst("java", "Java");
		System.out.println(s);
	}
}
