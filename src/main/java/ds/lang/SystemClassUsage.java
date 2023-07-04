package ds.lang;

import java.io.Console;
import java.nio.channels.Channel;

public class SystemClassUsage extends SecurityManager {

	
	public static void main(String[] args) throws Exception {

		int []arr1 =  { 1,2,3,4,5,6 };
		int [] arr2 = { 0,0,0,0,0,0,0, }; //Interview- See Last ,

//Array Copy
		System.arraycopy(arr1, 0, arr2, 0, arr1.length);
		
		for(int i=0; i<arr2.length; i++)
			System.out.print(arr2[i]+", ");

//System Property
		System.setProperty("myProp", "Prop Value");
		System.out.println("\nSystem Prop: "+System.getProperty("myProp"));
		System.clearProperty("myProp");
		System.out.println("System Prop: "+System.getProperty("myProp"));

//Console
		Console con = System.console();
		if(con!=null) {
			String line = con.readLine();
			System.out.println("Console line: "+line);
		}
		
//Current Time
		System.out.println("Currentmilli's: "+System.currentTimeMillis());

//Channel
		Channel ch = System.inheritedChannel();
		if(ch!=null)
			ch.close();
	}
}
