package ds.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Hapheej
 *
 */
public class OptionalConcept {

	private static List<String> data = new ArrayList<>();
	static List<String> name = new ArrayList<>();
	
	
	public static void main(String[] args) {
		name.add("abc");
		data.add("sheikh");
		data.add("hapheej");
		data.add("mansoori");
		Optional<List<String>> optional = Optional.of(data);
		System.out.println(optional.isPresent());
		List<String> result = new ArrayList<>();
		optional.ifPresent((data) -> result.addAll(name));
		System.out.println(result);
	}

}
