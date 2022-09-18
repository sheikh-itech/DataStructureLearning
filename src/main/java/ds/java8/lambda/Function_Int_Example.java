package ds.java8.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntFunction;

/**	Accepts an int-valued argument and produces a result
 */ 
public class Function_Int_Example {

	public static void main(String[] args) {
		 
		Map<Integer, String> months = getMonths();
		 
		IntFunction<Double> func1 = a -> a / 2.0;
		  
        System.out.println(func1.apply(3));
        
        
        IntFunction<String> getMonthName = monthNo -> {  // lambda expression
        	return (months.get(monthNo)!=null) ? months.get(monthNo) : "The number must between 1 to 12";
        };
        
        System.out.println(getMonthName.apply(2));
        	
	}
	
	public static Map<Integer, String> getMonths() {
		Map<Integer, String> months = new HashMap<>();
		months.put(1, "January");
        months.put(2, "February");
        months.put(3, "March");
        months.put(4, "April");
        months.put(5, "May");
        months.put(6, "June");
        months.put(7, "July");
        months.put(8, "August");
        months.put(9, "September");
        months.put(10, "October");
        months.put(11, "November");
        months.put(12, "December");
        return months;
	}
}
