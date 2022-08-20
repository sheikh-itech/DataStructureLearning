package ds.java8.streams;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**		Array To Stream
 *	
 *	1. IntStream.range(0, chars.length).mapXX(..)
 *	2. new String(chars).chars()
 *	3. CharBuffer.wrap(chars).chars()
 *	4. Stream.of(chars)
 *	5. Arrays.stream(nums)
 *
 *	Arrays.stream(..) can not stream char[] but can stream Character[] 
 */

public class ArraysWithStream {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Integer[] ar = {};
		long arrayStatus=0;
		List<Integer> arrayToIntList = null;
		int[] nums = getIntArray();
		char[] chars = getCharArray();
		Character[] characters = getCharacterArray();
		
	//*******char[] Array To Stream*********

		long count = IntStream.range(0, chars.length).mapToObj(i->chars[i]).count();
		
		arrayToIntList = 
				new String(chars).chars().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		arrayToIntList = 
				new String(chars).chars().mapToObj(m->m).collect(Collectors.toList());
		
		/** CharBuffer.wrap-> Fast Because Of Internal Splitters, And No Copy Operation */
		List<Character> arrayToCharacter = 
				CharBuffer.wrap(chars).chars().mapToObj(i->(char)i).collect(Collectors.toList());
		
		List<Character> characterToList = 
				IntStream.range(0, chars.length).mapToObj(i->chars[i]).collect(Collectors.toList());
		
	
	//*******Character[] Array To Stream*********
	
		characterToList = Arrays.stream(characters).collect(Collectors.toList());
		Set<Character> characterToSet = IntStream.range(0, characters.length).mapToObj(i-> characters[i]).collect(Collectors.toSet());
		
		//new String(Character[]) not defined
		//new String(characters).chars().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		arrayToIntList = new String(characters.toString()).chars().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		
		//CharBuffer.wrap(characters); 	//Not defined for Character
		
		//This will Collect Only Indexes of Array
		arrayToIntList = IntStream.range(0, characters.length).map(m->(char)m).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		
	//*******Character[] Array To Stream*********
		
		//Array Statistics Sum, Avg, Count, Max, Min, Distinct
		
		arrayStatus = Arrays.stream(nums).sum();
		arrayStatus = Arrays.stream(nums).count();
		OptionalInt max = Arrays.stream(nums).max();
		OptionalInt min = Arrays.stream(nums).min();
		OptionalDouble avg = Arrays.stream(nums).average();
		
		IntSummaryStatistics summary = Arrays.stream(nums).summaryStatistics();
		System.out.println(summary.getAverage());
		
		//distinct()
		arrayToIntList = Arrays.stream(nums).distinct().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		
		//Return First Matched element
		Optional<Character> maxChar1 = Arrays.stream(characters).max(Comparator.comparing(k->k>105));
		maxChar1 = Arrays.stream(characters).max(Comparator.comparing(k->k<102));
		
		//Returns Total/Last matched element..Compares each element
		Optional<Character> maxChar2 = Arrays.stream(characters).max(Comparator.comparing(k->k, Comparator.comparing(k->k)));
		Optional<Character> mixChar = Arrays.stream(characters).min(Comparator.comparing(k->k, Comparator.comparing(k->k)));
		
		boolean allMatchedCondition = Arrays.stream(characters).allMatch(c->c>110);
		
		boolean anyMatchedCondition = Arrays.stream(characters).anyMatch(c->c>110);
		
		/** Drop from start while Condition true 
		 * If First condition failed, return all element*/
		List<Character> dropWhile = Arrays.stream(characters).dropWhile(predicate->predicate<=103).collect(Collectors.toList());
		arrayToIntList = Arrays.stream(nums).dropWhile(predicate->predicate<50).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
	
	//Predicate Supply
		Predicate<Character> predicate = e->(e>110);
		allMatchedCondition = Arrays.stream(characters).allMatch(predicate);
		
		System.out.println(arrayToIntList);
		System.out.println((int)'f');
		
	}

	static int[] getIntArray() {

		return new int[] {1, 9, 3, 56, 23, 4, 6 ,98, 61, 32};
	}
	
	static char[] getCharArray() {

		return new char[] {'a', 'x', 'z', 'c', 'e', 'i', 'z', 'x', 'a', 'c'};
	}
	
	static Character[] getCharacterArray() {

		return new Character[] {'f', 'g', 'a', 'x', 'z', 'c', 'e', 'i', 'z', 'x', 'a', 'c'};
	}
}
