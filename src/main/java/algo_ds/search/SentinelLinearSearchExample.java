package algo_ds.search;

//Not Authentic Sentinel-Linear-Search
public class SentinelLinearSearchExample {

	public static void main(String[] args) {
		
		int arr[] = {1,2,3,4,5,6,77,82,99,1,0,34};
	    int n = arr.length;
	    int key = 99;
	 
	    sentinelSearch(arr, n, key);
	}
	
	// Function to search x in the given array
    static void sentinelSearch(int arr[], int n, int key)
    {
 
        // Last element of the array
        int last = arr[n - 1];
 
        // Element to be searched is
        // placed at the last index
        arr[n - 1] = key;
        int i = 0;
 
        while (arr[i] != key)
        	i++;
            
 
        // Put the last element back
        arr[n - 1] = last;
 
        if ((i < n - 1) || (arr[n - 1] == key))
            System.out.println(key + " is present at index "
                               + i);
        else
            System.out.println("Element Not found");
    }
}
