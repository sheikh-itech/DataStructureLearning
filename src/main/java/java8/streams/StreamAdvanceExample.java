package java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *	We can only use one terminal operation per stream
 *	A stream should be operated only Once
 *
 *Streams are lazy:
 *Computation on the source data is only performed when the terminal operation is initiated
 *and source elements are consumed only as needed
 */

public class StreamAdvanceExample {

	
	public static void main(String []ar) {

		List<Widget> widgets = Data.getWidgets();
		List<Employee> emps = Data.getEmployees();
		
		int sum = widgets.stream().filter(f->f.getColor()=="Red").mapToInt(m->m.getWeight()).sum();
		System.out.println("Sum: "+sum);
		
		boolean flag = emps.stream().allMatch(p->p.getDept()=="Dev");
		System.out.println("All belongs to 'Dev': "+flag);
		
		flag = emps.stream().anyMatch(p->p.getDept()=="Dev");
		System.out.println("Any belongs to 'Dev': "+flag);
		
		//<R, A> R collect(Collector<? super T, A, R> collector);
		/** It takes Collectors for intermediate operations */
		
		List<String> namesLst = emps.stream().map(m->m.getName()).collect(Collectors.toList());
		System.out.println(namesLst);
		
		Set<String> nameSet = emps.stream().map(m->m.getName()).collect(Collectors.toSet());
		System.out.println(nameSet);
		
		//collect(Collector<? super T, A, R> collector)
		//collect(Supplier, BiConsumer, BiConsumer)
		/**	<R> the type of the result
		 * 	<A> the intermediate accumulation type of Collector
		 */
		Object names = emps.stream().collect(ArrayList::new, (x, y)->x.add(y.getName()), ArrayList::add);
		System.out.println(names);
		
		names = emps.stream().map(m->m.getName()).collect(ArrayList::new, (x, y)->x.add(y), ArrayList::add);
		System.out.println(names);
		
		//Stream Concat
		Stream<Object> stream1 = emps.stream().map(m->m.getName());
		Stream<Object> stream2 = emps.stream().map(m->m.getDesign());
				
		List<Object> names1 = Stream.concat(stream1, stream2).map(m->m).collect(Collectors.toList());
		System.out.println(names1);
		
		List<String> nameLst = emps.stream().flatMap(fm->Stream.of(fm.getName(), fm.getDept())).collect(Collectors.toList());
		System.out.println(nameLst);
		
		//Group By Multiple Fields
		Map<String, List<Employee>> fieldMap = emps.stream().collect(Collectors.groupingBy(Employee::getName));
		System.out.println(fieldMap);
		
		Map<Employee, Object>fieldMap1 = emps.stream().collect(Collectors.toMap(Function.identity(), v->v));
		System.out.println(fieldMap1);
		
		//Distinct Elements, call hashCode & equals() methods
		List<Employee> empLst = emps.stream().distinct().collect(Collectors.toList());
		System.out.println(empLst);
		
		//Flat Map  
		List<List<Integer>> listOfLists = 
				Arrays.asList(Arrays.asList(4,5,6), Arrays.asList(1,2,3), Arrays.asList(7,8,9));
		List<Integer> listNums = listOfLists.stream().flatMap(m->m.stream()).collect(Collectors.toList());
		System.out.println(listNums);
		
		String[][] dataArray = new String[][]{{"a"}, {"c", "d"}, {"e", "f"}, {"g", "h"}};
	         
		List<String> listOfAllChars = Arrays.stream(dataArray)
	              .flatMap(x -> Arrays.stream(x)).collect(Collectors.toList());
		System.out.println(listOfAllChars);
		
		//FlatMap-ToInt
		Object tempNums = listOfLists.stream().flatMapToInt(m->m.stream().mapToInt(i->i)).collect(ArrayList::new, (a, b)->a.add(b), ArrayList::add);
		System.out.println(tempNums);
		
		System.out.println("\nOrdered using Sorted mtd");
		List<String> list = Arrays.asList("5", "3", "1", "4", "2");
		list.stream().sorted().flatMapToInt(m->IntStream.of(Integer.parseInt(m))).forEach(action->System.out.print(action+", "));
		System.out.println();
		
		System.out.println("Ordered for Each");
		list.stream().flatMapToInt(m->IntStream.of(Integer.parseInt(m))).forEachOrdered(action->System.out.print(action+", "));
		System.out.println();
		
		//Peek Method
		/**	Purpose of peek() method is to support debugging */
		
		Stream.of("one", "two", "three", "four")
		  .filter(e -> e.length() > 3)
		  .peek(e -> System.out.println("Filtered value: "+e))
		  .map(String::toUpperCase)
		  .peek(e -> System.out.println("Mapped value: " + e)).count();
		
		
	//Filtering Map
		List<Employee> maps = fieldMap1.entrySet().stream().filter(p->p.getKey().getName()=="Sheikh").map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println(maps);
		
		List<Object> maps1 = fieldMap1.entrySet().stream().filter(p->p.getKey().getName()=="Sheikh").map(Map.Entry::getValue).collect(Collectors.toList());
		System.out.println(maps1);
		
	//Stream Reduce()
		Optional<String> singleString = emps.stream().map(m->m.getName()).reduce((x, y)->x+", "+y);
  		System.out.println(singleString);
  		
  		String bigString = emps.stream().map(m->m.getName()).reduce("Elements->",(x, y)->x+" "+y+", ");
  		System.out.println(bigString);
  		
  		bigString = emps.parallelStream().map(m->m.getName()).reduce("E->",(x, y)->x+y+" ");
  		System.out.println(bigString);
  		
  		List<Integer> array = Arrays.asList(-2, 0, 4, 6, 8);
  		sum = array.stream().reduce(0, (x, y)->x+y);
  		System.out.println("Reduced sum: "+sum);
  		
	/**	OptionalInt-> container object which may or may not contain an int value.
	 * 	If a value is present, isPresent() returns true. 
	 * If no value is present, the object is considered empty and isPresent() returns false
	 */
  		OptionalInt mult = IntStream.range(1,  8).reduce((x, y)->x*y);
  		System.out.println("Reduced Ints Multiple: "+mult.getAsInt());
  		
  		
  		List<String> vowels = List.of("a", "e", "i", "o", "u");
		//Sequential stream - nothing to combine
		StringBuilder result = vowels.stream().collect(StringBuilder::new, (x, y) -> x.append(y),
				(a, b) -> a.append(",").append(b));
		System.out.println(result.toString());

		//Parallel stream - combiner is combining partial results
		result = vowels.parallelStream().collect(StringBuilder::new, (x, y) -> x.append(y),
				(a, b) -> a.append(",").append(b));
		System.out.println(result.toString());
		
		
	}
}
