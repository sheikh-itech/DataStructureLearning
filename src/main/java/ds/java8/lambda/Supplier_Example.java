package ds.java8.lambda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**	Supplies/produces 'T' type of values
 * 	Takes no input
 */
public class Supplier_Example<T> {

	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public static void main(String[] args) {

		Supplier<Double> doubleSuplier = ()->Math.random();
		System.out.println(doubleSuplier.get());
		
		
		Supplier<LocalDateTime> s = () -> LocalDateTime.now();
        LocalDateTime time = s.get();
        System.out.println(time);

        Supplier<String> s1 = () -> dtf.format(LocalDateTime.now());
        String time2 = s1.get();
        System.out.println(time2);
        
        Supplier_Example<String> suppl = new Supplier_Example<>();
        
        List<String> names = suppl.listSupplier().get();
        names.add("Arham");
        System.out.println(names);
        
        Employee e1 = factory( Employee::new );
        System.out.println(e1);
        
        Employee e2 = factory( ()-> new Employee() );
        System.out.println(e2);
	}
	
	public Supplier<List<T>> listSupplier() {

        // lambda
        // return () -> new ArrayList<>();

        // constructor reference
        return ArrayList::new;
        
        //method reference
        //ArrayList::add
	}
	
	public static Employee factory(Supplier<? extends Employee> s) {

		Employee emp = s.get();
        if (emp.getName() == null || "".equals(emp.getName())) {
        	emp.setName("default");
        }
        emp.setSalary(0.0f);
        emp.setStartDate(LocalDate.of(2017, 8, 8));

        return emp;
    }
}
