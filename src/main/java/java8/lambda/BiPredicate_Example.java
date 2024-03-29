package java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

/**	predicate (boolean-valued function) of two arguments
 *	Returns boolean result
 */
public class BiPredicate_Example {

	public static void main(String[] args) {

		BiPredicate<String, Integer> filter = (x, y) -> x.length() == y;
		
		System.out.println(filter.test("Arham", 5));
		
		List<Domain> domains = Arrays.asList(new Domain("google.com", 1),
                new Domain("i-am-spammer.com", 10),
                new Domain("mkyong.com", 0),
                new Domain("microsoft.com", 2));

        BiPredicate<String, Integer> biPredicate = (domain, score) -> domain.equalsIgnoreCase("google.com") || score == 0;
        
        // if google or score == 0
        List<Domain> result = filterBadDomain(domains, biPredicate);
		System.out.println(result); // google.com, mkyong.com
		
		//  if score == 0
        List<Domain> result2 = filterBadDomain(domains, (domain, score) -> score == 0);
        System.out.println(result2);
        
        // if start with i or score > 5
        List<Domain> result3 = filterBadDomain(domains, (domain, score) -> domain.startsWith("i") && score > 5);
        System.out.println(result3); // i-am-spammer.com

//Chaining with-> or
        List<Domain> result4 = filterBadDomain(domains, biPredicate.or(
                (domain, x) -> domain.equalsIgnoreCase("microsoft.com"))
        );
        System.out.println(result4);
	}

	private static List<Domain> filterBadDomain(List<Domain> domains, BiPredicate<String, Integer> biPredicate) {

		return domains.stream()
                .filter(x -> biPredicate.test(x.getName(), x.getScore()))
                .collect(Collectors.toList());
	}
}

class Domain {

    String name;
    Integer score;

    public Domain(String name, Integer score) {
        this.name = name;
        this.score = score;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "{name: " + name + ", score: " + score + "}";
	}
}