package ds.sorting;

import java.util.Comparator;

public class EmployeeSortBySalary implements Comparator<ds.beans.Employee> {

	@Override
	public int compare(ds.beans.Employee e1, ds.beans.Employee e2) {
		
		int result = 0;
		if(e1.getSalary() == e2.getSalary()) {
			result = e1.getName().compareTo(e2.getName());
		}
		if(e1.getSalary() > e2.getSalary()) result = 1;
		if(e1.getSalary() < e2.getSalary()) result = -1;
		
		return result;
	}
}
