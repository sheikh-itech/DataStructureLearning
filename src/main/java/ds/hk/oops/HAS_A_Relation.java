package ds.hk.oops;

public class HAS_A_Relation {

	public static void main(String[] args) {

		Engine e = new Engine(470);
		
		Cars c = new Cars("Farari", 50);
		c.setEngine(e);
		
		System.out.println(c.toString());
	}

}

class Cars {
	
	private String name;
	private int price;
	
	//HAS-A
	private Engine engine;
	
	Cars(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public String toString() {
		
		return "{"+this.name+", "+this.price+", "+engine.getEngineCC()+"}";
	}
}

class Engine {
	
	private int engineCC;
	
	Engine(int engineCC){
		this.engineCC = engineCC;
	}
	
	public int getEngineCC() {
		return engineCC;
	}
	public void setEngineCC(int engineCC) {
		this.engineCC = engineCC;
	}
	
	public String toString() {
		
		return "{"+this.engineCC+"}";
	}
}