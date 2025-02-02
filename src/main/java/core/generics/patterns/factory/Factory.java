package core.generics.patterns.factory;

public class Factory<T extends Product> {

	private final Class<T> type;

    public Factory(Class<T> type) {
        this.type = type;
    }

    public T createInstance() {
        try {
            return type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Cannot create instance of " + type.getName(), e);
        }
    }
}
