package ds.hk.strings;

import java.util.StringTokenizer;

/**		After 1.4
 *	
 *	It is not recommended to use StringTokenizer
 *	use split() method of String instead
 */

public class StringTokenizerDemo {

	public static void main(String[] args) {

		//Default delimiter space ' ' 
		StringTokenizer token = new StringTokenizer("Java is programming language");
		while(token.hasMoreTokens())
			System.out.println(token.nextToken());
				
	}
}
