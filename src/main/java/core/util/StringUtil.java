package core.util;

import java.util.Arrays;

public class StringUtil {

	/* An anagram of a string is another string that contains the same characters, 
	 * only the order of characters can be different
	 */
	public static boolean isAnagram(String s1, String s2) {
		
		char[] c1 = s1.replaceAll("\\s+", "").toLowerCase().toCharArray();
	    char[] c2 = s2.replaceAll("\\s+", "").toLowerCase().toCharArray();
	    Arrays.sort(c1);
	    Arrays.sort(c2);
	    return Arrays.equals(c1, c2);
	}
}
