package core.streams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class EngineeringDigestCollectorsDemo {

	public static void main(String[] args) {

		List<Integer> nums = Arrays.asList(5, 3, 4, 6, 8, 7, 9, 5, 4, 6);
		
		List<String> names = Arrays.asList("Arham", "Fatima", "Hapheej", "Alice", "Abcdef");
		
		
		//Collect to List
		nums.stream().collect(Collectors.toList());
		
		//Collect to Set
		nums.stream().collect(Collectors.toSet());
		
		//Collect to Any Collection
		nums.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));
		
		// Join String
		names.stream().collect(Collectors.joining());
		
		System.out.println(names.stream().collect(Collectors.joining(", ")));
		
// Data summarizing, Generate statistic summary-> min, max, count, average, sum

		IntSummaryStatistics statistic = nums.stream()
				.collect(Collectors.summarizingInt(x->x));
		
		System.out.println(statistic.getAverage());
		System.out.println(statistic.getSum());
		System.out.println(statistic.getMax());
		
		// Direct average
		nums.stream().collect(Collectors.averagingInt(x->x));
		
		// Count elements
		nums.stream().collect(Collectors.counting());
		
		// Grouping elements
		
		// Group-1
		Map<Integer, List<String>> group1 = names.stream()
				.collect(Collectors.groupingBy(x->x.length()));
		//Map<Object, List<String>> group1 = names.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(group1);
		
		// Group-2
		Map<Integer, String> group2 = names.stream()
				.collect(Collectors.groupingBy(String::length, Collectors.joining(", ")));
		System.out.println(group2);
		
		// Group-3
		Map<Integer, Long> group3 = names.stream()
				.collect(Collectors.groupingBy(String::length, Collectors.counting()));
		System.out.println(group3);
		
		// Group-4, group to TreeMap
		Map<Integer, Long> group4 = names.stream()
				.collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
		System.out.println(group4);
		
		
// Partitioning Elements -> Partitions elements into 2 groups
		
		Map<Boolean, List<String>> group5 = names.stream()
				.collect(Collectors.partitioningBy(x->x.length()>5));
		System.out.println(group5);
		
		
// Mapping & Collecting -> map/ first then collects
		
		List<Object> group6 = names.stream()
				.collect(Collectors.mapping(x->x.toUpperCase(), Collectors.toList()));
		System.out.println(group6);
		
// Count word occurrence
		
		String word = "Hello world Hello java world";
		
		Map<Integer, Long> wordCount = Arrays.stream(word.split(" "))
				.collect(Collectors.groupingBy(String::length, Collectors.counting()));
		
		System.out.println(wordCount);
		
// Even odd numbers partition
		
		Map<Boolean, List<Integer>> numPartitions = nums.stream()
				.collect(Collectors.partitioningBy(num->num%2==0));
		System.out.println(numPartitions);
		
// Summing value in Map
		
		Map<String, Integer> fruits = new HashMap<>();
		fruits.put("Apple", 30); fruits.put("Banana", 70); fruits.put("Mango", 50);
		
		long totalFruit = fruits.values().stream().reduce(Integer::sum).get();
		System.out.println(totalFruit);
		
		totalFruit = fruits.values().stream()
				.collect(Collectors.summarizingInt(x -> x)).getSum();
		System.out.println(totalFruit);
		
// Map, Set from stream of elements
		
		List<String> fruit = Arrays.asList("Apple", "Banana", "Papaya", "Graps");
		
		Map<String, Integer> fruitMap = fruit.stream()
				.collect(Collectors.toMap(x->x.toUpperCase(), x->x.length()));
		System.out.println(fruitMap);
		
		fruit = Arrays.asList("Apple", "Banana", "Apple", "Graps");
		
		// v -> 1 => first element for first time
		// (x, y)->x+y => merge function call that increases count
		Map<Object, Integer> fruitMapCount = fruit.stream()
				.collect(Collectors.toMap(k -> k, v -> 1, (x, y)-> x+y));
		
		System.out.println(fruitMapCount);
	}
}
