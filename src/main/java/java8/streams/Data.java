package java8.streams;

import java.util.ArrayList;
import java.util.List;

public class Data {

	public static List<Widget> getWidgets() {
		
		List<Widget> widgets = new ArrayList<Widget>();
		widgets.add(new Widget(1, 10, "White"));
		widgets.add(new Widget(2, 20, "Black"));
		widgets.add(new Widget(3, 15, "White"));
		widgets.add(new Widget(4, 25, "Blue"));
		widgets.add(new Widget(5, 100, "Pink"));
		widgets.add(new Widget(6, 77, "Green"));
		widgets.add(new Widget(7, 8, "Red"));
		widgets.add(new Widget(8, 18, "Red"));
		widgets.add(new Widget(9, 28, "Red"));
		widgets.add(new Widget(10, 38, "Red"));
		
		return widgets;
	}
	
	public static List<Product> getProducts() {
		
		List<Product> productList = new ArrayList<>();
		productList.add(new Product(23, "potatoes"));
		productList.add(new Product(14, "orange"));
		productList.add(new Product(13, "lemon"));
		productList.add(new Product(23, "bread"));
		productList.add(new Product(13, "sugar"));
		return productList;
	}
	
	public static List<Employee> getEmployees() {
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee(1, "Sheikh", "Dev", "IT", 30.0f, "Pune"));
		emps.add(new Employee(2, "Arham", "Dev", "IT", 22.0f, "Pune"));
		emps.add(new Employee(3, "Aastana", "Dev", "IT", 32.0f, "Pune"));
		emps.add(new Employee(4, "Sheikh", "Dev", "Sales", 28.0f, "Pune"));
		emps.add(new Employee(5, "Arham", "Senior Dev", "R&D", 38.0f, "Pune"));
		emps.add(new Employee(6, "Aman", "Dev", "IT", 19.0f, "Pune"));
		emps.add(new Employee(7, "Arhan", "Dev", "IT", 37.0f, "Pune"));
		emps.add(new Employee(8, "Ainam", "Manager", "IT", 40.0f, "Pune"));
		emps.add(new Employee(9, "Arslan", "Lead Executive", "Sales", 34.0f, "Pune"));
		emps.add(new Employee(10, "Azhar", "Executive", "Sales", 24.0f, "Pune"));
		
		return emps;
	}
	public static List<Integer> getIntList(int max) {
		
		List<Integer> nums = new ArrayList<Integer>();
		while(max>0) {
			nums.add(max);
			max--;
		}
		return nums;
	}
	
	public static List<Integer> getIntList() {
		return getIntList(9999);		
	}
}

class Employee {
	
	private int id;
	private float salary;
	private String name;
	private String address;
	private String dept;
	private String design;
	
	public Employee(int id, String name, String design, String dept, float salary, String address) {
		this.id = id;
		this.name = name;
		this.design = design;
		this.dept = dept;
		this.salary = salary;
		this.address = address;
	}

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public float getSalary() {return salary;}
	public void setSalary(float salary) {this.salary = salary;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}
	public String getDept() {return dept;}
	public void setDept(String dept) {this.dept = dept;}
	public String getDesign() {return design;}
	public void setDesign(String design) {this.design = design;}

	@Override
	public int hashCode() {
		int result = 1;
		result = 31 * result + id;
		result = 31 * result + ((name == null) ? 0 : name.hashCode());
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
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public String toString() {
		return name;
	}
}
class Widget {
	
	private int weight;
	private String color;
	private int id;
	
	public Widget() {	}
	
	public Widget(int id, int weight, String color) {
		this.id = id;
		this.weight = weight;
		this.color = color;
	}
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "{"+id+", "+color+"}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
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
		Widget other = (Widget) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}
}

class Product {
	
	private int price;
	private String name;
	
	public Product(int price, String name) {
		this.price = price;
		this.name = name;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "{"+price+", "+name+"}";
	}
}