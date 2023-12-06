package hari_krishna.inner_class;

public class PrivateMemberAccessToNested {

	private static final String name = "Arham";
	private final String address = "Narsinghpur";
	
	static class OuterAccessToInner {
		
		public static void innerStatic() {
			System.out.println("Inner static access: "+name);
		}
		
		public void innerNStatic() {
			
			//Non-Static not allowed in static directly
			
			//System.out.println("Inner non-static access: "+address);
		}
	}
	
	class OuterNonStaticAccessToInner {
		
		//Static Method Not allowed
		/*public static void innerStatic() {
			System.out.println("Inner static access: "+name);
		}*/
		
		public void innerNStatic() {
			System.out.println("Inner non-static access: "+address);
		}
	}
	public static void main(String[] args) {
		

	}
}
