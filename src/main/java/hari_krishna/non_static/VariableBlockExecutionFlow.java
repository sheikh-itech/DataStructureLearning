package hari_krishna.non_static;

public class VariableBlockExecutionFlow {

	int x = 5;
	
	{
		System.out.println("First NSB, X: "+x);
	}
	
	{
		System.out.println("Second NSB, Y: "+this.y);
		//System.out.println("Second NSB, Y: "+y); CE::Cannot reference a field before it is defined
	}
	
	int y = 10;
	int z = 15;
	
	public static void main(String[] args) {

		VariableBlockExecutionFlow demo = new VariableBlockExecutionFlow();
		
		System.out.println("Z: "+demo.z);
	}
}
