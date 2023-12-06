package algo_ds.search;

public class LinearSearchExample {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,77,82,99,1,0,34};
		int target = 99;

		int result = linearSearch(arr, target, arr.length);
		System.out.println("Position of "+target+": "+(result+1));
	}

	/* linear search method
	    - values[] => array with all the values
	    - target => value to be found
	    - n => total number of elements in the array
	    Complexity: O(n)
	*/
	static int linearSearch(int values[], int target, int n)
	{
	    for(int i = 0; i < n; i++)
	    {
	        if (values[i] == target) 
	        {       
	            return i; 
	        }
	    }
	    return -1;
	}
}
