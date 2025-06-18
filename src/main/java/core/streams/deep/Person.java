package core.streams.deep;

import java.util.List;

public class Person {

	private String name;
	private String city;
	private List<String> hobbies;
	private int salary;
	
	public Person(String name, String city, int salary, List<String> hobbies) {
        this.name = name;
        this.city = city;
        this.hobbies = hobbies;
        this.salary = salary;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "{name: " + name + ", city: " + city + ", salary: " + salary + "}";
	}
}
