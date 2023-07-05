package ds.sorting;

import java.util.Comparator;

import ds.beans.Employee;

public class EmployeeSortBySalary implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		
		int result = 0;
		if(e1.getSalary() == e2.getSalary()) {
			result = e1.getName().compareTo(e2.getName());
		}
		if(e1.getSalary() > e2.getSalary()) result = 1;
		if(e1.getSalary() < e2.getSalary()) result = -1;
		
		return result;
	}
}
