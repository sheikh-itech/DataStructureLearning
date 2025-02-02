package core.collection;

import java.util.ArrayList;
import java.util.List;

public class ComparableDemo {

	public static void main(String[] args) {
		
		List<Integer> nums = new ArrayList<>();
		nums.add(5);
		nums.add(1);
		nums.add(2);
		
		nums.sort(null); //Natural Ordering sort in case of primitive types
		
		List<String> names = new ArrayList<>();
		names.add("Alice");
		names.add("Bob");
		
		//Natural order sorting not works in Strings or any Custom Objects, Needs custom sorting
		//names.sort(null);
		
		List<Person> names1 = new ArrayList<>();
		names1.add(new Person("Topizo"));
		names1.add(new Person("Bob"));
		names1.add(new Person("Alice"));
		
		names1.sort(null);
		
		System.out.println(names1);
		
		// Siblings [Random Object] sort using parent class
		
		List<Object> random = new ArrayList<>();
		
		random.add(new Citizen("Bob", 30));
		random.add(new Citizen("Alice", 35));
		random.add(new Student("Fatima", 25));
		random.add(new Student("Arham", 28));
		
		random.sort(null);
		
		System.out.println("\nRandom Object Sort");
		System.out.println(random);
	}
}

class Person implements Comparable<Person> {

	private String name;
	
	public Person(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public int compareTo(Person o) {
		
		if(Integer.valueOf(this.name.charAt(0)) > Integer.valueOf(o.name.charAt(0)))
			return 1;
		if(Integer.valueOf(this.name.charAt(0)) < Integer.valueOf(o.name.charAt(0)))
			return -1;
		
		return 0;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Name: " + name;
	}
}

class Human implements Comparable<Human> {
	
	protected String name;
	protected int aadhar;
	
	public Human(String name, int aadhar) {
		super();
		this.name = name;
		this.aadhar = aadhar;
	}

	@Override
	public int compareTo(Human o) {
		
		if(this.aadhar > o.getAadhar())
			return 1;
		if(this.aadhar < o.getAadhar())
			return -1;
		
		return 0;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAadhar() {
		return aadhar;
	}

	public void setAadhar(int aadhar) {
		this.aadhar = aadhar;
	}
}

class Citizen extends Human {

	public Citizen(String name, int aadhar) {
		super(name, aadhar);
	}

	@Override
	public String toString() {
		return "Citizen[Aadhar: " + aadhar + ", Name: " + name + "]";
	}
}

class Student extends Human {
	
	public Student(String name, int aadhar) {
		super(name, aadhar);
	}

	@Override
	public String toString() {
		return "Student[Aadhar: " + aadhar + ", Name: " + name + "]";
	}
}