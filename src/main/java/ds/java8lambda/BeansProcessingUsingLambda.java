package ds.java8lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import learn.ds.beans.Person;
import learn.ds.beans.Person.Sex;

public class BeansProcessingUsingLambda {

	public static void main(String[] args) {
		
		getPersons();
	}

	public static void getPersons() {
		
		List<Person> pers = Arrays.asList(new Person("Arham", "Vehleen", Sex.MALE),
				new Person("Hapheej", "Vehleen", Sex.MALE),
				new Person("Aastana", "Bee", Sex.FEMALE),
				new Person("Rafiq", "Mansoori", Sex.MALE),
				new Person("Sahil", "Miskini", Sex.MALE));
		
		Collections.sort(pers, new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.getLastName().compareTo(p2.getLastName());
			}
		});
		
		Condition<Person> con = (p)-> p.getLastName().contains("V");
		pers.forEach(per->{
			if(con.test(per))
				System.out.println(per);
		});
		System.out.println();
		
	//Using Lambdas
		
		Collections.sort(pers, (p1, p2)-> p1.getLastName().compareTo(p2.getLastName()));
		
		pers.forEach(p->{
			if(p.getFirstName().contains("A"))
				System.out.println(p);
		});
		
	}
}

interface Condition<T> {
	
	boolean test(T t1);
}
