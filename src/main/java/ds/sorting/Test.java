package ds.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import learn.ds.beans.Address;
import learn.ds.beans.Employee;

public class Test {

	public static void main(String[] args) {
		Employee e1 = new Employee("sheikh", 1250, new Address("21 blikers", "new York", "way south", "USA", 620021));
		Employee e2 = new Employee("hapheej", 1750, new Address("cyfa tower", "new York", "down street", "USA", 620021));
		Employee e3 = new Employee("mansoori", 1450, new Address("38 cafe", "new York", "manhatton", "USA", 620021));
		List<Employee> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		System.out.println("List sort by their name's\n----------------------------------");
		Collections.sort(list, new EmployeeSortByName());
		list.forEach(emp->System.out.println(emp));
		System.out.println("List sort by their salary\n----------------------------------");
		Collections.sort(list, new EmployeeSortBySalary());
		list.forEach(emp->System.out.println(emp));
		
		
		int numbers[] = new int[50];
    	Random ran = new Random();
    	for(int count=0; count<50; count++) {
    		numbers[count]=ran.nextInt(1000);
    	}
    	int numbers1[]=new int[50];
    	numbers1=numbers.clone();
    	BubbleSort.arraysSort(numbers);
    	BubbleSort.normalSort(numbers1);
    	for(int i=0; i<numbers.length; i++) {
    		System.out.println(numbers[i]+"  --"+(i+1));
    	}
    	for(int i=0; i<numbers1.length; i++) {
    		System.out.println(numbers1[i]+"  --"+(i+1));
    	}
	}
}
