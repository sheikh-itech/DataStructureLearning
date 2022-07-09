package ds.hk.lang;

public class Test1 implements Cloneable {

	private String status;

	
	public Test1(String status) {
		
		this.status = status;
	}
	
	@Override
	public Test1 clone() throws CloneNotSupportedException {
		
		return (Test1) super.clone();
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
