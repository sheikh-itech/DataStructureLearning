package hari_krishna.datatypes;

public interface Interface {

	public static final int x1 = 0;
	public static final int y1 = 0;
	
	public abstract float calculateLine(int x1, int y1, int x2, int y2);
	
	
	/*	line() is interface method not implementation classes of Interface	interface*/
	public static void line() {
		System.out.println("Line Start, x1: "+x1+", y1: "+y1);
	}
	
	/*	Default implementation available for all subclasses of Interface */
	public default void lineEnd(int x2, int y2) {
		
		System.out.println("Line End, x2: "+ x2+", y2: "+y2);
	}
	
	public interface CalculateLine {
	
		public static final int x1 = 15;
		public static final int y1 = 22;
	}
	
	public class LineCorrection {
		
		public static final int x1 = 45;
		public static final int y1 = 62;
	}
}
