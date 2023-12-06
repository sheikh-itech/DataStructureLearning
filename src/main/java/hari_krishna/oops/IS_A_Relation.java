package hari_krishna.oops;

public class IS_A_Relation {

	public static void main(String[] args) {

		Person p = new Person("Hapheej", 33);
		System.out.println("Person: "+p);
		
		p = new Student("Hapheej", 33, 436891);
		System.out.println("Student: "+p);
	}

}

class Person {
	
	protected String name;
	protected int age;
	
	Person(String name, int age) {
		super();
		this.name =name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		
		return "{" + this.name + ", " + this.age + "}";
	}
}

class Student extends Person {
	
	private int rollNum;
	
	Student(String name, int age, int rollNum) {
		super(name, age);
		this.rollNum = rollNum;
	}

	public int getRollNum() {
		return rollNum;
	}

	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}
	
	public String toString() {
		
		return "{" + this.name + ", " + this.rollNum + ", " + this.age + "}";
	}
}