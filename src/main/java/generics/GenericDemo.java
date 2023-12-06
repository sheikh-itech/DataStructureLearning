package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo {

	public static void main(String args[]) {
		
		/**
		 * Without Generics, If we define Object level type safety
		 * then it fails because here we are able to add different types
		 * of values to single Demo Object
		 */
		Demo demo = new Demo();
		demo.add(1);
		demo.add('A');
		demo.add("Hapheej");
		System.out.println(demo.getAll());
		
	//++++++++++++++++++++++++++++++++++++++++++//
		
		/**
		 * The above problem has been solved using Generics
		 * "Type-Safe" version
		 */
		GenDemo<String> genDemo = new GenDemo<String>();
		genDemo.add("a");
		//genDemo.add('a');		compilation error
		//genDemo.add(12);		compilation error
		//genDemo.add(demo);	compilation error
		System.out.println(genDemo.getAll());
		
	}
}

class GenDemo<T> {
	
	private List<T> names;
	
	GenDemo() {
		super();
		this.names = new ArrayList<T>();
	}
	
	public void add(T name) {
		this.names.add(name);
	}
	
	public List<T> getAll() {
		
		return this.names;
	}	
}

class Demo {
	
	private List<Object> names;
	
	Demo() {
		super();
		this.names = new ArrayList<Object>();
	}
	
	public void add(Object name) {
		this.names.add(name);
	}
	
	public List<Object> getAll() {
		
		return this.names;
	}
}