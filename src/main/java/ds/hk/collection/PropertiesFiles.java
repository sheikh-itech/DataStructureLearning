package ds.hk.collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

public class PropertiesFiles {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		Properties prop;
		
		//Get System Properties
		
		prop = System.getProperties();
		
		Enumeration<Object> enums = prop.elements();
		while(enums.hasMoreElements())
			System.out.println(enums.nextElement());
		
		prop.store(new FileWriter(new File("files/key-values.properties")), "dummy");
		prop.storeToXML(new FileOutputStream(new File("files/key-values.xml")), "dummy");
		
		
		//Get Properties from File
		
		prop = new Properties();
		prop.load(new FileReader(new File("files/property.properties")));
		
		Set<Object> keys = prop.keySet();
		
		for(Object obj : keys) {
			
			System.out.println(obj.toString() +" => "+prop.get(obj));
		}
		
		prop.setProperty("dummy", "dummy");
		
		prop.list(new PrintStream(System.out));	//Prints to console
	}
}
