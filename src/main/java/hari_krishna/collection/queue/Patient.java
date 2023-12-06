package hari_krishna.collection.queue;

public class Patient implements Comparable<Patient>{

	private int number;
	private String name;
	private boolean isSerious;
	
	public Patient(int number, String name, boolean isSerious) {
		this.number = number;
		this.name = name;
		this.isSerious = isSerious;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSerious() {
		return isSerious;
	}
	public void setSerious(boolean isSerious) {
		this.isSerious = isSerious;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isSerious ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Patient other = (Patient) obj;
		if (isSerious != other.isSerious)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "{number=" + number + ", name=" + name + ", isSerious=" + isSerious + "}";
	}
	
	@Override
	public int compareTo(Patient o) {
		
		return this.number - o.number;
	}
}
