package ds.java8lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Hapheej
 *
 */
public class SortNames {

	public static void main(String []args) {
		
		List<String> names1 = Arrays.asList("peter", "anna", "mike", "xenia");
		List<String> names2 = Arrays.asList("peter", "anna", "mike", "xenia", "1234");
		List<String> names3 = Arrays.asList("peter", "anna", "mike", "xenia");
		List<String> names4 = Arrays.asList("peter", "anna", "mike", "xenia");
		
		Collections.sort(names1, new Comparator<String>() {
		    @Override
		    public int compare(String a, String b) {
		        return a.compareTo(b);
		    }
		});
		System.out.println(names1);
		
		Collections.sort(names2, (String a, String b) ->{
			return a.compareTo(b);
		});
		System.out.println(names2);
		
		Collections.sort(names3, (String a, String b) ->a.compareTo(b));
		System.out.println(names3);
		
		Collections.sort(names4, (a, b) -> a.compareTo(b));
		System.out.println(names4);
				
	}
}
