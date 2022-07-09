package ds.hk.io_streams;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo {

	public static void main(String[] args) throws Exception {

		Person p = new Person(143, "Hapheej", "Narsinghpur");
		p.setMobile(97809165);
		p.setZipCode(480223);
		p.setCountryCode(91);
		
		FileOutputStream stream1 = new FileOutputStream(new File("files/Person.ser"));
		FileOutputStream stream2 = new FileOutputStream(new File("files/Person"));
		
		ObjectOutputStream out1 = new ObjectOutputStream(stream1);
		ObjectOutputStream out2 = new ObjectOutputStream(stream2);
		
		out1.writeObject(p);
		out2.writeObject(p);
		
		out1.close();
		out2.close();
	}
}
