package java8.lambda.map;

public class PlainEmployee {

	int id;
	String name;
	int age;
	String gender;
	String department;
	int yearOfJoining;
	double salary;

	public PlainEmployee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "PlainEmployee{name: " + name + ", department: " + department + ", yearOfJoining: " + yearOfJoining
				+ ", salary: " + salary + "}";
	}
}
