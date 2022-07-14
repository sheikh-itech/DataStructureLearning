package ds.hk.collection;

import java.util.Set;
import java.util.TreeSet;

/**
 *	1. Null's not allowed in TreeSet
 *	2. Adding Element/Value classes should be 'Comparable' type
 *	3. If not Comparable then ClassCastException will Occur
 *
 *	Note: Whatever type of Element added FIRST to RAW TreeSet, it becomes that type only..
 *		  If we add other type ClassCasException will come
 */

public class TreeSetDemo {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		//Custom Sorted Employee Objects, bcz Employee has compareTo method
		
		Set set1 = new TreeSet<>();
		
		set1.add(new Employee(1, "Hapheej"));
		set1.add(new Employee(3, "Hapheej"));
		set1.add(new Employee(2, "Hapheej"));
		
		//Exception, ClassCastException: Employee cannot be cast to Student
		//set1.add(new Student(2, "Hapheej"));
		
		//Exception in thread "main" ClassCastException
		//set1.add(12);
		//set1.add(32.5f);
		
		//Exception in thread "main" NullPointerException
		//set1.add(null);
		System.out.println(set1);
		
		Set set2 = new TreeSet<>();
		set2.add(new Student<>(1, "hapheej"));

		Set<Student> set3 = new TreeSet<>();
		
		/** After adding first Element to "set2",
		 * set2 & set3 become same by definition
		 */
		
		set3.add(new Student<>(1, "hapheej"));
		
		System.out.println(set2);
		System.out.println(set3);
		
		//Exception, ClassCastException: Student cannot be cast to Employee 
		//set2.add(new Employee(1, "hapheej"));
		
		//Naturally Sorted TreeSet Demo
		
		Set<Integer> nums = new TreeSet<>();
		nums.add(0);
		nums.add(75);
		nums.add(3);
		nums.add(12);
		nums.add(2);
		System.out.println("Natural Sorted: "+nums);
	}
}
