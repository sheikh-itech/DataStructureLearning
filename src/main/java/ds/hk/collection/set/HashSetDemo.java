package ds.hk.collection.set;

import java.util.HashSet;
import java.util.Set;

import ds.hk.collection.Employee;
import ds.hk.collection.Person;

/**	1. Having initial Capacity 16, load Factor 0.75
 *	2. No Duplicates Allowed if same reference address
 * 	3. Allows Unique Elements Only [by state], If hashCode() & equals() Overridden
 * 	4. Allows Duplicate [different reference but same data], 
 * 		If hashCode() & equals() Not Overridden
 * 	5. Un-Ordered & Un-Sorted
 */
public class HashSetDemo {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		/** Default HashSet */
		Set<Person> set1 = new HashSet<>();
		set1.add(new Person(1, "Hapheej"));
		
		/**Skip adding, duplicate element because Person has hashCode() & equals() implemented 
		 * Otherwise it allows duplicate if Don't have hasCode() & equals() method
		 */
		set1.add(new Person(1, "Hapheej"));
		set1.add(new Person(2, "Hapheej"));
		set1.add(new Person(3, "Hapheej"));
		
		/** HashSet with supplied Capacity */
		Set<Person> set2 = new HashSet<>(32);
		set2.add(new Person(1, "Hapheej"));
		
		/** HashSet with supplied Capacity & Load Factor */
		Set<Person> set3 = new HashSet<>(3, 9);
		set3.add(new Person(1, "Hapheej"));
		
		System.out.println(set1);
		System.out.println(set2);
		System.out.println(set3);
		
		//Duplicate Not allowed with Same Reference Address
		Set<Employee> emp = new HashSet<>();
		Employee e1 = new Employee(1, "hapheej");
		Employee e2 = e1;
		Employee e3 = e1;
		Employee e4 = null;
		emp.add(e1);
		emp.add(e2);
		emp.add(e3);
		emp.add(null);
		emp.add(null);		//Duplicate 'null' will not be added
		emp.add(e4);		//Duplicate 'null' reference will not be added
		
		System.out.println("No Duplicate bcz Same Reference: "+emp);
		
		
		// Duplicate Elements Adding Bcz hasCode & equals not written
		Set<Employee> emps = new HashSet<>();
		System.out.println("Size of Empty HashSet: "+emps.size());
		emps.add(new Employee(1, "hapheej"));
		emps.add(new Employee(1, "hapheej"));
		emps.add(new Employee(1, "hapheej"));
		System.out.println("Duplicate Emp Set: "+emps);
		
		//Adding Heterogeneous Unique Elements
		Set set4 = new HashSet<>();
		set4.add("Hapheej");
		set4.add(10);
		set4.add(new Person(3, "Hapheej"));
		set4.add(10.5f);
		set4.add('a');
		System.out.println("Heterogeneous HashSet: "+set4);
	}
}
