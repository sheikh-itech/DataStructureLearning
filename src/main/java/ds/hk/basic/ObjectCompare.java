package ds.hk.basic;

/**			Object Comparison\n
 * 		---------------------------\n
 * 
 * 	1. Using '==' operator -> compares reference of Objects\n
 * 	2. Using equals() method -> Compares content of Objects based on implementation
 * 	3. Contract between toString() & hashCode(), should return same output
 */

public class ObjectCompare {

	public static void main(String[] args) {

		Object1 obj1 = new Object1("Hapheej");
		Object1 obj2 = new Object1("Hapheej");
		Object Obj3 = obj1;
		System.out.println("obj1 == obj2: "+(obj1 == obj2));
		System.out.println("obj1.equals(obj2): "+ obj1.equals(obj2));
		System.out.println("hashCode Compare: "+ (obj1.hashCode()==obj2.hashCode()));
		System.out.println("Obj3 == obj1: "+(Obj3 == obj1));
	}
}

class Object1 {
	
	private String name;
	private int num;
	
	Object1(String name) {
		
		this.name = name;
		this.num = 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Object1 other = (Object1) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (num != other.num)
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + num;
		return result;
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public int getNum() {
		
		return this.num;
	}
}