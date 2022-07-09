package ds.hk.io_streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamDemo {

	public static void main(String[] args) throws Exception {
		
		FileInputStream stream1 = new FileInputStream(new File("files/Person.ser"));
		FileInputStream stream2 = new FileInputStream(new File("files/Person"));
		
		ObjectInputStream in1 = new ObjectInputStream(stream1);
		ObjectInputStream in2 = new ObjectInputStream(stream2);
		
		Person p1 = (Person) in1.readObject();
		Person p2 = (Person) in2.readObject();
		
		System.out.println(p1);
		System.out.println(p2);
		
		in1.close();
		in2.close();
	}
}
