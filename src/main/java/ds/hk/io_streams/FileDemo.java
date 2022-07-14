package ds.hk.io_streams;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import javax.swing.filechooser.FileNameExtensionFilter;

public class FileDemo {

	public static void main(String[] args) throws IOException {

		File file1 = new File("files");
		
		System.out.println("isFile(): "+file1.isFile());
		
		File file2 = new File(file1, "file.txt");
		
		System.out.println("isFile(): "+file2.isFile());
	
		File file3 = new File(file1, "file1");
		
		File f = file3.getCanonicalFile();
		System.out.println(f);
		
		boolean created = file3.createNewFile();
		
		System.out.println("file1: "+created);
		System.out.println("file1: "+file3.delete());
		
		//File file5 = new File("folder1", "file.txt");	//CE::File not Exists
		
		new File("temp").mkdir();
		File file4 = new File("temp/file2");
		file4.mkdir();
		File file5 = new File(file4, "file.txt");
		file5.createNewFile();
		System.out.println(file5.isFile());
		
		new File("temp/files1/file2/file3/file4").mkdirs();
		
	}
}
