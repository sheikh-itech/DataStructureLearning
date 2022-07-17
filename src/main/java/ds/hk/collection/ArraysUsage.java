package ds.hk.collection;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntUnaryOperator;

/**
 *	Arrays have various methods to Manipulate array 
 */

public class ArraysUsage {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		//asList​(T... a) -> Returns Fixed Size List
		List<String> names = Arrays.asList("Sheikh", "Hapheej", "Mansoori");
		System.out.println(names);
		
		//binarySearch​(byte[] a, byte key)
		//binarySearch​(byte[] a, int fromIndex, int toIndex, byte key)
		
		int index = Arrays.binarySearch(getByteArray(), (byte)5);
		System.out.println("Index of 5: "+index);
		index = Arrays.binarySearch(getByteArray(), (byte)3, (byte)8, (byte)7);
		System.out.println("Index of 7: "+index);
		
		/**	Above Binary Search Function Implemented For:
		 *  char[], short[], int[], long[], float[], double[], T[], (T[], Comparator)
		 *  boolean[]
		 */
		
		//compare​(byte[] a, byte[] b) -> Compares two byte arrays lexicographically
		//compare​(byte[] a, int aFromIndex, int aToIndex, byte[] b, int bFromIndex, int bToIndex)
		
		int result = Arrays.compare(getExtendedByteArray(), getByteArray());
		System.out.println("Compare(byte[size:17], byte[size:10]): "+result);
		result = Arrays.compare(getByteArray(), getExtendedByteArray());
		System.out.println("Compare(byte[size:10], byte[size:17]): "+result);
		
		/**	Above Compare Function Implemented For:
		 *  char[], short[], int[], long[], float[], double[], T[], (T[], Comparator)
		 *  boolean[]
		 */
		
		//copyOf​(byte[] original, int newLength)
		byte[] copiedArray = Arrays.copyOf(getExtendedByteArray(), 11);
		System.out.println("Original Array Length: "+getExtendedByteArray().length);
		System.out.println("Copied Array Lenght: "+copiedArray.length);
		
		/**	Above copyOf Function Implemented For:
		 *  char[], short[], int[], long[], float[], double[], T[], (T[], Comparator)
		 *  boolean[]
		 */
		
		//copyOfRange​(byte[] original, int from, int to)
		copiedArray = Arrays.copyOfRange(getExtendedByteArray(), 5, 12);
		System.out.println("Ranged Copied [] lenght: "+copiedArray.length);
		
		/**	Above copyOfRange Function Implemented For:
		 *  char[], short[], int[], long[], float[], double[], T[], (T[], Comparator)
		 *  boolean[]
		 */
		
		//If 2 arrays equals content wise
		//Arrays.equals​(byte[] a, byte[] a2)
		/**	Above equals Function Implemented For:
		 *  char[], short[], int[], long[], float[], double[], T[], (T[], Comparator)
		 *  boolean[]
		 */
		
		//Arrays.fill​(byte[] a, byte val)
		//fill​(byte[] a, int fromIndex, int toIndex, byte val)
		//Assigns the specified byte value to each element of the specified array of bytes
		byte[] arr = getByteArray();
		System.out.println("Original Array: "+print(arr));
		
		//Arrays.fill​(byte[] a, int fromIndex, int toIndex, byte val)
		Arrays.fill(arr, (byte)7);
		System.out.println("\nChanged Array fill(7): "+print(arr));
		/**	Above fill(..) Function Implemented For:
		 *  char[], short[], int[], long[], float[], double[], T[], (T[], Comparator)
		 *  boolean[]
		 */
		
		//Arrays.mismatch​(byte[] a, byte[] b)
		//mismatch​(byte[] a, int aFromIndex, int aToIndex, byte[] b, int bFromIndex, int bToIndex)
		
		/**	Finds and returns the index of the first mismatch between two byte arrays,
		 * otherwise return -1 if no mismatch is found
		 */
		
		int[] array = new int[20];
		//Returns a unary operator that always returns its input argument
		Arrays.setAll(array, IntUnaryOperator.identity());
		System.out.println("array: "+print(array));
		
		/**	Above Arrays.setAll) Function Implemented For:
		 *  int[], long[], double[], T[]
		 */
		
		byte[] random = getRandomByteArray();
		System.out.println("Before Sort: "+print(random));
		Arrays.sort(random);
		System.out.println("After Sort: "+print(random));
		
		/**	Above sort(..) Function Implemented For:
		 *  char[], short[], int[], long[], float[], double[], T[], (T[], Comparator)
		 *  Object[]
		 */
		
		//Arrays.stream​(int[] array)
		//Arrays.stream​(int[] array, int startInclusive, int endExclusive)
		//Returns a sequential IntStream with the specified array as its source
		Arrays.stream(getIntArray());
		
		/**	Above stream(..) Function Implemented For:
		 *  int[], long[], double[], T[]
		 */
		String arrStr = Arrays.toString(getByteArray());
		System.out.println("to String() byte[]: "+arrStr);
		/**	Above sort(..) Function Implemented For:
		 *  char[], short[], int[], long[], float[], double[], Object[], boolean[]
		 */
	}
	
	static byte[] getByteArray() {
		
		byte[] byts = new byte[10];
		
		for(byte i=0; i<10;i++)
			byts[i] = i;
		
		return byts;
	}
	
	static int[] getIntArray() {
		
		int[] byts = new int[10];
		
		for(int i=0; i<10;i++)
			byts[i] = i;
		
		return byts;
	}
	
	static byte[] getExtendedByteArray() {
		
		byte[] byts = new byte[17];
		
		for(byte i=0; i<17;i++)
			byts[i] = i;
		
		return byts;
	}
	
	static byte[] getRandomByteArray() {
		
		byte[] byts = new byte[10];
		
		for(byte i=0; i<byts.length;i++)
			byts[i] = Byte.valueOf((byte) String.valueOf(Math.random()).charAt(5));
		
		return byts;
	}
	
	static String print(byte[] arr) {
		String str = "[";
		for(int i=0;i<arr.length;i++) {
			if(i==arr.length-1)
				str = str+arr[i];
			else
				str = str+arr[i]+", ";
		}
		str = str+ "]";
		
		return str;
	}
	
	static String print(int[] arr) {
		String str = "[";
		for(int i=0;i<arr.length;i++) {
			if(i==arr.length-1)
				str = str+arr[i];
			else
				str = str+arr[i]+", ";
		}
		str = str+ "]";
		
		return str;
	}
}
