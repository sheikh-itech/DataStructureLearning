package ds.hk.basic;

public class IdentifierWiding {

	public static void main(String[] args) {
		
		int a=10;
		long l = a;
		
		//a+a;	//The assignment to variable a has no effect
		
		int c = (int) l; //Widening
		
		float f = 4.4f;
		long ll = 2L;
		
		f = ll; //Compatible
		l = (long) f; //Widening required
		
		int in = 'a'; //Char withing range of int
		
		char ch = 'a';
		byte b = 5;
		short s = 6;
		
		in = b; //byte withing range of int
		in = s; //short withing range of int
		in = ch;
		ch = (char) in; //Narrowing required, as int hash high range
		
		System.out.println(c);
		System.out.println(in);
		

	}

}
