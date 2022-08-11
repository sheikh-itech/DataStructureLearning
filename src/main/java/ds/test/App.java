package ds.test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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
		
		Set<Test12> t = new HashSet<>();
		Test12 t1 = new Test12();
		t.add(t1);
		t.add(t1);
		t.add(t1);
		t.add(t1);
		t.forEach(a->System.out.println(a.id));
	}
}

class Test12 {
	public int id=10;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;//+new Random().nextInt();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test12 other = (Test12) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}