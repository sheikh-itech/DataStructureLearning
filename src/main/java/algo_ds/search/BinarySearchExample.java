package algo_ds.search;

/**
 * Note: Elements must be sorted for the Binary Search
 */
public class BinarySearchExample {

	public static void main(String[] args) {

		int arr[] = {1,2,3,4,5,6,7,8,9,10,11};
		int target = 9;

		int result = binarySearch(arr, target, arr.length);
		System.out.println("Position of "+target+": "+(result+1));

	}
	
	/*	Binary Search On Sorted Array
    - values[] => given sorted array
    - len => length of the array
    - target => value to be searched
    - Complexity: O(log n)
	*/
	static int binarySearch(int values[], int target, int len)
	{
	    int max = (len - 1);
	    int min = 0;
	    
	    int guess;  // this will hold the index of middle elements
	    int step = 0;  // to find out in how many steps we completed the search
	    
	    while(max >= min)
	    {
	        guess = (max + min) / 2;
	        // we made the first guess, incrementing step by 1
	        step++;
	        
	        if(values[guess] ==  target)
	        {
	            System.out.println("Number of steps required for search: " + step);
	            return guess;
	        }
	        else if(values[guess] >  target) 
	        {
	            // target would be in the left half
	            max = (guess - 1);
	        }
	        else
	        {
	            // target would be in the right half
	            min = (guess + 1);
	        }
	    }
	 
	    // We reach here when element is not 
	    // present in array
	    return -1;
	}
}
