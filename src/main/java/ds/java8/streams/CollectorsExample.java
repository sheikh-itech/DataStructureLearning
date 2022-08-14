package ds.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**	Implementations of Collector that implement various useful reduction operations, 
 * 	such as accumulating elements into collections, 
 * 	summarizing elements according to various criteria
 * 
 * Key mapper– mapping function to produce keys
 * Value mapper– mapping function to produce values
 * Merge Function– this is used to resolve collisions between values associated with the same key
 * Supplier – function which returns a new, empty Map into which the results will be inserted
 */

public class CollectorsExample {

	public static void main(String[] args) {

		List<Employee> emps = Data.getEmployees();
		List<Integer> nums = Data.getIntList(25);
		
		Map<String, List<String>> twoFieldMapsDuplicate = emps.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println(twoFieldMapsDuplicate);
		
		
		//Collectors averagingXX
		
		Double avgInt = emps.stream().collect(Collectors.averagingInt(Employee::getId));
		System.out.println("Averaging Int: "+avgInt);
		
		avgInt = emps.stream().collect(Collectors.averagingLong(Employee::getId));
		System.out.println("Averaging Long: "+avgInt);
		
		avgInt = emps.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println("Averaging Double: "+avgInt);
		
		//Collectors collectingAndThen (Collector<T,A,R> downstream, Function<R,RR> finisher)
		
		Set<String> unmodifiable = emps.stream().map(Employee::getName).collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::<String> unmodifiableSet));
		//unmodifiable.add("anything");		UnsupportedOperationException
		System.out.println(unmodifiable);
		
		String [][] arg = new String[][] {{ "1", "Geeks" }, { "2", "For" }, { "3", "Geeks" }};
		
		Map<String, String> fixedMap = Stream.of(arg).collect(Collectors.collectingAndThen(Collectors.toMap(ele->ele[0], ele->ele[1]), Collections::<String, String>unmodifiableMap));
		System.out.println(fixedMap);
		
		//Counting
		Long count = emps.stream().collect(Collectors.counting());
		System.out.println("Element Count: "+count);
		
	//Grouping By Terminal
		
		//Grouping-1
		//groupingBy(Function<? super T, ? extends K> classifier)
		
		Map<String, List<Employee>> groupObject = emps.stream().collect(Collectors.groupingBy(c->c.getDesign()));
		System.out.println(groupObject);
		
		//Grouping-2
		//groupingBy(Function<? super T, ? extends K> classifier, Collector<? super T, A, D> downstream)
		
		Map<String, Long> groupObject1 = emps.stream().collect(Collectors.groupingBy(Employee::getName, Collectors.counting()));
		System.out.println(groupObject1);
		
		Map<String, List<Object>> groupObject2 = emps.stream().collect(Collectors.groupingBy(Employee::getName, Collectors.mapping(m->m.getDesign(), Collectors.toList())));
		System.out.println(groupObject2);
		
		//Grouping-3
//groupingBy(Function<? super T, ? extends K> classifier, Supplier<M> mapFactory, Collector<? super T, A, D> downstream)
//groupingBy(Function.classifier, Supplier.mapFactory, Collectors.downstream)
		
		Map<String, List<Integer>> groupObject3 = emps.stream().collect(Collectors.groupingBy(Employee::getName, HashMap::new, Collectors.mapping(Employee::getId, Collectors.toList())));
		System.out.println(groupObject3);
		
		
		//Grouping By Concurrent
		
		//groupingByConcurrent(Function<? super T,? extends K> classifier)
		
		ConcurrentMap<String, List<Employee>> namewiseEmps = emps.parallelStream().collect(Collectors.groupingByConcurrent(Employee::getName));
		namewiseEmps.put("temp", emps);
		System.out.println(namewiseEmps);
		namewiseEmps = emps.stream().collect(Collectors.groupingByConcurrent(Employee::getName));
		
		//groupingByConcurrent(Function classifier,Collectors downstream)
		ConcurrentMap<String, Double> namewiseSalSum = emps.parallelStream().collect(Collectors.groupingByConcurrent(Employee::getDept, Collectors.averagingDouble(m->m.getSalary())));
		namewiseSalSum = emps.parallelStream().collect(Collectors.groupingByConcurrent(emp->emp.getDept(), Collectors.averagingDouble(m->m.getSalary())));
		System.out.println(namewiseSalSum);
		
