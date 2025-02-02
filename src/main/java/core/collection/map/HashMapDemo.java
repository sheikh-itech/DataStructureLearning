package core.collection.map;

import java.util.HashMap;
import java.util.Map.Entry;

/**	Does not maintain any order
 *	Single Null key and multiple Null values allowed
 *	Not synchronized
 *	Constant time performance O(1) for get, put & remove
 *
 *	HashMap uses the equals() method to compare keys
 *	Uses the hashCode() method to determine the bucket where a key-value pair should be stored
 *
 *	Hashing
 *		Uses a hash table for efficient storage and retrieval
 *		Keys are hashed to determine their location in the internal array
 *
 *	Time Complexity
 *		Best/Average Case: O(1)->hashing typically distributes keys uniformly across buckets
 *		Worst Case: O(log n)-> Occurs when all keys hash to the same bucket, 
 *						   resulting in a linked list or tree traversal
 *
 *	Default load factor is 0.75, map resizes/rehashing when 75% full
 *	Rehashing/Resize
 *		Whenever HashMap bucket increases its capacity, it rehashes itself
 *		All existing entries are rehashed
 *		Ensures efficiency of HashMap even if more data is added
 *
 *	containsKey -> O(1)
 *	containsValue -> O(n)
 *	size	-> O(1)
 */
public class HashMapDemo {

	public static void main(String[] args) {

		HashMap<Integer, String> names = new HashMap<>();
		
		names.put(35, "Hapheej");
		names.put(3, "Arham");
		names.put(1, "Fatima");
		names.put(55, "Shahad bee");
		
		System.out.println("Key 35: "+names.get(3));
		System.out.println("Null if key absent: "+names.get(200));
		
		System.out.println(names.containsKey(1));
		System.out.println(names.containsValue("Arham"));
		
		for(int k : names.keySet())
			System.out.print(names.get(k)+" ");
		
		System.out.println();
		
		for(String v : names.values())
			System.out.print(v+" ");
		
		System.out.println();
		
		//Entry Set
		
		for(Entry<Integer, String> name:names.entrySet())
			System.out.println("Key: "+name.getKey()+", Value: "+name.getValue());
		
		HashMap<Integer, Person> persons = new HashMap<>();
		persons.put(1, null);
		persons.put(1, new Person(1, "Arham", 480224));	//Value replaced not collision
		persons.put(1, new Person(2, "Fatima", 480224)); //Value replaced not collision
		
		System.out.println(persons);
		
		HashMap<Person, String> family = new HashMap<>();
		family.put(new Person(1, "Arham", 480224), "Son");
		//Same bucket bcz of id [collision], value different and get using equals
		family.put(new Person(1, "Fatima", 480224), "Daughter");
		
		System.out.println("Size with hash & equals: "+family.size());
		System.out.println(family);
		
		HashMap<Child, String> nickname = new HashMap<>();
		
		Child c1 = new Child("Arham"); //Hashcode is memory address by default so Different bucket
		Child c2 = new Child("Fatima");	// Different bucket
		//Different bucket since memory address different without hashcode & equals
		Child c3 = new Child("Arham");
		
		nickname.put(c1, "Elder");	//hashcode1 --> index1
		nickname.put(c2, "Daughter");	//hashcode2 --> index2
		nickname.put(c3, "Son");	//hashcode3 --> index3
		System.out.println("Size without hash & equals: "+nickname.size());
		System.out.println(nickname);
		
		HashMap<Child1, String> nickname1 = new HashMap<>();
		
		Child1 c11 = new Child1("Arham"); //Hashcode is calculated bucket1
		Child1 c12 = new Child1("Fatima");	// Different bucket2
		//Same bucket1 since hashcode & equals calculated
		Child1 c13 = new Child1("Arham");
		
		nickname1.put(c11, "Elder");	//hashcode1 --> index1
		nickname1.put(c12, "Daughter");	//hashcode2 --> index2
		nickname1.put(c13, "Son");	//hashcode1 --> index1
		System.out.println("Size with hash & equals: "+nickname1.size());
		System.out.println(nickname1);
		
		//Hashcode & Equals
		HashMap<Person, String> family1 = new HashMap<>();
		Person p1 = new Person(1, "Arham", 480224);
		Person p2 = new Person(1, "Fatima", 480224);
		Person p3 = new Person(1, "Arham", 480224);
		
		//Same bucket bcz of id [collision] values also replaced for P1 & P2
		family1.put(p1, "Son");
		family1.put(p2, "Daughter");
		family1.put(p3, "Kikki");
		
		System.out.println("P1: "+family1.get(p1));
		System.out.println("P3: "+family1.get(p3));
	}
}
