package java8.lambda;

import java.time.LocalDate;

public class Employee {

	private String name;
	private float salary;
	private LocalDate startDate;
	
	
	public Employee() {	}
	
	public Employee(String name, float salary, LocalDate startDate) {
		super();
		this.name = name;
		this.salary = salary;
		this.startDate = startDate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "Emp{name: " + name + ", salary: " + salary + ", startDate: " + startDate + "}";
	}
}