//groupingByConcurrent(Function classifier, Supplier<M> mapFactory, Collectors downstream)
		ConcurrentMap<String, Long> deptWiseCount = emps.parallelStream().collect(Collectors.groupingByConcurrent(Employee::getDept, ConcurrentHashMap::new, Collectors.counting()));
		System.out.println(deptWiseCount);
		
	//Joining Operation
		String namesJoined = emps.stream().map(m->m.getName()).collect(Collectors.joining());
		System.out.println(namesJoined);
		
	//Joining(Delimiter) Operation
		namesJoined = emps.stream().map(m->m.getName()).collect(Collectors.joining(", "));
		System.out.println(namesJoined);
		
	//Joining(Delimiter, Prefix, Suffix) Operation
		namesJoined = emps.stream().map(m->m.getName()).collect(Collectors.joining(", ", "{", "}"));
		System.out.println(namesJoined);
		
		Double avgSalary = emps.stream().collect(Collectors.mapping(Employee::getSalary, Collectors.averagingDouble(m->m)));
		System.out.println(avgSalary);
		
		
		String value = Stream.of("a", "b", "c").collect(Collectors.joining());
		System.out.println(value);
		
		value = Stream.of("a", "b", "c").collect(Collectors.joining(","));
		System.out.println(value);
		value = Stream.of("a", "b", "c").collect(Collectors.joining(",", "{", "}"));
		System.out.println(value);
		
		value = Stream.of("1", new StringBuffer("2"), new StringBuilder("3")).collect(Collectors.joining());
		System.out.println(value);
		
		
	//Mapping Operation
		Set<String> departmentwiseEmps = emps.stream().collect(Collectors.mapping(Employee::getDept, Collectors.toSet()));
		System.out.println(departmentwiseEmps);
		
		Map<String, List<String>>mappingDept = emps.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println(mappingDept);
		
		Map<String, List<Employee>>mappingEmp = emps.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.mapping(Function.identity(), Collectors.toList())));
		System.out.println(mappingEmp);
		
	//maxBy Operation
		Optional<Employee> maxBy = emps.stream().collect(Collectors.maxBy(Comparator.comparing(key->key.getSalary())));
		System.out.println(maxBy);
		
		maxBy = emps.stream().collect(Collectors.maxBy(Comparator.comparing(key->key.getDept())));
		System.out.println(maxBy);
		
		List<String> num = new ArrayList<>();
		num.add("8");num.add("6");num.add("7");
		num.add("2");num.add("31");num.add("19");
				
		Optional<String> ints = num.stream().collect(Collectors.maxBy(Comparator.comparingInt(key->key.hashCode())));
		System.out.println(ints);
		
	//minBy Operation
		Optional<Employee> minBy = emps.stream().collect(Collectors.minBy(Comparator.comparing(key->key.getSalary())));
		System.out.println(minBy);
		
		ints = num.stream().collect(Collectors.minBy(Comparator.comparingInt(key->key.hashCode())));
		System.out.println(ints);
		
	//partitioningBy Operation
		
		//partitioningBy(Predicate<? super T> predicate)
		
		Map<Boolean, List<Integer>> numParts = nums.stream().collect(Collectors.partitioningBy(p->p>5));
		System.out.println(numParts);
		
		Map<Boolean, List<Employee>> empParts = emps.stream().collect(Collectors.partitioningBy(p->p.getSalary()>25.0));
		System.out.println(empParts);
		
	//partitioningBy(Predicate<? super T> predicate, Collector<? super T, A, D> downstream)
		Map<Boolean, Set<Integer>> numPart = nums.stream().collect(Collectors.partitioningBy(p->p>5, Collectors.toSet()));
		System.out.println(numPart);
		
	//Reduce Operation
		
		//reducing(BinaryOperator<T> op)
		
		Optional<Employee> empLst = emps.stream().collect(Collectors.reducing((x, y)->{
			return (x.getDept()=="Dev")?x:y;
		}));
		System.out.println(empLst);
		
		Map<String, Optional<Employee>> deptEmpLsts = emps.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));
		System.out.println(deptEmpLsts);
		
		Stream<Integer> s = Stream.of(5, 10, 20, 50);
        Integer nm = s.collect(Collectors.reducing((integer, integer2)
                      -> {
                    	  return integer2 - integer;
                    	  })).orElse(-1);
        System.out.println(nm);
		
        //reducing(T identity, BinaryOperator<T> op)
        
        Employee e = new Employee(0, "temp", "temp", "temp", 0.0f, "temp");
        Map<String, Employee> deptEmp = emps.stream().collect(Collectors.groupingBy(Employee::getDept, 
        		Collectors.reducing(e, BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));
		System.out.println(deptEmp);
		
//reducing(U identity, Function<? super T, ? extends U> mapper, BinaryOperator<U> op)
		Map<String, ? extends Number> deptwiseMaxSal = emps.stream().collect(Collectors.groupingBy(Employee::getDept, 
				Collectors.reducing(0.0, Employee::getSalary, BinaryOperator.maxBy(Comparator.comparingDouble(k->Double.parseDouble(k.toString()))))));
		System.out.println(deptwiseMaxSal);
		
//Summarizing Operation
		
		/**	summarizingInt() is a static method of the Collectors class that is used to 
		 * return the summary statistics of the results obtained from applying the passed 
		 * ToIntFunction implementation to a set of input elements
		 */
		
		//summarizingInt(ToIntFunction<? super T> mapper)
		IntSummaryStatistics summingSalInt = emps.stream().collect(Collectors.summarizingInt(m->(int)m.getSalary()));
		System.out.println(summingSalInt);
		
		//summarizingDouble(ToDoubleFunction<? super T> mapper)
		DoubleSummaryStatistics summingSalDouble = emps.stream().collect(Collectors.summarizingDouble(m->m.getSalary()));
		System.out.println(summingSalDouble);
		
		//summarizingLong(ToLongFunction<? super T> mapper)
		LongSummaryStatistics summingSalLong = emps.stream().collect(Collectors.summarizingLong(m->(long)m.getSalary()));
		System.out.println(summingSalLong);
		
//Summing Operation
		
		//summingInt(ToIntFunction<? super T> mapper)
		int summingInt = emps.stream().collect(Collectors.summingInt(m->(int)m.getSalary()));
		System.out.println(summingInt);
		
		long summinglong = emps.stream().collect(Collectors.summingLong(m->(long)m.getSalary()));
		System.out.println(summinglong);
		
		double summingDouble = emps.stream().collect(Collectors.summingDouble(m->(long)m.getSalary()));
		System.out.println(summingDouble);
		
//To-Collection Operation
		
		//toCollection(Supplier<C> collectionFactory)
		Set<String> nameSet = emps.stream().map(m->m.getName()).collect(Collectors.toCollection(HashSet::new));
		System.out.println(nameSet);
		List<String> nameList = emps.stream().map(m->m.getName()).collect(Collectors.toCollection(ArrayList::new));
		System.out.println(nameList);
		
//To Concurrent Map Operation
		
	//toConcurrentMap(Function keyMapper, Function valueMapper)
		Stream<String> stream = Stream.of("apple", "banana", "orange");
        ConcurrentMap<Character, String> map = stream.collect(
        			Collectors.toConcurrentMap(s1 -> s1.charAt(0), String::toUpperCase));
		System.out.println(map);
		
		ConcurrentMap<Integer, String> twoFieldMap = emps.stream().collect(Collectors.toConcurrentMap(Employee::getId, Employee::getName));
		System.out.println(twoFieldMap);
		
		Map<String, List<String>> twoFieldMapsDuplicate1 = emps.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println(twoFieldMapsDuplicate1);
		
//toConcurrentMap(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction)
		Map<String, String>twoFieldMapsDupSolve = emps.stream().collect(Collectors.
				toConcurrentMap(Employee::getDept, Employee::getName, (x, y)->x+", "+y/** Duplicate Key Resolve*/));
		System.out.println(twoFieldMapsDupSolve);
		
		Map<String, String>twoFieldMapsDupSolve1 = emps.stream().collect(Collectors.
				toConcurrentMap(Employee::getDept, Employee::getName, (x, y)->x/** Duplicate Key Resolve*/));
		System.out.println(twoFieldMapsDupSolve1);
		
//toConcurrentMap(keyMapper, valueMapper, mergeFunction, Supplier<M> mapFactory)
		Map<String, String>twoFieldMapsDupSolve2 = emps.stream().collect(Collectors.toConcurrentMap(Employee::getDept, Employee::getName, (x, y)->x+", "+y, ConcurrentHashMap::new));
		System.out.println(twoFieldMapsDupSolve2);
		
        ConcurrentMap<Employee, String> concurrentHashMap = emps
                .parallelStream().collect(Collectors.toConcurrentMap(
                        Function.identity(), // 1. actual Object as KEY
                        Employee::getName,  // 2. Object Name as their VALUE
                        (key1, key2) -> key1, // 3. duplicate KEY resolver
                        ConcurrentHashMap::new // 4. implementation-class
                        ));
        System.out.println(concurrentHashMap);
        
//To Map Operation
        
        //toMap(Function keyMapper, Function valueMapper)
        Map<Integer, Employee> empMap = emps.stream().collect(Collectors.toMap(key->key.getId(), val->val));
		System.out.println(empMap);
		
		//toMap(keyMapper, valueMapper, mergeFunction)
		Map<String, Float> deptAvgSal = emps.stream().collect(Collectors.toMap(Employee::getDept, Employee::getSalary, (x, y)->(x+y)/2));
		System.out.println(deptAvgSal);
		
		//toMap(keyMapper, valueMapper, mergeFunction, mapFactory)
		Map<String, String> deptNames = emps.stream().collect(Collectors.toMap(Employee::getDept, Employee::getName, (x, y)->x+" | "+y, HashMap::new));
		System.out.println(deptNames);
		
		
		
		List<Widget> widgets = Data.getWidgets();
		
		Map<String, List<Widget>> widget1 = widgets.stream().collect(Collectors.groupingBy(Widget::getColor));
		System.out.println(widget1);
		
		Map<String, Long> widget2 = widgets.stream().collect(Collectors.groupingBy(Widget::getColor, Collectors.counting()));
		System.out.println(widget2);
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 5, 6);
		list.stream().parallel().collect(EveryNth.collector(2)).forEach(System.out::println);
		
	}
}

class EveryNth<C> {
	
    private final int nth;
    private final List<List<C>> lists = new ArrayList<>();
    private int next = 0;

    private EveryNth(int nth) {
        this.nth = nth;
        IntStream.range(0, nth).forEach(i -> lists.add(new ArrayList<>()));
    }

    private void accept(C item) {
        lists.get(next++ % nth).add(item);
    }

    private EveryNth<C> combine(EveryNth<C> other) {
        other.lists.forEach(l -> lists.get(next++ % nth).addAll(l));
        next += other.next;
        return this;
    }

    private List<C> getResult() {
        return lists.get(0);
    }

    public static Collector<Integer, ?, List<Integer>> collector(int nth) {
        return Collector.of(() -> new EveryNth(nth), 
            EveryNth::accept, EveryNth::combine, EveryNth::getResult);
    }
}