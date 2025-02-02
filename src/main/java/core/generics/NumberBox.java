package core.generics;

public class NumberBox<T extends Number> {

	private T num;

    public void set(T num) {
        this.num = num;
    }

    public T get() {
        return num;
    }
}
