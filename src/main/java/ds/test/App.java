package ds.test;

import ds.beans.Person;

/**
 * @author Hapheej
 *
 */
public class App {

	public static void main(String []args) {
		Person per = new Person();
		per.setGender(Person.Sex.MALE);
		System.out.println(Person.Sex.MALE);
		
		
	}
}
