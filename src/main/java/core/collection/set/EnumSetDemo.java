package core.collection.set;

import java.util.EnumSet;
import java.util.Set;

/**	Extremely efficient and compact
 * 	All elements in the EnumSet must belong to a single enum type
 */
public class EnumSetDemo {

	public static void main(String[] args) {
		
		Set<Day> enumSet = EnumSet.of(Day.MONDAY, Day.FRIDAY);
		
		System.out.println(enumSet);
	}
}

enum Day { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY }