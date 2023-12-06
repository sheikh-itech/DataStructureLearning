package generics;

/**
 * @author Hapheej
 *
 */
@SuppressWarnings("unused")
public class ArrayExamples<T> {

	private T[] notYetInstantiatedArray;

	private void genericArray() {
		
		// causes compiler error; Cannot create a generic array of T
	    //public T[] array = new T[5];
		
	}
	
	private void arrayStoreErrorNonGeneric() {
		
		Object[] array = new String[10];
		array[0] = "lokesh";
		//array[1] = 10;      //This will throw ArrayStoreException in Runtime
		
		String[] array1 = new String[10];
		array1[0] = "lokesh";
		//Compile time error
		//array1[1] = 10;
		
		Object[] stringObject = new String[10];
		stringObject[0] = new String();
	}
	
	public static void main(String[] args) {

		ArrayExamples<Integer> array = new ArrayExamples<>();
		array.arrayStoreErrorNonGeneric();
		array.genericArray();

	}

}
