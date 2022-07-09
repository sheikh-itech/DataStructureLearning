package ds.hk.io_streams;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public class DataInputStreamDemo {

	public static void main(String[] args) throws Exception {

		FileInputStream stream = new FileInputStream(new File("files/DataInputOutputStream.txt"));
		
		DataInputStream dn = new DataInputStream(stream);
		
		int num = dn.readInt();
		float num1 = dn.readFloat();
		String name = dn.readUTF();
		
		System.out.println(num);
		System.out.println(num1);
		System.out.println(name);
		dn.close();
	}
}
