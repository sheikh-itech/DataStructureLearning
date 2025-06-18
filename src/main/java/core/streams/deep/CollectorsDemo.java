package core.streams.deep;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class CollectorsDemo {

	static List<Integer> nums = Arrays.asList(5, 3, 4, 8, 7, 9, 6);
	static List<String> names = Arrays.asList("Arham", "Fatima", "Hapheej", "Alice", "Abcdef", "Bcdsfrd");
	static List<String> sentences = Arrays.asList("hi there", "hello world");
	
	static List<Person> people = Arrays.asList(
		    new Person("Arham", "Narsinghpur", 2200, Arrays.asList("Reading", "Cricket")),
		    new Person("Fatime", "Narsinghpur", 2300, Arrays.asList("Swimming", "Chess")),
		    new Person("Hapheej", "Harrai", 1800, Arrays.asList("Reading", "Football"))
		);
	
	public static void main(String[] args) {

//Core Collectors Methods
		
		List<Integer> n = nums.stream().collect(Collectors.toList());
		n.add(1);
		System.out.println(n);
		
		nums.stream().collect(Collectors.toUnmodifiableList());
		
		nums.stream().collect(Collectors.toSet());
		nums.stream().collect(Collectors.toUnmodifiableSet());
		
		nums.stream().collect(Collectors.toMap(k->k, v->v));
		nums.stream().collect(Collectors.toUnmodifiableMap(k->k, v->v));
		nums.stream().collect(Collectors.toConcurrentMap(k->k, v->v));
		
		
		nums.stream().collect(Collectors.toCollection(LinkedList::new));
		
// Map Collectors
		
		/*	toMap(Function keyMapper, Function valueMapper)
		 *  Collects into a Map using key and value mapper, 
		 *  Throws exception on duplicate keys */
		
		Map<String, String> res1 = names.stream().collect(Collectors.toMap(k->k, v->v));
		System.out.println(res1);
		
		
		/* toMap(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction)
		 * handles duplicate keys with merge function */
		
		Map<Integer, String> res2 = names.stream()
				.collect(Collectors.toMap(
						String::length, 
						val-> val,
						(v1, v2)-> v1+", "+v2
				));
		System.out.println(res2);
		
		/* toMap(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction, 
		 * Supplier mapSupplier) 
		 * Full control over key, value, merge function, and Map-Type */
		
		res2 = names.stream().collect(Collectors.toMap(
						String::length, 
						val-> val,
						(v1, v2)-> v1+", "+v2,
						LinkedHashMap::new
				));
		System.out.println(res2);
		
		/* toUnmodifiableMap(Function keyMapper, Function valueMapper) 
		 * Returns an unmodifiable map. Throws on duplicate keys */
		
		res1 = names.stream().collect(Collectors.toUnmodifiableMap(k->k, v->v));
		System.out.println(res1);
		
		/* toUnmodifiableMap(Function keyMapper, Function valueMapper, 
		 * BinaryOperator mergeFunction) 
		 * Handles duplicates and produces an unmodifiable map */
		
		res2 = names.stream()
				.collect(Collectors.toUnmodifiableMap(
						String::length, 
						val-> val,
						(v1, v2)-> v1+", "+v2
				));
		System.out.println(res2);
		
		
// String Collectors
		
		/* joining()- Concatenates elements into a single String */
		
		String single = names.stream().collect(Collectors.joining());
		System.out.println(single);
		
		
		/* joining(CharSequence delimiter)- Concatenates with a delimiter */
		
		single = names.stream().collect(Collectors.joining(", "));
		System.out.println(single);
		
		
		/* joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix)
		 * Concatenates with delimiter, prefix, and suffix */
		
		single = names.stream().collect(Collectors.joining(", ", "[", "]"));
		System.out.println(single);
		
		
// Grouping
		
		/* groupingBy(Function classifier)- Groups elements by classifier function into Map 
		 * default downstream is Collectors.toList() */
		
		Map<Integer, List<String>> res3 = names.stream()
				.collect(Collectors.groupingBy(String::length));
		System.out.println(res3);
		
		
		/* groupingBy(Function classifier, Collector downstream)
		 * Allows downstream collector (e.g., counting, mapping) */
		
		Map<Integer, Long> res4 = names.stream()
				.collect(Collectors.groupingBy(String::length, Collectors.counting()));
		System.out.println(res4);
		
		
		/* groupingBy(Function classifier, Supplier mapFactory, Collector downstream)
		 * Full control over map type and downstream collector */
		
		Map<Object, List<String>> res5 = names.stream()
				.collect(Collectors.groupingBy(
					k->k.charAt(0),		// classifier
					LinkedHashMap::new, // mapFactory
					Collectors.toList() // downstream
				));
		System.out.println(res5);
		
		
		/* groupingByConcurrent(Function classifier) 
		 * Like groupingBy, but supports concurrent grouping */
		
		res3 = names.stream()
				.collect(Collectors.groupingByConcurrent(String::length));
		System.out.println(res3);
		
		
		/* groupingByConcurrent(Function classifier, Collector downstream) */
		
		res4 = names.stream()
				.collect(Collectors.groupingByConcurrent(String::length, Collectors.counting()));
		System.out.println(res4);
		
		/* groupingByConcurrent(Function classifier, Supplier mapFactory, Collector downstream) */
		
		res5 = names.stream()
				.collect(Collectors.groupingByConcurrent(
					k->k.charAt(0),		// classifier
					ConcurrentHashMap::new, // mapFactory
					Collectors.toList() // downstream
				));
		System.out.println(res5);
		
// Partitioning- Group into true/false
		
		/* partitioningBy(Predicate predicate)- Partitions stream into a Map<Boolean, List<T>> */
		
		Map<Boolean, List<String>> res6 = names.stream().collect(
				Collectors.partitioningBy(val-> val.toLowerCase().matches(".*[aeiou].*")));
		System.out.println(res6);
		
		
		/* partitioningBy(Predicate predicate, Collector downstream) 
		 * Partitioning with downstream collector */
		
		res6 = names.stream()
			    .collect(Collectors.partitioningBy(
			            name -> name.length() > 5,
			            Collectors.toList()
			        ));
		System.out.println(res6);
		
		res6 = names.stream()
			    .collect(Collectors.partitioningBy(
			            name -> name.length() > 5,
			            Collectors.mapping(String::toUpperCase, Collectors.toList())
			        ));
		System.out.println(res6);
		
		
// Reduction Collectors
		
		/* counting()- Counts the number of elements */
		
		long count = nums.stream().collect(Collectors.counting());
		System.out.println("counting: "+count);
		
		/* reducing(BinaryOperator<T> op)-	Reduces with binary operator */
		
		int red1 = nums.stream().collect(Collectors.reducing((x, y)-> x+y)).get();
		         //nums.stream().collect(Collectors.reducing(Integer::sum)).get();
		System.out.println("reducing: "+red1);
		
		/* reducing(T identity, BinaryOperator<T> op)- Reduces with identity and binary operator
		 * identity– the initial/default value */
		
		red1 = nums.stream().collect(Collectors.reducing(0, Integer::sum)); //(0, (x, y)-> x+y)
		System.out.println("reducing: "+red1);
		
		/* reducing(U identity, Function<T, U> mapper, BinaryOperator<U> op),
		 * identity– the initial/default value 
		 * mapper– converts elements of the stream into the type being reduced
		 * op– reduces mapped values using a binary operation */
		
		red1 = names.stream().collect(Collectors.reducing(
					0,					// identity
					String::length,		// mapper: maps String to Integer (its length)
					Integer::sum		// reducer: sums up the lengths
				));
		System.out.println("reducing: "+red1);
		
		long red2 = nums.stream().collect(Collectors.reducing(
					1L,					// identity
					x -> (long) x*x,	// square each number
					(x, y) -> x*y		// multiply all
				));
		System.out.println("reducing(square each, mult all): "+red2);
		
		Map<Character, Optional<String>> longestPerInitial = names.stream()
		    .collect(Collectors.groupingBy(
		        name -> name.charAt(0), 	// group by first letter
		        Collectors.reducing((s1, s2) -> s1.length() >= s2.length() ? s1 : s2)
		    ));

		System.out.println("longestPerInitial\n-------------------");
		System.out.println(longestPerInitial);
		
		
		/* minBy(Comparator comparator)-	Finds the minimum element using comparator */
		
		int min = nums.stream().collect(Collectors.minBy((x, y)-> x-y)).get();
		System.out.println("minBy: "+min);
		
		min = nums.stream().collect(Collectors.minBy(Integer::compareTo)).get();
		System.out.println("minBy: "+min);
		
		/* maxBy(Comparator comparator)-	Finds the maximum element using comparator */
		
		min = nums.stream().collect(Collectors.maxBy(Integer::compareTo)).get();
		System.out.println("maxBy: "+min);
		
		String max = names.stream()
				.collect(Collectors.maxBy(Comparator.comparingInt(String::length))).get();
		System.out.println("maxBy: "+max);
		
		
		/* summingInt(ToIntFunction mapper)-	Sums int values */
		
		long res7 = nums.stream().collect(Collectors.summingInt(num -> num));
		System.out.println("summingInt: "+res7);
		
		/* summingLong(ToLongFunction mapper)-	Sums long values */
		
		res7 = nums.stream().collect(Collectors.summingLong(num -> num));
		System.out.println("summingLong: "+res7);
		
		/* summingDouble(ToDoubleFunction mapper)-	Sums double values */
		
		double res8 = nums.stream().collect(Collectors.summingDouble(num -> num));
		System.out.println("summingDouble: "+res8);
		
		/* averagingInt(ToIntFunction mapper)-	Averages int values */
		
		res8 = nums.stream().collect(Collectors.averagingInt(num -> num));
		System.out.println("averagingInt: "+res8);
		
		/* averagingLong(ToLongFunction mapper)-	Averages long values */
		
		res8 = nums.stream().collect(Collectors.averagingLong(num -> num));
		System.out.println("averagingLong: "+res8);
		
		/* averagingDouble(ToDoubleFunction mapper)-	Averages double values */
		
		res8 = nums.stream().collect(Collectors.averagingDouble(num -> num));
		System.out.println("averagingDouble: "+res8);
		
		
		/* summarizingInt(ToIntFunction<? super T> mapper)- summary statistics for int 
		 * summarizingLong(ToLongFunction<? super T> mapper)- summary statistics for long
		 * summarizingDouble(ToDoubleFunction<? super T> mapper)- summary statistics for double */
		
		IntSummaryStatistics res9 = nums.stream().collect(Collectors.summarizingInt(num -> num));
		System.out.println("getAverage: "+res9.getAverage());
		System.out.println("getCount: "+res9.getCount());
		System.out.println("getMax: "+res9.getMax());
		System.out.println("getMin: "+res9.getMin());
		System.out.println("getSum: "+res9.getSum());
		
		/* Records a new value into the summary information */
		res9.accept(12);
		System.out.println("getMax: "+res9.getMax());
		
		LongSummaryStatistics res10 = nums.stream().collect(Collectors.summarizingLong(num->num));
		
		System.out.println("getCount: "+res10.getCount());
		
		LongSummaryStatistics res11 = nums.stream().collect(Collectors.summarizingLong(num->num));
		
		res10.combine(res11);
		System.out.println("getCount: "+res10.getCount());
		
		res10.andThen(res9);
		System.out.println("getCount: "+res10.getCount());
		
		DoubleSummaryStatistics res12 = nums.stream().collect(Collectors.summarizingDouble(n1->n1));
		
		System.out.println("getMax: "+res12.getMax());
	
		
// Transformation Collectors
		
		/* mapping(Function mapper, Collector downstream)- 
		 * Applies a function and then collects the result
		 * mapper – transforms each stream element
		 * Use Collectors.mapping() Inside-> groupingBy, partitioningBy, directly in .collect() */
		
		List<String> result = names.stream()
				.collect(Collectors.mapping(
						String::toUpperCase,	// mapper
						Collectors.toList()		// downstream collector
				));
		
		System.out.println(result);
		
		Map<Integer, List<String>> grouped = names.stream()
				.collect(Collectors.groupingBy(
						
						String::length,					// classifier
						
						Collectors.mapping(
								String::toUpperCase,	// mapper
								Collectors.toList()		// downstream collector
						)));
		System.out.println(grouped);
		
		Map<Integer, Set<Character>> charSet = names.stream()
			    .collect(Collectors.groupingBy(
			    		
			        String::length,
			        
			        Collectors.mapping(
			        		name -> name.charAt(0),
			        		Collectors.toSet()
			     )));

		System.out.println(charSet);
		
		
		/* flatMapping(Function mapper, Collector downstream)-
		 * Flattens and maps elements before collecting
		 * flatMapping() is like mapping(), but it flattens stream of collections or 
		 * streams into a single stream before collecting */
		
		Map<String, Set<String>> hobbiesByCity = people.stream()
			    .collect(Collectors.groupingBy(
			        p -> p.getCity(),
			        Collectors.flatMapping(
			            p -> p.getHobbies().stream(),     // flatten each person's hobbies
			            Collectors.toSet()               // collect as Set
			        )
			    ));
		/* If we used mapping() here, we’d get a Set<Set<String>>, not a flattened Set<String> */
		System.out.println(hobbiesByCity);
		
		
		List<String> words = sentences.stream()
			    .collect(Collectors.flatMapping(
			        sentence -> Arrays.stream(sentence.split(" ")),  // split into words
			        Collectors.toList()
			    ));
		System.out.println(words);
		
		// Above is Equivalent to:
		
		sentences.stream().flatMap(s -> Arrays.stream(s.split(" "))).collect(Collectors.toList());
		
		
		/* filtering(Predicate predicate, Collector downstream)-
		 * Filters elements before collecting
		 * Use filtering() inside- groupingBy, partitioningBy */
		
		Map<Integer, List<String>> nameByLength = names.stream().collect(Collectors.groupingBy(
				
					String::length,
					Collectors.filtering(
							name-> name.startsWith("A"), // filtering condition
							Collectors.toList()			 // collect as list
					)
				));
		System.out.println(nameByLength);
		
		// Group numbers by even/odd, number > 0
		Map<String, List<Integer>> evenOdds = nums.stream().collect(Collectors.groupingBy(
				
					num -> num%2==0 ? "Even" : "Odd",
					Collectors.filtering(
							num -> num>0,
							Collectors.toList()
					)
				));
		System.out.println(evenOdds);
		
		// Group people by city having salary> 2k
		
		Map<String, List<Person>> groupByCity = people.stream()
				.collect(Collectors.groupingBy(
					p-> p.getCity(),
					
					Collectors.filtering(
						p-> p.getSalary() > 2000,
						Collectors.toList()
					)
				));
		System.out.println(groupByCity);
		
		
		/* collectingAndThen(Collector downstream, Function finisher)-
		 * Finishes the collection with a final transformation
		 * finisher: a function that transforms the result (R → RR) */
		
		List<String> unmodifiable = names.stream()
			    .collect(Collectors.collectingAndThen(
			        Collectors.toList(),
			        Collections::unmodifiableList
			    ));
		System.out.println(unmodifiable);
		
		String first = names.stream()
			    .collect(Collectors.collectingAndThen(
			        Collectors.minBy(String::compareTo),
			        opt -> opt.orElse("NoName")
			    ));

		System.out.println(first);
		
		String countAsString = names.stream()
			    .collect(Collectors.collectingAndThen(
			        Collectors.counting(),
			        c -> "Total names: " + c
			    ));

		System.out.println(countAsString);
		
		Map<Integer, List<String>> group = names.stream()
			    .collect(Collectors.groupingBy(
			        String::length,
			        Collectors.collectingAndThen(
			            Collectors.toList(),
			            // keep first element per group
			            list -> list.subList(0, Math.min(1, list.size()))
			        )
			    ));

			System.out.println(group);
	}
}
