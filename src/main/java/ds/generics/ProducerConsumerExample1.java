package ds.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hapheej
 *
 */
public class ProducerConsumerExample1 {

	public static void main(String[] args)
	{
		//List of apples
		List<Apple> apples = new ArrayList<Apple>();
		apples.add(new Apple());
	
		//We can assign a list of apples to a basket of apples
		List<? super Apple> basket = apples;
	
		basket.add(new Apple());    //Successful
		basket.add(new AsianApple()); //Successful
		//basket.add(new Fruit());    //Compile time error
	}
}
