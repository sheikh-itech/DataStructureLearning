package ds.java8.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 *	We can only use one terminal operation per stream
 *
 *	The correct and most convenient way to use streams is by a stream pipeline,
 *	which is a chain of the stream source, intermediate operations, and a terminal operation
 *
 *	In most of examples of this class, we left the streams unconsumed 
 *	(we didn't apply the close() method or a terminal operation). 
 *	In a real app, don't leave an instantiated stream unconsumed, 
 *	as that will lead to memory leaks
 */

public class StreamExample {

	private static long counter;
	
	public static Stream<Widget> streamOf(List<Widget> list) {
		
	    return list == null || list.isEmpty() ? Stream.empty() : list.stream();
	}
	
	public static void main(String []args) {
		
		Stream<String> stringEmpty = Stream.empty();
		Stream<Integer> intEmpty = Stream.empty();
		System.out.println(stringEmpty);
		System.out.println(intEmpty);
		
		List<Widget> widgets = Data.getWidgets();
		Stream<Widget> widgetStream = streamOf(widgets);
		System.out.println(widgetStream);
		
		Collection<String> collection = Arrays.asList("a", "b", "c");
		Stream<String> streamOfCollection = collection.stream();
		System.out.println(streamOfCollection);
		
		//Stream of Array
		Stream<String> streamOfArray = Stream.of("a", "b", "c");
		
		String[] arr = new String[]{"a", "b", "c"};
		Stream<String> streamOfArrayFull = Arrays.stream(arr);
		//Stream from Part Of Array
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
		
		//Stream.builder()
		Stream<String> streamBuilder =
				  Stream.<String>builder().add("a").add("b").add("c").build();
		
		//Stream.generate()
		Stream<List<Widget>> streamGenerated =
				  Stream.generate(() -> widgets).limit(5);
		System.out.println(streamGenerated.count());
		
		//Stream.iterate()
		Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
		
		//Stream of Primitives
		IntStream intStream = IntStream.range(1, 3);
		LongStream longStream = LongStream.rangeClosed(1, 3);
		
		Random random = new Random();
		DoubleStream doubleStream = random.doubles(3);
		
		//Stream of String
		IntStream streamOfChars = "abc".chars();
		
		//1. Stream of String
		Stream<String> streamOfString =
				  Pattern.compile(", ").splitAsStream("a, b, c");
		
		//2. Referencing a Stream
		Stream<String> stream = 
				  Stream.of("a", "b", "c").filter(element -> element.contains("b"));
		Optional<String> anyElement = stream.findAny();
		
		Stream<Widget> widgetStreams = widgets.stream().filter(ele->ele.getColor()=="Red");
		
		Optional<Widget>wdgts = widgetStreams.findAny();//findAny is terminal method
		
		//IllegalStateException::stream has already been operated upon or closed
		//wdgts = widgetStreams.findFirst();
		
		//3. Referencing a Stream
	/**
	 * To perform a sequence of operations over the elements of the data source and 
	 * aggregate their results, we need three parts: the source, 
	 * intermediate operation(s) and a terminal operation.
	 * Intermediate operations return a new modified stream. 
	 * For example, to create a new stream of the existing one without few elements, 
	 * the skip() method should be used
	 */
		
		widgetStreams = widgets.stream().filter(ele->ele.getColor()=="Red").skip(2);
		
		List<Object> lst = widgetStreams.collect(Collectors.toList());
		System.out.println(lst);
		/** If we need more than one modification, we can chain intermediate operations */
		
		widgetStreams = widgets.stream().skip(2).filter(ele->ele.getColor()=="Red");
		lst = widgetStreams.collect(Collectors.toList());
		System.out.println(lst);
		
		Stream<Object> objStreams = widgets.stream().skip(2).map(m->m.getColor()=="Red");
		lst = objStreams.collect(Collectors.toList());
		System.out.println(lst);
		
		//4. Stream Pipeline
		Stream<String> onceModifiedStream =
				  Stream.of("abcd", "bbcd", "cbcd").skip(1);
		
		Stream<String> twiceModifiedStream =
				onceModifiedStream.map(element -> element.substring(0, 3));
		List<String> lst1 = twiceModifiedStream.collect(Collectors.toList());
		System.out.println(lst1);
		
		//We can only use one terminal operation per stream
		List<String> list = Arrays.asList("abc1", "abc2", "abc3");
		long size = list.stream().skip(1)
		  .map(element -> element.substring(0, 3)).sorted().count();
		
		//5. Lazy Invocation
	/** Intermediate operations are lazy. This means that they will be invoked only 
	 * if it is necessary for the terminal operation execution
	 */
		List<String> list1 = Arrays.asList("abc1", "abc2", "abc");
		counter = 0;
		Stream<String> stream1 = list1.stream().filter(element -> {
		    wasCalled();
		    return element.contains("2");
		});
		System.out.println("counter: "+counter);
		
/** As we have a source of three elements, we can assume that the filter() method 
 * will be called three times, and the value of the counter variable will be 3.
 * However, running this code doesn't change counter at all, it is still zero, 
 * so the filter() method wasn't even called once. 
 * The reason why is missing of the terminal operation
 */
		
		Optional<String> stream2 = list1.stream().filter(element -> {
		    System.out.println("filter() was called");
		    return element.contains("2");
		}).map(element -> {
			System.out.println("map() was called");
		    return element.toUpperCase();
		}).findFirst();
		
	/**	The resulting log shows that we called the filter() method twice and the map() 
	 * method once. This is because the pipeline executes vertically. 
	 * In our example, the first element of the stream didn't satisfy the filter's 
	 * predicate. Then we invoked the filter() method for the second element, 
	 * which passed the filter. Without calling the filter() for the third element, 
	 * we went down through the pipeline to the map() method.
	 * 
	 * The findFirst() operation satisfies by just one element. 
	 * So in this particular example, the lazy invocation allowed us to avoid two method
	 * calls, one for the filter() and one for the map()
	 */
		
		list1.stream().filter(element -> {
		    System.out.println("--filter() was called");
		    return element.contains("2");
		}).map(element -> {
			System.out.println("--map() was called");
		    return element.toUpperCase();
		}).count();
		
		
		//6. Order of Execution
	/** the right order is one of the most important aspects of chaining operations 
	 * in the stream pipeline */
		
		counter=0;
		size = list.stream().map(element -> {
		    wasCalled();
		    return element.substring(0, 3);
		}).skip(2).count();
		System.out.println("counter: "+counter);
		
/**	Execution of this code will increase the value of the counter by three. 
 * This means that we called the map() method of the stream three times, 
 * but the value of the size is one. So the resulting stream has just one element, 
 * and we executed the expensive map() operations for no reason two out of the three times
 */
		counter=0;
		size = list.stream().skip(2).map(element -> {
		    wasCalled();
		    return element.substring(0, 3);
		}).count();
		System.out.println("counter: "+counter);
		
/**This brings us to the following rule: intermediate operations which reduce the size 
 * of the stream should be placed before operations which are applying to each element. 
 * So we need to keep methods such as skip(), filter(), and distinct() at the top of 
 * our stream pipeline
 */
		
		//7. Stream Reduction
		
//7.1. The reduce() Method		
/**There are three variations of reduce() method, 
 * which differ by their signatures and returning types-
 * 
 * Identity– the initial value for an accumulator, or a default value if a stream is 
 * empty and there is nothing to accumulate
 * 
 * Accumulator– a function which specifies the logic of the aggregation of elements
 * As the accumulator creates a new value for every step of reducing, the quantity of 
 * new values equals the stream's size and only the last value is useful. 
 * This is not very good for the performance
 * 
 * Combiner– a function which aggregates the results of the accumulator
 */
		
		OptionalInt reduced =
				  IntStream.range(1, 4).reduce((a, b) -> a + b);
		
		System.out.println(reduced.getAsInt());
		
		//With initial value 10
		
		int reducedTwoParams =
				  IntStream.range(1, 4).reduce(10, (a, b) -> a + b);
		System.out.println(reducedTwoParams);
		
		int reducedParams = Stream.of(1, 2, 3)
				  .reduce(10, (a, b) -> a + b, (a, b) -> {
				     System.out.println("combiner was called");
				     return a + b;
				  });
		System.out.println(reducedParams);
		
	//combiner wasn't called. To make a combiner work, a stream should be parallel
		reducedParams = Arrays.asList(1, 2, 3).parallelStream()
			    .reduce(10, (a, b) -> a + b, (a, b) -> {
			    	System.out.println("combiner was called");
			       return a + b;
			    });
		System.out.println(reducedParams);
		
/**Here the reduction works by the following algorithm: 
 * The accumulator ran three times by adding every element of the stream to identity.
 * These actions are being done in parallel. As a result, they have 
 * (10 + 1 = 11; 10 + 2 = 12; 10 + 3 = 13;). Now combiner can merge these three results.
 * It needs two iterations for that (12 + 13 = 25; 25 + 11 = 36)
 */
		
		reducedParams = Arrays.asList(1, 2, 3).parallelStream()
			    .reduce(0, (a, b) -> a + b, (a, b) -> {
			    	System.out.println("--combiner was called");
			       return a + b;
			    });
		System.out.println(reducedParams);
		
		
		//7.2. The collect() Method
		
/**It accepts an argument of the type Collector, which specifies the mechanism of reduction
 * There are already created, predefined collectors for most common operations. 
 * They can be accessed with the help of the Collectors type.
 */
		
		List<Product> products = Data.getProducts();
		
		List<String> collectorCollection = 
				products.stream().map(Product::getName).collect(Collectors.toList());
		System.out.println(collectorCollection);
		
		//Reducing to String
		String listToString = products.stream().map(Product::getName)
				  .collect(Collectors.joining(", ", "[", "]"));
		System.out.println(listToString);
		
/** The joiner() method can have from one to three parameters (delimiter, prefix, suffix) */
		
		double averagePrice = products.stream()
				  .collect(Collectors.averagingInt(Product::getPrice));
		System.out.println("Average: "+averagePrice);
		
		int summingPrice = products.stream()
				  .collect(Collectors.summingInt(Product::getPrice));
		System.out.println("Sum of Price: "+summingPrice);
		
/**The methods averagingXX(), summingXX() and summarizingXX() can work with primitives 
 * (int, long, double) and with their wrapper classes (Integer, Long, Double). 
 * One more powerful feature of these methods is providing the mapping. 
 * As a result, the developer doesn't need to use an additional map() operation 
 * before the collect() method
 */
		
		//Collecting statistical information about stream’s elements
		
		IntSummaryStatistics statistics = products.stream()
				  .collect(Collectors.summarizingInt(Product::getPrice));
		System.out.println(statistics);
		
		
		/** Grouping of stream’s elements according to the specified function */
		
		Map<Integer, List<Product>> lists = products.stream()
				  .collect(Collectors.groupingBy(Product::getPrice));
		System.out.println(lists);
		
	//Dividing stream’s elements into groups according to some predicate
		Map<Boolean, List<Product>> mapPartioned = products.stream()
				  .collect(Collectors.partitioningBy(element -> element.getPrice() > 15));
		System.out.println(mapPartioned);
		
	//Collector converts stream to Set, and then create unchangeable Set out of it
		Set<Product> unmodifiableSet = products.stream()
				  .collect(Collectors.collectingAndThen(Collectors.toSet(),
				  Collections::unmodifiableSet));
		System.out.println(unmodifiableSet);
		
		//UnsupportedOperationException
		//unmodifiableSet.add(new Product(250, "Hunney"));
		
	/** Custom collector */
		
		Collector<Object, ?, LinkedList<Object>> toLinkedList =
				  Collector.of(LinkedList::new, LinkedList::add, 
				    (first, second) -> { 
				       first.addAll(second); 
				       return first; 
				    });

		LinkedList<Object> listProducts =
				  products.stream().collect(toLinkedList);
		System.out.println(listProducts);
		
	//8. Parallel Streams
		
/**Parallel mode can be achieved, When source of a stream is a Collection or an Array, 
 * it can be achieved with the help of the parallelStream() method
 */
		
		Stream<Product> parallelStreams = products.parallelStream();
		boolean isParallel = parallelStreams.isParallel();
		boolean bigPrice = parallelStreams
		  .map(product -> product.getPrice() * 12)
		  .anyMatch(price -> price > 200);
		
		System.out.println("bigPrice: "+bigPrice);
		System.out.println("isParallel: "+isParallel);
	
		
/**If the source of a stream is something other than a Collection or an array, 
 * the parallel() method should be used
 */
		IntStream intStreamParallel = IntStream.range(1, 150).parallel();
		isParallel = intStreamParallel.isParallel();
		
/**	Under the hood, Stream API automatically uses the ForkJoin framework 
 * 	to execute operations in parallel
 * 	When using streams in parallel mode, avoid blocking operations
 * 
 * If one task lasts much longer than the other, 
 * Parallel Stream can slow down the complete workflow
 */
		//Get back Sequential Stream
		
		IntStream intStreamSequential = intStreamParallel.sequential();
		isParallel = intStreamSequential.isParallel();
		System.out.println("Now isParallel: "+isParallel);
	}
	
	
	private static void wasCalled() {
	    counter++;
	}
}
