package ds.sorting;

import java.util.Comparator;

public class EmployeeSortByName implements Comparator<ds.beans.Employee>{

	@Override
	public int compare(ds.beans.Employee e1, ds.beans.Employee e2) {
		// TODO Auto-generated method stub
		return e1.getName().compareTo(e2.getName());
	}
}
