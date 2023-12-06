package hari_krishna.collection.queue;

import java.util.LinkedList;

import hari_krishna.collection.Person;

/**
 *	1. Doubly-linked list implementation of List and Deque interfaces
 *	2. Allows Duplicate, Permits Multiple null 
 *	3. Traverse from both ends -> Beginning Or End
 *	4. This is Not Thread-Safe (Collections.synchronizedList)
 *	5. Fail-Fast Iterator::Concurrent Modification Not Allowed
 *
 */
public class LinkedListDemo {

	public static void main(String[] args) {
		
		LinkedList<Person> names = new LinkedList<>();
		Person p1 = new Person(11, "11");
		names.add(new Person(10, "10"));
		names.add(p1);
		
		LinkedList<Person> person = new LinkedList<>();
		person.add(new Person(1,"sheikh"));
		person.add(0, new Person(2,"Hapheej"));	//Add in First Position
		
		person.addAll(0, names);	//Add Collection
		
		person.addFirst(new Person(2, "First"));
		Person p2 = new Person(2,"Hapheej");
		person.add(p2);
		person.addLast(new Person(3, "Last"));
		
		System.out.println("First Element: "+person.element());
		System.out.println("Index 1 Element: "+person.get(1));
		System.out.println("Index of Person(11, 11): "+person.indexOf(p1));
		System.out.println("Last Index of Person(2, Hapheej): "+person.lastIndexOf(p2));
		System.out.println("5th Element: "+person.get(5));
		
		//Queue Implemented Operations
		
		System.out.println("peek(): "+person.peek());	//Retrieves, but does not remove
		System.out.println("peekLast(): "+person.peekLast()); //Only Retrieve
		System.out.println("peekFirst(): "+person.peekFirst());	//Only Retrieve
		
		System.out.println("pop(): "+person.pop());
		System.out.println("pollLast(): "+person.pollLast());
		System.out.println("pollFirst(): "+person.pollFirst());
		
		person.push(new Person(7, "Newly Pushed"));
		System.out.println("Pushed New Element: "+person);
		
		System.out.println("Remove: "+person.remove()); 	//Remove First Element
		System.out.println("Removed p1: "+person.remove(p1));
		System.out.println("removeLast(): "+person.removeLast());
		System.out.println("removeLastOccurrence(p2): "+person.removeLastOccurrence(p2));
		
		System.out.println(person.set(0, new Person(1, "Vahleen")));//Updates Element
		// System.out.println(person.set(1, new Person(1, "Vahleen")));//Only Update::IndexOutOfBounds
		person.add(p1);
		person.add(p1);
		person.add(p1);
		person.add(null);
		person.add(null);
		
		Object[] nameArray = person.toArray();
		System.out.println("Converted toArray: "+nameArray.toString());
		
		Person[] newArray=new Person[5];
		Person[] array = person.toArray(newArray);
		System.out.println("Converted to person array: "+array.toString());
		
		System.out.println(person);
	}
}
