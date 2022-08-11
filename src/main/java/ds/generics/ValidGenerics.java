package ds.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ValidGenerics {

	public static void main(String[] args) {

		List<?> names = new ArrayList<String>();
		//names.add("sheikh");
		
		List<? extends String> nums = new ArrayList<String>();
		//nums.add("a");
		
		//Collection<? super Object> names1 = new ArrayList<String>();
		

	}

}
