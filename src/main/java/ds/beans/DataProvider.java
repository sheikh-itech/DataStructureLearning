package ds.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hapheej
 *
 */
public class DataProvider {

	public static List<Integer> getIntList() {
		
		return getIntList(0);
	}
	
	public static List<Integer> getIntList(int maxRange) {
		
		List<Integer> intList = new ArrayList<Integer>();
		
		if( maxRange > 0 ) {
			for(int count=0; count<maxRange; count++) {
				intList.add(count);
			}
		} else {
			for(int count=0; count<100000; count++) {
				intList.add(count);
			}
		}
		
		return intList;
	}

	public static List<Integer> getRandomIntList() {
		
		return getRandomIntList(0);
	}
	
	public static List<Integer> getRandomIntList(int maxRange) {
		
		List<Integer> randomIntList = new ArrayList<Integer>();
		if( maxRange>0 ) {
			for(int count=0; count<maxRange; count++) {
				randomIntList.add(Integer.parseInt(String.valueOf(Math.random())));
			}
		} else {
			for(int count=0; count<100000; count++) {
				randomIntList.add(Integer.parseInt(String.valueOf(Math.random())));
			}
		}
		
		return randomIntList;
	}
	
	public static List<String> getStringList() {
		
		return Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z");
	}
}
