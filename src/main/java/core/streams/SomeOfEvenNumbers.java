package core.streams;

import java.util.Arrays;

public class SomeOfEvenNumbers {

	public static void main(String[] args) {

		int sum = 0;
		
		int array1[]= {1, 3, 4, 6, 8, 2, 9, 10};

		for(int i=0; i<array1.length; i++) {
			//if(i%2==0) Common mistakes
			if(array1[i]%2==0)
				sum += array1[i];
		}
		
		System.out.println("Even number sum: "+sum);
		sum = 0;
		
		//Stream
		sum = Arrays.stream(array1).filter(n->n%2==0).sum();
		System.out.println("Even number sum: "+sum);

	}

}
