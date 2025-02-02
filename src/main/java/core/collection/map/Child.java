package core.collection.map;

public class Child {

	private String name;
	 
	public Child(String name) {
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
		return "Child [name: " + name + "]";
	}
}
