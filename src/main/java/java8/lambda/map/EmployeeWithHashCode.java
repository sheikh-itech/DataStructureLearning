package java8.lambda.map;

import java.util.Objects;

public class EmployeeWithHashCode {

	int id;
	String name;
	int age;
	String gender;
	String department;
	int yearOfJoining;
	double salary;

	public EmployeeWithHashCode(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}


	@Override
	public String toString() {
		return "PlainEmployee{name: " + name + ", department: " + department + ", yearOfJoining: " + yearOfJoining
				+ ", salary: " + salary + "}";
	}
}
