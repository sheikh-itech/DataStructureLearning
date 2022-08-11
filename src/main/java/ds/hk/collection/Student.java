package ds.hk.collection;

public class Student<T> implements Comparable<T> {

	private int id;
	private String name;
	
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int compareTo(T o) {
		
		Student other = (Student) o;
		
		if(this.id > other.getId())
			return 1;
		if(this.id < other.getId())
			return -1;
		return 0;
	}
	
	@Override
	public String toString() {
		return "{id=" + id + ", name=" + name + "}";
	}
}
