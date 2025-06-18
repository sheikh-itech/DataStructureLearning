package core.lambda.deep;

public class Employee {

	private int id;
	private String name;
	private float salary;
	private String dept;
	private boolean isActive;
	
	public Employee(int id, String name, float salary, String dept) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dept = dept;
		this.isActive = true;
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public boolean isActive() {
		return isActive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee setActive(boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	@Override
	public String toString() {
		return "Emp [Name: " + name + ", Salary: " + salary+ ", Dept: " + dept + "]";
	}
}
