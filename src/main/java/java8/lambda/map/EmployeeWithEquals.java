package java8.lambda.map;

import java.util.Objects;

public class EmployeeWithEquals {

	int id;
	String name;
	int age;
	String gender;
	String department;
	int yearOfJoining;
	double salary;

	public EmployeeWithEquals(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeWithEquals other = (EmployeeWithEquals) obj;
		return id == other.id && Objects.equals(name, other.name);
	}


	@Override
	public String toString() {
		return "PlainEmployee{name: " + name + ", department: " + department + ", yearOfJoining: " + yearOfJoining
				+ ", salary: " + salary + "}";
	}
}
