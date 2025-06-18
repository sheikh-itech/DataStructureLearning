package core.lambda.deep;

import java.util.List;
import java.util.function.ToIntFunction;

/*	Represents a function that produces an int-valued result */
public class FunctionToIntQuiz {

	public static void main(String[] args) {

		ToIntFunction<String> length = s -> s.length();
        System.out.println(length.applyAsInt("Java"));
        
        ToIntFunction<Integer> square = x -> x * x;
        System.out.println(square.applyAsInt(6));
        
        ToIntFunction<Double> rounder = d -> (int)Math.round(d);
        System.out.println(rounder.applyAsInt(7.8));
        
        ToIntFunction<String> firstCharAscii = s -> s.charAt(0);
        System.out.println(firstCharAscii.applyAsInt("ABC"));	// 65
        
        ToIntFunction<Box> extractor = b -> b.value;
        System.out.println(extractor.applyAsInt(new Box(99)));
        
   // Sum of ASCII values of a string
        
        ToIntFunction<String> asciiSum = s -> s.chars().sum();
        System.out.println(asciiSum.applyAsInt("ABC"));	//198 = 65+66+67
        
        
        ToIntFunction<Object> func = obj -> obj.toString().length();
        System.out.println(func.applyAsInt("hello"));
        
        
        List<String> list = List.of("Java", "GPT", "AI");
        
        ToIntFunction<List<String>> totalLength = l 
        		-> l.stream().mapToInt(String::length).sum();
        		
        System.out.println(totalLength.applyAsInt(list)); //9
        
	}
	
	static class Box {
        int value;
        Box(int v) { value = v; }
    }
}
