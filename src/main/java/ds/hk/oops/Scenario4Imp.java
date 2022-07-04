package ds.hk.oops;

/**			Multiple Inheritance
 * 		-----------------------------
 * 
 * If two interface has same method name with different return type, then
 * we can not implement both in single class
 */
public class Scenario4Imp {

	public static void main(String[] args) {

	}
}

interface I7 {
	
	long add(int value1, int value2);
}

interface I8 {
	
	float add(int value1, int value2);
}

// This is Incompatible

/*class Add implements I7, I8 {

	//The return type is incompatible with I8.add(int, int)
	
	@Override
	public long add(int value1, int value2) {

		return 0;
	}
	
	//The return type is incompatible with I7.add(int, int)
	
	@Override
	public float add(int value1, int value2) {

		return 0;
	}
}*/