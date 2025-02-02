package core.collection.list;

import java.util.LinkedList;
import java.util.Stack;

/**	Last in First out -> Principle of Stack [It is linear data structure]
 * 	but since Stack implements List thats why it also having List functionality
 * 	LIFO Order
 * 		Recently added element is the first to be removed
 * 	Single Point of Access
 * 		Operations are performed only at the top of the stack
 * 	Dynamic or Fixed Size
 * 		Depending on the implementation, stacks can either grow dynamically or have a fixed size
 * 	Recursive Nature
 * 		Stacks are often used to implement recursion internally (e.g., function call stack)
 * 	Synchronized
 * 		All the methods are synchronized means thread safe
 * 
 * 	Push
 * 		Adds an element to the top of the stack
 * 	Pop
 * 		Removes the top element from the stack
 * 	Peek/Top
 * 		Returns the top element of the stack without removing it
 * 	isEmpty
 * 		Checks if the stack is empty
 * 
 * 	Usage Of Stack
 * 	--------------
 * 	Function Call Management
 * 		Every function call is pushed onto the stack. When a function ends, it is popped
 * 	Expression Evaluation
 * 		Infix to postfix conversion and evaluation
 * 	Backtracking
 * 		Navigating back in problems like mazes, games, or undo features in applications
 * 	Parsing
 * 		Parsing expressions or programming languages
 * 	Browser History
 * 		Implementing forward/backward navigation
 * 
 * 	Disadvantages
 * 		Can only access the top element directly
 * 		Fixed-size stacks can overflow
 * 		Attempting to pop from an empty stack causes underflow
 */
public class StackDemo {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();
		
		stack.push(5);
		stack.push(7);
		stack.push(12);
		
		System.out.println(stack);
		
		Integer removedEle = stack.pop();
		System.out.println(stack);

		Integer retrievedEle = stack.peek();
		System.out.println(stack);
		
		System.out.println("IsEmpty: "+stack.isEmpty());
		System.out.println("Size: "+stack.size());
		
		System.out.println("Index of 5: "+stack.search(5));
		
		
		/*		Linked List As Stack	*/
		
		System.out.println("\nLinked List As Stack");
		
		LinkedList<Integer> nums = new LinkedList<>();
		
		nums.addLast(5);	//Equivalent to push
		nums.addLast(7);
		nums.addLast(12);
		
		nums.removeLast();	//Equivalent to pop
		
		nums.getLast();		//Equivalent to peek
		
		System.out.println(nums);
	}
}
