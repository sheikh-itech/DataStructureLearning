package core.collection.map;

import java.util.Objects;

public class Person {

	private int id;
	private String name;
	private int zip;
	
	public Person(int id, String name, int zip) {
		this.id = id;
		this.name = name;
		this.zip = zip;
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
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public int hashCode() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return id == other.id && Objects.equals(name, other.name) && zip == other.zip;
	}

	@Override
	public String toString() {
		return "P [id: " + id + ", name: " + name + ", zip: " + zip + "]";
	}
}
