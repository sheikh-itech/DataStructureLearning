package core.generics;

import java.util.ArrayList;
import java.util.List;

public class ListStorage<T> implements Storage<T> {

	private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public T get(int index) {
        return items.get(index);
    }
}

//Generic Interfaces
interface Storage<T> {
    void add(T item);
    T get(int index);
}
