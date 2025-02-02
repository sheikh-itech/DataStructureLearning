package core.collection.map;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/**	If keys are weak referenced they eligible for GC [Not in case values weak referenced]
 *	Keys in a WeakHashMap are wrapped in weak references
 *	When a key is garbage collected, its corresponding entry is automatically removed from the map
 *	
 *	Each key is wrapped in a java.lang.ref.WeakReference
 *
 *	Only keys are weak references; values are strongly referenced
 *
 *	It helps in managing memory efficiently by allowing unused keys to be garbage collected, 
 *	making it suitable for caching or memory-sensitive applications
 *
 *	Apart from handling keys, WeakHashMap exactly behaves like HashMAp
 *
 *	Usage -> Cache, Metadata Storage
 */
public class WeakHashMapDemo {

	public static void main(String[] args) {
		
		WeakHashMap<Phone, String> phones = new WeakHashMap<>();
		
		Phone p1 = new Phone("Nokia");	//Strong reference till p1 not null
		Phone p2 = new Phone("Samsung");	//Strong reference till p2 not null
		Phone p3 = new Phone("Realme");	//Strong reference till p2 not null
		
		phones.put(p1, "Phone-1");
		phones.put(p2, "Phone-2");
		phones.put(p3, "Phone-3");
		phones.put(new Phone("One+"), "Phone-4");	//Weak Reference
		phones.put(new Phone("Redmi"), "Phone-5");	//Weak Reference
		
		p3 = null; //p3 is weak referenced now, means eligible for GC
		
		System.out.println(phones);
		
		//Method local scoped object with WeakHashMap
		
		WeakHashMap<String, String> names = new WeakHashMap<>();
		loadCache(names);
		
		System.out.println(names);
		
		System.gc();	//Suppose GC started by JVM here not manually
		
		randomTask();
		
		//Need to try by increasing sleep time
		System.out.println("After clearing cache few entries my removed");
		System.out.println(phones);
		System.out.println(names);
		
		//WeakHashMap Uses WeakReference<T> to hold keys
		
		String s = new String("String wrapped inside weak reference");
		WeakReference<String> weak = new WeakReference<String>(s);
		
		s = null;	//Weak reference [eligible for GC]
		
		System.out.println(weak.get());
		
		System.gc();	//Suppose GC started by JVM here not manually
		
		System.out.println("After GC");
		System.out.println(weak.get());
	}
	
	private static void loadCache(Map<String, String> names) {
		
		String s1 = new String("Alice");	//s1 scope is loadCache method
		String s2 = new String("Brown");	//s1 scope is loadCache method
		names.put(s1, "A");
		names.put(s2, "B");
	}
	
	private static void randomTask() {
		
		try {
			Thread.sleep(10000);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}

class Phone {
	
	private String brand;
	
	public Phone(String brand) {
		super();
		this.brand = brand;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "[" + brand + "]";
	}
}