package core.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**	Added Functional Programming Feature in Java 8 [Minimal code, Functional Programming]
 * 	Java 8-> Streams, Lambda, Date & Time API
 * 
 * 	Streams-> Process Collection data in functional & declarative manner
 * 			  Simplify processing
 * 			  Improves readability, Maintenance & easy parallelism
 * 
 *	Steps=> Source -> Intermediate Operations -> Terminal Operations
 *
 *	Stream: Sequence of elements supports Functional & Declarative programming
 *
 *	Terminal Operations:  collect, count
 *
 *	Stateful Operations-> Where stream having knowledge about all elements
 *			   Like in sort, distinct, limit, skip, collect
 *			They depend on information about the entire stream or specific portions of it
 *
 *	Stateless Operations-> These operations process elements independently without knowing other element
 *				filter, map, flatMap, peek, forEach
 *			Perform element-by-element transformations
 */
public class EngineeringDigestStreamDemo {

	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(1, 5, 3, 4, 8, 6, 9, 10, 22);
		
		List<String> names = Arrays.asList("Fatima", "Arham", "Hapheej", "Bob");
		
// Filter		
		//No filtering at this point
		Stream<Integer> numStream = nums.stream().filter(num -> num%2==0);

// Collect		
		//After terminal operation filters actual results
		List<Integer> evenNums = numStream.collect(Collectors.toList());

// Map, Sorted & Distinct		
		Stream<String> upperCaseNames = names.stream().map(name -> name.toUpperCase()).sorted();
		
		Stream<String> upperCaseLengthSortedNames = names.stream().map(name -> name.toUpperCase())
				.sorted((x, y) -> x.length()-y.length()).distinct();

// Limit & Skip
		
		Stream.iterate(1, n -> n+1).skip(5).limit(50);

// Reduce	-> Reduces to single result like sum
		
		int sum = nums.stream().reduce((x, y) -> x+y).get();
		//Optional<Integer> sum = nums.stream().reduce(Integer::sum);
		
		System.out.println("Sum using reuce: "+sum);
		
// anyMatch, allMatch, noneMatch
		
		boolean result = nums.stream().anyMatch(num-> num%2==0);
		
		result = nums.stream().allMatch(num-> num>0);
		
		result = nums.stream().noneMatch(num-> num<0);
		
// findFirst, findAny-> Finds first result, Finds if any matching result from filter or map etc
		
		System.out.println(nums.stream().findFirst().get());
		System.out.println(nums.stream().findAny().get());
				
// Filtering & Collecting
		
		names.stream().filter(name->name.length()>3).collect(Collectors.toList());
	
// Square & Sort numbers
		
		nums.stream().map(num -> num*num).sorted((x, y)->x-y);
		
// Sum of Numbers
		
		sum = nums.stream().reduce(Integer::sum).get();
		
		// 0 is the identity value for addition
		sum = nums.stream().reduce(0, Integer::sum); // Accumulate sum
		
		sum = nums.stream().reduce((x, y) -> x+y).get();
		
		sum = nums.stream().mapToInt(Integer::intValue).sum();
		
		sum = nums.stream().collect(Collectors.summingInt(Integer::intValue));
		
// Character occurrence count
		
		"Hello world".chars().filter(ch -> ch=='l').count();
		
		System.out.println(evenNums);

		
//	peek	-> performs operation elements like Consume
		
		Stream.iterate(1, n->n+1).limit(20).peek(System.out::print).count();
		
		System.out.println();
		
// toArray	-> Convert stream to array
		
		Object[] arry = Stream.of(1, 2, 3, 4, 5).toArray();
		
		
// Min, Max
		
		System.out.println("Min: "+Stream.of(2, 6, 79, 52).min((x, y) -> x-y).get());
		System.out.println("Max: "+Stream.of(2, 6, 79, 52).max(Comparator.naturalOrder()).get());
		
		names.stream().filter(name->name.length()>2).collect(Collectors.minBy((x, y)->x.length()-y.length()));

// flatMap	-> Handles streams of Collection, List, Array those are nested
		
		List<List<String>> fruits = Arrays.asList(
				Arrays.asList("Apple", "Banana"),
				Arrays.asList("Papaya", "Graps"),
				Arrays.asList("Mango", "Kivi")
				);
		
		System.out.println(fruits.get(1).get(1));
		
		List<String> newFruits = fruits.stream().flatMap(lst -> lst.stream())
				.map(item -> item.toUpperCase()).collect(Collectors.toList());
		
		System.out.println(newFruits);
		
		List<String> sentence = Arrays.asList(
				"Hello world",
				"Java streams are powerful",
				"flatMap is useful"
				);
		
		List<String> words = sentence.stream()
				.flatMap(word-> Arrays.stream(word.split(" ")))
				.map(String::toUpperCase).collect(Collectors.toList());
		
		System.out.println(words);
		
		Stream<String> newWords = words.stream();
		newWords.forEach(System.out::print);

		// Stream already used in terminal operation forEach means closed [Cann't reuse Stream]
		//newWords.map(word -> word.toLowerCase()).toList();
		
		
		
		
// Lazy Operations [Intermediate Operations are Lazy]

		Stream<String> temp = names.stream().filter(name->{
			
			System.out.println("Filtering name: "+name);
			
			return name.length()>3;
		});
		
		System.out.println("Before terminal operation");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) { }
		
		List<String> finalNames = temp.collect(Collectors.toList());
		
		System.out.println("After terminal operation");
		
		System.out.println(finalNames);
	}
}
