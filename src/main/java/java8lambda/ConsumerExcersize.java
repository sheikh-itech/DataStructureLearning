package java8lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import ds.beans.Person;
import ds.beans.Person.Sex;

public class ConsumerExcersize {

	public static void main(String[] args) {

		List<Person> pers = Arrays.asList(new Person("Arham", "Vehleen", Sex.MALE),
				new Person("Hapheej", "Vehleen", Sex.MALE),
				new Person("Aastana", "Bee", Sex.FEMALE),
				new Person("Rafiq", "Mansoori", Sex.MALE),
				new Person("Sahil", "Miskini", Sex.MALE));

		printUsingLambda(pers, (p)->p.getLastName().contains("V"), p->System.out.println(p));
		
		printNameUsingLambda(pers, (p)->p.getLastName()!=null, name->System.out.println(name));
	}
	
	public static void printUsingLambda(List<Person> pers, Predicate<Person> pre, Consumer<Person> con) {
		
		pers.forEach(p->{
			if(pre.test(p))
				con.accept(p);
		});
	}
	
	public static void printNameUsingLambda(List<Person> pers, Predicate<Person> pre, Consumer<String> con) {
		
		pers.forEach(p->{
			if(pre.test(p))
				con.accept(p.getFirstName());
		});
	}
}
