package hari_krishna.collection;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/**			Enumeration			<br/><br/>
 * 
 *	1. Implemented factory methods in Vector class		<br/>
 *	2. Implemented factory methods in HashTable class	<br/>
 */

public class EnumerationDemo {

	public static void main(String[] args) {

		/**	Enumeration using Hashtable Class	*/
		Hashtable<Integer, String> names = new Hashtable<>();
		
		names.put(1, "hapheej");
		names.put(2, "mansoori");
		names.put(3, "sheikh");
		System.out.println(names);
		
		Enumeration<Integer> keyEnumerator = names.keys();
		System.out.println("\nUsing Enumeration In Keys\n--------------------------");
		while(keyEnumerator.hasMoreElements()) {
			System.out.println(keyEnumerator.nextElement());
		}
		
		Enumeration<String> valEnumerator = names.elements();
		System.out.println("\nUsing Enumeration In values\n---------------------------");
		while(valEnumerator.hasMoreElements()) {
			System.out.println(valEnumerator.nextElement());
		}
		
		/**	Enumeration using Vector Class	
		 *  Vector class also supports Iterator bcz It implements List
		 */
		
		Vector<Integer> nums = new Vector<>();
		
		nums.add(1);
		nums.add(5);
		nums.add(9);
		nums.add(0);
		
		Enumeration<Integer> vectorEnum = nums.elements();
		System.out.println("\nUsing Enumeration In Vector Class\n--------------------------------");
		while(vectorEnum.hasMoreElements()) {
			System.out.println(vectorEnum.nextElement());
		}
	}
}
