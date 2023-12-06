package hari_krishna.collection.set;

import java.util.LinkedHashSet;
import java.util.Set;

import hari_krishna.collection.Person;

/**	1. Ordered and Sorted [But No default Sorting]
 * 	2. Insertion Order, Natural Sorting
 * 	3. No Duplicate same like HashSet
 *
 */
public class LinkedHashSetDemo {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		Set<Person> set1 = new LinkedHashSet<>();
		set1.add(new Person(1, "Hapheej"));
		
		/**Skip adding, duplicate element because Person has hashCode() & equals() implemented 
		 * Otherwise it allows duplicate if Don't have hasCode() & equals() method
		 */
		set1.add(new Person(1, "Hapheej"));
		set1.add(new Person(2, "Hapheej"));
		set1.add(new Person(3, "Hapheej"));
		System.out.println(set1);
		
		Set<Integer> set2 = new LinkedHashSet<>();
		set2.add(5);
		set2.add(7);
		set2.add(0);
		set2.add(2);
		set2.add(3);
		set2.add(9);
		System.out.println(set2);
		
		Set<String> set3 = new LinkedHashSet<>();
		set3.add("Abcz");
		set3.add("Ebcz");
		set3.add("Bbcz");
		set3.add("Dbcz");
		set3.add("Cbcz");
		set3.add(null);
		set3.add(null);		//Duplicate 'null' will not be added
		System.out.println(set3);
		
		//Adding Heterogeneous Unique Elements
		Set set4 = new LinkedHashSet<>();
		set4.add("Hapheej");
		set4.add(10);
		set4.add(new Person(3, "Hapheej"));
		set4.add(10.5f);
		set4.add('a');
		System.out.println("Heterogeneous LinkedHashSet: "+set4);
	}
}
