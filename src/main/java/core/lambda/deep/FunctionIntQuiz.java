package core.lambda.deep;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

public class FunctionIntQuiz {

	public static void main(String[] args) {

		IntFunction<String> repeater = x -> "A".repeat(x);
        System.out.println(repeater.apply(3)); //AAA
        
        
        IntFunction<int[]> arrayCreator = size -> new int[size];
        System.out.println(Arrays.toString(arrayCreator.apply(4)));
        
        
        IntFunction<List<String>> listCreator = size -> List.of("x".repeat(size));
        System.out.println(listCreator.apply(2));
        
        
        IntFunction<Character> intToChar = i -> (char)(i + 65);
        System.out.println(intToChar.apply(0)); // A
        
        
        IntFunction<String> converter = Integer::toHexString;
        System.out.println(converter.apply(255));
        
        
        IntFunction<String[]> strArr = len -> new String[len];
        String[] result = strArr.apply(3);
        System.out.println(result.length);
        
        
        IntFunction<Boolean> isEven = n -> n % 2 == 0;
        System.out.println(isEven.apply(4));
        
        
        IntFunction<StringBuilder> builderGen = i -> new StringBuilder("Count: " + i);
        System.out.println(builderGen.apply(10));
	}
}
