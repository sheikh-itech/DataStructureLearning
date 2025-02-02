package core.generics;

/**		Self-Bounded Type
 * 	Self-bounding generics are used when a generic class or interface references 
 * 	itself as a bound
 * 	Commonly used in builder patterns
 */
public class ComparableBox<T extends ComparableBox<T>> {

	private String value;

    public ComparableBox(String value) {
        this.value = value;
    }

    public boolean isEqual(T other) {
        return this.value.equals(other.getValue());
    }
    
    public String getValue() {
        return value;
    }
}

class StringComparableBox extends ComparableBox<StringComparableBox> {
    public StringComparableBox(String value) {
        super(value);
    }
}