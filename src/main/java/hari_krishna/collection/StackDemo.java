package hari_krishna.collection;

import java.util.Stack;

/**
 *	Stack is Subclass of Vector, so Stack has every non-private members of Vector
 *	Stack don't have 0 index, it's indexes starts from 1
 */
public class StackDemo {

	public static void main(String[] args) {

		Stack<Integer> integers = new Stack<>();
		
		/** Pushes an item onto the top of this stack.
		 *  This has exactly the same effect as addElement
		 */
		integers.push(0);
		integers.push(1);
		integers.push(2);
		integers.push(3);
		integers.push(12);
		integers.push(21);
		integers.push(2);
		
		System.out.println(integers);
		
		int peek = integers.peek();
		System.out.println("Peek Element: "+peek);
		
		/** Removes the object at the top of this stack and returns that object
		 *  As the value of this function, pop() is synchronized
		 */
		int pop = integers.pop();
		System.out.println("Poped Element: "+pop);
		
		int index = integers.search(12);
		System.out.println("Index of Element 12: "+index);
		
		/** Below Operations From Vector SuperClass */
		System.out.println("Removing from index 3: "+integers.remove(3));
		integers.add(2, 66);
		System.out.println("Added 66 to 2nd index: "+integers);
		
		/** Search elements from TOP, starting from index 1*/
		System.out.println("Search 12 in stack: "+integers.search(12));
		
		/** Since Stack is subclass of Vector,
		 * so we can use Vector method but not recommended
		 */
	}
}
