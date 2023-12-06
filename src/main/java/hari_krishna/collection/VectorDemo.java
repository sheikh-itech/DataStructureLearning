package hari_krishna.collection;

import java.util.Comparator;
import java.util.Vector;

/**
 *	Stores element in array format
 *	It is thread-safe so performance gets down
 *	All methods are synchronized
 */

//Multiple marker not allowed means <T> & <E>
//public class VectorDemo1<T>  extends Vector<E> {

//Below one allowed
//public class VectorDemo1<T, E> extends Vector<E> {

public class VectorDemo<E> extends Vector<E> {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		//Create Generic Using Subclass
		
		VectorDemo<Integer> integers = new VectorDemo<>();
		integers.add(10);
		integers.addElement(20);
		
		System.out.println(integers);
		
		//Call directly Generic Class
		
		Vector<Integer> in = new Vector<>(  );
		in.add(50);
		in.add(30);			//Simply adds element
		in.addElement(35);	//Adds element and increases size of vector by 1
		in.remove(0);
		in.add(70);
		in.add(85);
		in.add(2);
		in.add(9);
		in.add(46);

		System.out.println("Sublist from Vector: "+in.subList(2,  5));

		in.sort( getComparator1() );
		
		System.out.println("Sorted Vector: "+in);	//Calls toString() internally
		
		Vector<Integer> in1 = new Vector<>();
		in1.add(2);
		in1.add(92);
		
		System.out.println("Contains other Vector: "+in.containsAll(in1));
		
		System.out.println("Vector Contains 2: "+in.contains(2));
		System.out.println("Index of 2: "+in.indexOf(2));
		System.out.println("Last index of 2: "+in.lastIndexOf(2));
		System.out.println("First element: "+in.firstElement());
		System.out.println("Get 2nd element: "+in.get(2));
		System.out.println("Last element: "+in.lastElement());
		
		/**Replaces the element at the specified position in this Vector
		 * With the specified element
		 */
		in.set(2, 78);
		System.out.println("Updated index 2: "+in);
		
		in.retainAll(in1);
		System.out.println("Retain all element of in from in1:"+in);
		
		in.removeAll(in1);
		System.out.println("After removing: "+in);
	}
	
	static Comparator<Integer> getComparator1() {
		
		return new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {

				if(o1>o2)
					return 1;
				else if(o2>o1)
					return -1;
				
				return 0;
			}
		};
	}
}
