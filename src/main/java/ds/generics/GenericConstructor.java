package ds.generics;

public class GenericConstructor {

	public static void main(String args[]) {
	
		Type<String> names = new Type<String>("Hapheej");
		Type<Integer> nums = new Type<Integer>(1);
		
		System.out.println(names.getR());
		System.out.println(nums.getR());
	}
}

class Type<R> {
	
	private R r;
	
	<T> Type(R r) {
		this.r = r;
	}
	
	public R getR() {
		
		return r;
	}
}

class Type1<R> {
	
	<T> Type1(T t) {
		
	}
}