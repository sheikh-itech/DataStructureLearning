package ds.sorting;

import java.util.Comparator;

import ds.beans.Employee;

public class EmployeeSortByName implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		// TODO Auto-generated method stub
		return e1.getName().compareTo(e2.getName());
	}
}
