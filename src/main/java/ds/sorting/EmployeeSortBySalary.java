package ds.sorting;

import java.util.Comparator;

public class EmployeeSortBySalary implements Comparator<learn.ds.beans.Employee> {

	@Override
	public int compare(learn.ds.beans.Employee e1, learn.ds.beans.Employee e2) {
		
		int result = 0;
		if(e1.getSalary() == e2.getSalary()) {
			result = e1.getName().compareTo(e2.getName());
		}
		if(e1.getSalary() > e2.getSalary()) result = 1;
		if(e1.getSalary() < e2.getSalary()) result = -1;
		
		return result;
	}
}
