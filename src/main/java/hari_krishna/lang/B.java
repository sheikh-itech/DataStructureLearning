package hari_krishna.lang;

public class B implements Cloneable {

	private String name;
	private int num;
	
	private Test test;
	
	public B(String name, int num, Test test) {
		this.name = name;
		this.num = num;
		this.test = test;
	}

	public Test getTest() {
		
		return test;
	}
	
	public void setTest(Test test) {
		
		this.test = test;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "A [name=" + name + ", num=" + num + ", ststus=" + test.getStatus() + "]";
	}
	
	@Override
	public B clone() throws CloneNotSupportedException {
		
		return (B) super.clone();
	}
}
