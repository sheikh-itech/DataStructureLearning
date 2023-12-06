package java8.streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *	Sum of One Field of Objects using their Other Field
 *	Handling Duplicate Key using mapMerger function
 *	Using New Supplier
 */

public class BaseStreamExample {

	
	public static void main(String []args) {
		
		List<Widget> widgets = Data.getWidgets();
		
		int totalWeight = widgets.stream().filter(w->w.getColor()=="Red").mapToInt(m->m.getWeight()).sum();
		System.out.println(totalWeight);
		
		double doubleWeight = widgets.parallelStream().filter(w->w.getColor()=="Red").mapToDouble(m->m.getWeight()).sum();
		System.out.println(doubleWeight);
		
		/** Use Parallel Streams Only If Data Above 8-10 Lacks */
		List<Integer> nums = Data.getIntList(999999);
		long t1 = System.currentTimeMillis();
		nums.parallelStream().filter(n->n%2==0).mapToDouble(m->m).sum();
		System.out.println("Parallel: "+(System.currentTimeMillis()-t1));
		
		t1 = System.currentTimeMillis();
		nums.stream().filter(n->n%2==0).mapToDouble(m->m).sum();
		System.out.println("Single: "+(System.currentTimeMillis()-t1));
		
		/** For Duplicate Color, It will throw Error:: IllegalStateException: Duplicate key*/
		try {
			Map<String, Object> errorWidget = widgets.stream().collect(Collectors.toMap(Widget::getColor, v->v));
			System.out.println(errorWidget);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		//Duplicate Problem solve
		Map<Object, Long> objectCount = widgets.stream().map(m->m.getColor()).collect(Collectors.groupingBy(s->s, LinkedHashMap::new, Collectors.counting()));
		System.out.println(objectCount);
		
		Map<Integer, Widget> widget = widgets.stream().collect(Collectors.toMap(key->key.getId(), val->val));
		System.out.println(widget);
		
		
		/** Widgets with sum of one Field, With Merge Function */
		Map<String, Integer> widget1 = widgets.stream().collect(Collectors.toMap(key->key.getColor(), val->val.getWeight(), (curr, next)->{
			
			return curr=Integer.parseInt(curr.toString())+Integer.parseInt(next.toString());
		}));
		System.out.println(widget1);
		
		/** Widgets with sum of one Field, With Merge Function */
		widget1 = widgets.stream().collect(Collectors.toMap(Widget::getColor, Widget::getWeight, 
				(e, r)-> e = (Integer.parseInt(e.toString())+Integer.parseInt(r.toString()))));
		System.out.println(widget1);
		
		/** Widgets with sum of one Field, With Merge Function */
		Map<Widget, Integer> widget2 = widgets.stream().collect(Collectors.toMap(k->k, Widget::getWeight, 
				(e, r)-> e = (Integer.parseInt(e.toString())+Integer.parseInt(r.toString()))));
		System.out.println(widget2);
		
		/** Widgets with sum of one Field, With Merge Function 
		 * & New Supplier TreeMap::new, for ordered elements */
		widget2 = widgets.stream().collect(Collectors.toMap(k->k, Widget::getWeight, 
				(e, r)-> e = (Integer.parseInt(e.toString())+Integer.parseInt(r.toString())), TreeMap::new));
		
		
		List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
				 .flatMap(numbers -> numbers.stream())
				 .collect(Collectors.toList());
		System.out.println(together);
	}
}
