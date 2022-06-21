package ds.beans;

public class User {
	private String username;
	private Address address;
	private int salary;
	private int age;
	
	public User() {
		
	}
	/**
	* Another constructor for class Time1
	* @param username	<used to store the name of user>
	* @param address	<this is derived data type to hold user residential details>
	* @param salary		<salasy represents the user's monthly income>
	* @param age		<age represents actual age of user>
	*/
	public User(String username, Address address, int salary, int age) {
		this.username = username;
		this.address = address;
		this.salary = salary;
		this.age = age;
	}
	public String toString() {
		return "User Details\n-----------\n"+this.username+" "+this.salary+" "+this.age+
				"\n\nUser Address\n-------------\n"+this.address;
	}
/*	public static void main(String []args) {
		Address adr = new Address("upper street", "bhopal", "Bhopal", "India", 480224);
		User u = new User("hafeez", adr, 15000, 28);
		System.out.println(u);
	}
*/}
