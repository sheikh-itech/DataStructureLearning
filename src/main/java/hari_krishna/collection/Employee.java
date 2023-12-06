package hari_krishna.collection;

public class Employee implements Comparable<Employee> {

	private String name;
	private int id;

	public Employee(int id, String name) {
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "{id: "+id+", name: " + name + "}";
	}
	
	@Override
	public int compareTo(Employee e) {
		
		/*if(this.id > e.getId())
			return 1;
		if(this.id < e.getId())
			return -1;*/
		
		//Descending Order
		//return e.getId() - this.id;
		
		return this.id - e.getId();
	}
}
