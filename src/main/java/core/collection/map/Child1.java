package core.collection.map;

import java.util.Objects;

public class Child1 {

	private String name;
	 
	public Child1(String name) {
		 this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Child1 [name: " + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Child1 other = (Child1) obj;
		return Objects.equals(name, other.name);
	}
}
