package core.generics.patterns.singleton;

import java.util.HashMap;
import java.util.Map;

public class SingletonHolder<T> {

	private static final Map<Class<?>, Object> instances = new HashMap<>();
	
	@SuppressWarnings("unchecked")
    public static <T> T getInstance(Class<T> type) {
        synchronized (instances) {
            return (T) instances.computeIfAbsent(type, SingletonHolder::instantiate);
        }
    }

    private static <T> T instantiate(Class<T> type) {
        try {
            return type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Cannot create singleton instance", e);
        }
    }
}
