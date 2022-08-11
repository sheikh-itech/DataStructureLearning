package ds.hk.io_streams;

import java.io.ObjectStreamField;
import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 3080214307844131427L;
	
	private int id;
	private String name;
	private String address;
	private transient int mobile;
	public static int zipCode;
	public volatile int countryCode;
	
	public Person(int id, String name, String address){
		
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		Person.zipCode = zipCode;
	}
	
	public int getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + ", mobile=" + mobile + ", countryCode="
				+ countryCode + "]";
	}
	
	// Declare that only name and height fields are serializable
	private static final ObjectStreamField[] serialPersistentFields
    = {new ObjectStreamField("name", String.class),
    		new ObjectStreamField("mobile", int.class)};
}
