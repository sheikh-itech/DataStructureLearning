package ds.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;

public class PrivateMemberInvocation {

	public static void main(String[] args) {
		Data data = null;
		try {
			
			Class cls = Class.forName("ds.reflection.Data");
			Constructor<Data> [] cons = cls.getDeclaredConstructors();
			
			for(Constructor c:cons) {
				
				c.setAccessible(true);
				Parameter []paras = c.getParameters();
				
				if(paras.length>0) {
					
					initConstructors(paras, c, data);
					
				} else {

					data = (Data) c.newInstance();
				}
			}
			data.init();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private static void initConstructors(Parameter []paras, Constructor c, Data data) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		for(Parameter para : paras) {
			
			Type t = para.getParameterizedType();
			String typeName = t.getTypeName();
			
			switch(typeName) {
				
				case "java.lang.String": data = (Data) c.newInstance("Parameterized constructor using reflection");
				break;
				
				case "boolean": data = (Data) c.newInstance(true);
				break;
				
				case "float": data = (Data) c.newInstance(0.0F);
				break;
				
				case "long": data = (Data) c.newInstance(0L);
				break;
				
				case "int": data = (Data) c.newInstance(0);
				break;
				
				default: data = null;
			}
		}
	}
}
