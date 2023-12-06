package hari_krishna.basic;

public class NullFundas {

	@SuppressWarnings("null")
	public static void main(String[] args) {

		Null nll = null;
		Null nll1 = new Null();
		System.out.println(null == null);
		System.out.println(nll == null);
		
		try {
			System.out.println(nll.equals(null));
		} catch(NullPointerException ex) {
			System.out.println("Null Pointer Exception");
		}
		System.out.println(nll1.equals(null));
		
		// Cannot invoke equals(null) on the primitive type null
		//System.out.println(null.equals(null));
		
		
		System.out.println(nll = null);
	}
}

class Null {
	
}