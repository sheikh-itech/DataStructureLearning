package ds.sorting;

import java.util.Comparator;

public class EmployeeSortByName implements Comparator<learn.ds.beans.Employee>{

	@Override
	public int compare(learn.ds.beans.Employee e1, learn.ds.beans.Employee e2) {
		// TODO Auto-generated method stub
		return e1.getName().compareTo(e2.getName());
	}
}
