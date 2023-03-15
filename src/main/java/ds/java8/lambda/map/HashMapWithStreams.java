package ds.java8.lambda.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;


public class HashMapWithStreams {

	public static void main(String[] args) {
		
		Map<Object, Long> emps = getEmployees().stream().map(emp->emp.gender).collect(Collectors.groupingBy(key->key, Collectors.counting()));
		System.out.println(emps);
		
		Map<String,Integer> hm = new HashMap<>();
		hm.put("abc",5);
		hm.put("xyz",4);
		hm.put("pqr",1);
		hm.put("RTY",2);
		
		List<Entry<String, Integer>>hm1 = hm.entrySet().stream().sorted((e1, e2)->e1.getValue()-e2.getValue()).collect(Collectors.toList());
		System.out.println(hm1);
		
		Map<Employee, String> hm2 = new HashMap<>();
		Employee e1 = new Employee(111, "Jiya Brein", 32, "Female", "HR-1", 2011, 250.0);
		Employee e12 = new Employee(111, "Jiya Brein", 32, "Female", "HR-2", 2012, 350.0);
		hm2.put(e1, "abc");
		hm2.put(e1, "npr");
		hm2.put(e1, "xyz");
		hm2.put(e12, "abc");
		System.out.println(hm2);
		
		Map<EmployeeWithHashCode, String> hashCodeOverriden = new HashMap<>();
		EmployeeWithHashCode e2 = new EmployeeWithHashCode(111, "Jiya Brein", 32, "Female", "HR-1", 2011, 2500.0);
		EmployeeWithHashCode e21 = new EmployeeWithHashCode(111, "Jiya Brein", 32, "Female", "HR-2", 2012, 3050.0);
		hashCodeOverriden.put(e2, "abc");
		hashCodeOverriden.put(e2, "npr");
		hashCodeOverriden.put(e2, "xyz");
		hashCodeOverriden.put(e21, "xyz");
		System.out.println(hashCodeOverriden);
		
		Map<EmployeeWithEquals, String> equalsOverriden = new HashMap<>();
		EmployeeWithEquals e3 = new EmployeeWithEquals(111, "Jiya Brein", 32, "Female", "HR-1", 2011, 2500.0);
		EmployeeWithEquals e31 = new EmployeeWithEquals(111, "Jiya Brein", 22, "Female", "HR-2", 2012, 4500.0);
		equalsOverriden.put(e3, "abc");
		equalsOverriden.put(e3, "npr");
		equalsOverriden.put(e3, "xyz");
		equalsOverriden.put(e31, "xyz");
		System.out.println(hashCodeOverriden);
		
		Map<PlainEmployee, String> hm3 = new HashMap<>();
		PlainEmployee e4 = new PlainEmployee(111, "Jiya Brein", 32, "Female", "HR-1", 2011, 270.0);
		PlainEmployee e5 = new PlainEmployee(111, "Jiya Brein", 32, "Female", "HR-2", 2012, 200.0);
		hm3.put(e4, "abc");
		hm3.put(e4, "npr");
		hm3.put(e4, "xyz");
		hm3.put(e5, "abc");
		e5.salary=300f;
		System.out.println(hm3);
		
		Map<String, Employee> equalsHashCode = new HashMap<>();
		equalsHashCode.put("abc1", e1);
		equalsHashCode.put("abc1", e12);
		equalsHashCode.put("abc2", e12);
		System.out.println(equalsHashCode);
		
		Map<String, EmployeeWithHashCode> hashCodeOverriden1 = new HashMap<>();
		hashCodeOverriden1.put("abc", e2);
		hashCodeOverriden1.put("abc", e21);
		hashCodeOverriden1.put("xyz", e21);
		System.out.println(hashCodeOverriden1);
		
		Map<String, EmployeeWithEquals> equalsOverriden1 = new HashMap<>();
		equalsOverriden1.put("abc", e3);
		equalsOverriden1.put("abc", e31);
		equalsOverriden1.put("xyz", e31);
		System.out.println(hashCodeOverriden1);
	}

	public static List<Employee> getEmployees() {
		List<Employee> emps = new ArrayList<Employee>();
		emps.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		emps.add(new Employee(122, "Paul Niksui", 25, "Female", "Sales And Marketing", 2015, 13500.0));
		emps.add(new Employee(133, "Martin Theron", 29, "Female", "Infrastructure", 2012, 18000.0));
		emps.add(new Employee(134, "Martin Theron1", 29, "Male", "Infrastructure", 2012, 18000.0));
		return emps;
	}
}

