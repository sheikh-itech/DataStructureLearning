package hari_krishna.oops;

/**
 * 		----Encapsulation Or Data Hiding------
 *  
 * Defining class by hiding implementation details (data)
 * And exposing its functionality by behaviors (with proper validation if required)
 */
 
public class Encapsulation {

	public static void main(String[] args) {
		
		Customer customer = new Customer(9753806987l, "Hapheej", "Narsinghpur");
		System.out.println(customer);
	}
}

class Customer {
	
	private long mobile;
	private String name;
	private String address;
	
	Customer(long mobile, String name, String address) {
		
		this.mobile = mobile;
		this.name = name;
		this.address = address;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString() {
		
		return "{"+this.name+", "+this.mobile+", "+this.address+"}";
	}
}