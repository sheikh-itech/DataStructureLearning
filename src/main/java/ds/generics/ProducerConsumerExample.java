package ds.generics;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerExample {

	public static void main(String[] args)
	   {
	      //List of apples
	      List<Apple> apples = new ArrayList<Apple>();
	      apples.add(new Apple());
	       
	      //We can assign a list of apples to a basket of fruits;
	      //because apple is subtype of fruit 
	      List<? extends Fruit> basket = apples;
	       
	      //Here we know that in basket there is nothing but fruit only
	      for (Fruit fruit : basket)
	      {
	         System.out.println(fruit);
	      }
	       
	      //basket.add(new Apple()); //Compile time error
	      //basket.add(new Fruit()); //Compile time error
	   }
}
