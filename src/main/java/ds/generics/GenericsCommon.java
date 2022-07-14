package ds.generics;

import java.util.ArrayList;
import java.util.List;

/**
 *	1. Up-Casting Not Allowed In Generic
 *
 *	List<String> names --> For Compile Time Check
 *	new ArrayList<String>() --> For Runtime
 *	List names --> promotes to ==> List<Object> names
 */

public class GenericsCommon {

	public static void main(String[] args) {

		//Type mismatch: cannot convert from ArrayList<String> to List<Object>
		//List<Object> names = new ArrayList<String>();
		
		List<String> names = new ArrayList<String>();
		names.add("sheikh");
		
		//Method add(int, String) is not applicable for the arguments (int)
		//names.add(10);
		System.out.println(names);
		
		List names1 = new ArrayList<Integer>();	//names1 becomes of type Object
		names1.add("sheikh");
		names1.add(10);
		names1.add(10.5d);
		System.out.println(names1);
		
		List names2 = new ArrayList<Integer>();
		names2.add(new A("sheikh"));
		names2.add(35.5d);
		System.out.println(names2);
		
		List l1 = new ArrayList<>();
		l1.add(new A("hapheej"));
		m1(l1);
		
	}
	
	static void m1(List<B> list) {
		System.out.println(list);
	}
}

class A {
	
	private String name;
	
	A(String name) {
		this.name = name;
	}
	
	public String toString() {
		
		return this.name;
	}
}

class B {
	
}