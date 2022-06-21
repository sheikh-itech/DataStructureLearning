package ds.beans;

public class Employee {
	private String name;
	private int salary;
	private Address address;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Employee(String name, int salary, Address address) {
		this.name = name;
		this.salary = salary;
		this.address = address;
	}
	public String toString() {
		return "Employee Details -> "+this.name+" "+this.salary+
				", Address Address -> "+this.address+"\n";
	}
}
