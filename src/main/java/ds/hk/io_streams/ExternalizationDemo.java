package ds.hk.io_streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternalizationDemo {

	public static void main(String[] args) throws Exception {

		Student s = new Student(10, "hapheej");
		FileOutputStream stream = new FileOutputStream(new File("files/Student.ser"));
		ObjectOutputStream out = new ObjectOutputStream(stream);
		out.writeObject(s);
		out.close();
		
		FileInputStream in = new FileInputStream(new File("files/Student.ser"));
		ObjectInputStream inObj = new ObjectInputStream(in);
		Student s1 = (Student) inObj.readObject();
		inObj.close();
		System.out.println(s1);
	}
}
