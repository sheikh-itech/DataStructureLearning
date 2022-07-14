package ds.hk.collection;

import java.util.Collection;
import java.util.Vector;

public class VectorDemoOld<T> {

	private Vector<T> vector;
	
	public static void main(String[] args) {
		
		VectorDemoOld<Integer> integers = new VectorDemoOld<Integer>();
		integers.createVector();
		integers.addElement(1);
		integers.addElement(2);
		integers.addElement(3);
		integers.addElement(4);
		integers.addElement(2);
		integers.addElement(2, 72);
		System.out.println(integers);
		
		VectorDemoOld<String> names = new VectorDemoOld<>();
		names.createVector();
		names.addElement("hapheej");
		names.addElement("Sheikh");
		names.addElement("Mansoori");
		System.out.println(names);
		
		VectorDemoOld<Object> obj = new VectorDemoOld<>();
		obj.createVector();
		obj.addElement(1);
		obj.addElement("Hapheej");
		obj.addElement(10.5f);
		obj.addElement(45L);
		obj.addElement(8.9d);
		obj.addElement('a');
		System.out.println(obj);
	}
	
	void createVector() {
		
		this.vector = new Vector<T>();
	}
	
	void addElement(T t) {
		this.vector.add(t);
	}
	
	void addElement(int index,T t) {
		this.vector.add(index, t);
	}
	
	void addAllElement(Collection<? extends T> t) {
		this.vector.addAll(t);
	}
	
	T getElement(int index) {
		
		return vector.get(index);
	}
	
	@Override
	public String toString() {
		
		String str="{";
		
		for(T t:vector) {
			str=str+t+", ";
		}
		str = str.substring(0, str.length()-2);
		return str+"}";
	}
}
