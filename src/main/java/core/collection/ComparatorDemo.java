package core.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import core.collection.list.Person;
import core.collection.list.Student;

public class ComparatorDemo {

	public static void main(String[] args) {

		List<String> fruits = Arrays.asList("Blueberi", "Banana", "Apple", "Date", "Papaya", "Guava");
		
		fruits.sort(null);
		System.out.println("Length asc sort: "+fruits);
		
		fruits.sort((x, y) -> y.length()-x.length());
		System.out.println("Length desc sort: "+fruits);
		
		fruits.sort((x, y) -> x.compareTo(y));
		System.out.println("Natural asc sort: "+fruits);
		
		fruits.sort((x, y) -> y.compareTo(x));
		System.out.println("Natural desc sort: "+fruits);
		
		//  Multi-level Sorting
		
		List<Person> members = Arrays.asList(
				new Person(3, "Arham"),
				new Person(1, "Fatima"),
				new Person(35, "Hapheej"),
				new Person(55, "Shahad bee")
				);
		
		members.sort((p1, p2) -> p2.getAge()-p1.getAge());
		System.out.println("Age compare: "+members);
		
		members.sort(Comparator.comparing(Person::getAge).thenComparing(Person::getName));
		System.out.println("Age & name compare: "+members);
		
		members.sort(Comparator.comparing(Person::getAge).reversed());
		System.out.println("Age & name Desc compare: "+members);
		
		List<Student> students = Arrays.asList(
				new Student(42,74.3F),
				new Student(7,74.3F),
				new Student(8,95.8F),
				new Student(9,64.6F),
				new Student(12,74.4F),
				new Student(32,95.8F)
				);
		
		students.sort((s1, s2) -> s1.getRoll()-s2.getRoll());
		System.out.println("Natural asc sort: "+students);
		
		students.sort(Comparator.comparing(Student::getPercent).thenComparing(Student::getRoll));
		System.out.println("Percent & Roll asc sort: "+students);
		
		students.sort(Comparator.comparing(Student::getPercent).thenComparing(Student::getRoll).reversed());
		System.out.println("Percent & Roll desc sort: "+students);
	}

}
