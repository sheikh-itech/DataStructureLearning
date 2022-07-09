package ds.hk.strings;

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
	}
}
