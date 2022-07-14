package ds.hk.strings;

public class VarArguments {

	public static void main(String[] args) {
		
		m1(1, "sheikh");
		m1(1, "sheikh", "hapheej");
		m1(1, "sheikh", "hapheej", "mansoori");
	}
	
	//The variable argument type Integer of the method m1 must be the last parameter
	//static void m1(Integer... numbers, String... values) {
	
	static void m1(Integer number, String... values) {
		System.out.print("{"+number+", ");
		for(int i=0; i<values.length; i++)
			if(i+1==values.length)
				System.out.print(values[i]);
			else System.out.print(values[i]+", ");
		System.out.println("}");
	}
}
