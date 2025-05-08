package hari_krishna.io_streams;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputStreamDemo {

	public static void main(String[] args) throws Exception {

		FileInputStream fis = new FileInputStream("files/BufferedOutputStream.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);

		int data;
		while ((data = bis.read()) != -1) {
		    System.out.print((char) data);
		}

		bis.close();
		fis.close();

	}
}
