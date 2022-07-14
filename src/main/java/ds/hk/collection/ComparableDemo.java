package ds.hk.collection;

import java.util.Set;
import java.util.TreeSet;

public class ComparableDemo {

	public static void main(String[] args) {

		Set<Numbers> nums = new TreeSet<>();
		nums.add(new Numbers(5));
		nums.add(new Numbers(0));
		nums.add(new Numbers(97));
		nums.add(new Numbers(35));
		nums.add(new Numbers(52));
		System.out.println("Comparable Sorted: "+nums);
	}

}

class Numbers implements Comparable<Numbers> {

	private int num;
	
	@Override
	public int compareTo(Numbers o) {
		
		return this.num - o.getNum();
	}

	Numbers(int num){
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		
		return num+"";
	}
}