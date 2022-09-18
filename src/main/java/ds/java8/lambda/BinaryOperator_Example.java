package ds.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

/** Represents an operation upon two operands of the same type, 
 * 	producing a result of the same type as the operands
 *
 *	->Specialization of BiFunction, where the operands and the result are 'Same Type'
 */
public class BinaryOperator_Example {

	public static void main(String[] args) {

		BinaryOperator<Integer> op = 
        BinaryOperator.maxBy((a, b) -> (a > b) ? 1 : ((a == b) ? 0 : -1));

		System.out.println("Max: "+op.apply(98, 11));
		
		op = BinaryOperator.minBy((a, b) -> (a > b) ? 1 : ((a == b) ? 0 : -1));

		System.out.println("Min: "+op.apply(98, 11));
		
		List<Integer>nums = Arrays.asList(1, 3, 2,55, 34, 11, 99, 203, 23, 84, 56, 123, 456, 123);
		
		Comparator<Integer> comarator = (x,y)->x>y?1:-1;
		System.out.println("Max in array: "+find(nums, BinaryOperator.maxBy(comarator)));
		System.out.println("Min in array: "+find(nums, BinaryOperator.minBy((x,y)->x>y?1:-1)));
	}
	
	public static Integer find(List<Integer> list, BinaryOperator<Integer> accumulator) {
		Integer result = null;
        for (Integer t : list) {
            if (result == null) {
                result = t;
            } else {
                result = accumulator.apply(result, t);
            }
        }
        return result;
    }
}
