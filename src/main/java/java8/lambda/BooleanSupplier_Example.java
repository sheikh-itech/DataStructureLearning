package java8.lambda;

import java.time.LocalDate;
import java.util.function.BooleanSupplier;

/**	No Guarantee that new or distinct result be returned each time the supplier is invoked
 * 	supplier of boolean-valued results
 * 	It is similar to using an object of type Supplier<Boolean>
 */
public class BooleanSupplier_Example {

	public static void main(String[] args) {

		BooleanSupplier sup = () -> true;
        // Get the boolean value
        // Using getAsBoolean() method
        System.out.println(sup.getAsBoolean());
        
        BooleanSupplier dt = () -> LocalDate.now().isLeapYear();
        System.out.println(dt.getAsBoolean());
        
        BooleanSupplier bs = () ->  "my_username".length() > 5;
        System.out.println(bs.getAsBoolean());
	}
}
