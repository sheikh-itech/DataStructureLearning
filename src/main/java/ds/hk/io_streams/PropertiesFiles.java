package ds.hk.io_streams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesFiles {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		Properties prop = new Properties();
		prop.load(new FileReader(new File("files/property.properties")));
		
		Set<Object> keys = prop.keySet();
		
		for(Object obj : keys) {
			
			System.out.println(obj.toString() +" => "+prop.get(obj));
		}
	}
}
