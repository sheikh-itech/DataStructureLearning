package ds.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationExample {

	public static void main(String[] args) throws Exception {

		MyClass obj = new MyClass();
        Class<?> clazz = obj.getClass();
        
        for (Field field : clazz.getDeclaredFields()) {

        	if (field.isAnnotationPresent(Property.class)) {

        		Property annotation = field.getAnnotation(Property.class);
        		field.setAccessible(true);
                if(field.getType().getName().contains("String")) {
                	field.set(obj, annotation.value());
                } else if(field.getType().getName().contains("int")) {
                	field.setInt(obj, Integer.parseInt(annotation.value()));
                }
                field.setAccessible(false);
            }
        }
        
        // Get all methods declared in the class
        for (Method method : clazz.getDeclaredMethods()) {
            // Check if the method has the Loggable annotation
            if (method.isAnnotationPresent(Loggable.class)) {
                // Get the value of the annotation
                Loggable annotation = method.getAnnotation(Loggable.class);
                String value = annotation.value();
                method.invoke(obj, value);
            }
        }
        System.out.println(obj);
	}
}

class MyClass {
	
	@Property("Sheikh Hapheej")
    private String name;
    
	@Property("34")
    private int age;
    
	@Loggable("Custom Annotation")
	public void customAnnotation(String value) {
		System.out.println("Annotation Value: "+value);
	}

	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "MyClass{name=" + name + ", age=" + age + "}";
	}
}