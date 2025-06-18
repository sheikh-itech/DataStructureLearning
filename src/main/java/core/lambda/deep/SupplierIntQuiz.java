package core.lambda.deep;

import java.util.function.IntSupplier;

public class SupplierIntQuiz {

	static int counter = 0;
	
	public static void main(String[] args) {

		IntSupplier supplier = () -> 42;
        System.out.println(supplier.getAsInt());
        
        supplier = () -> ++counter;
        
        System.out.print(supplier.getAsInt());
        System.out.println(supplier.getAsInt());
        
        int value = 10;
        supplier = () -> value * 2;
        System.out.println(supplier.getAsInt());
        
        IntSupplier random = () -> (int)(Math.random() * 10);
        System.out.println(random.getAsInt());
        
        supplier = () -> {
            int x = 5;
            return x + 3;
        };
        System.out.println(supplier.getAsInt());
        
        final int seed = 5;
        IntSupplier s = () -> seed + 2;
        System.out.println(s.getAsInt());
        
        supplier = () -> counter++;
        System.out.print(supplier.getAsInt() + " ");
        System.out.println(supplier.getAsInt());
	}
}
