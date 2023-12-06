package hari_krishna.lang;

public class C implements Cloneable {

	private String name;
	private int num;
	
	private Test1 test;
	
	public C(String name, int num, Test1 test) {
		this.name = name;
		this.num = num;
		this.test = test;
	}
	
	@Override
	public C clone() throws CloneNotSupportedException {
		
		C c = (C) super.clone();
		c.test = this.test.clone();
		return c;
	}

	public Test1 getTest() {
		
		return test;
	}
	
	public void setTest(Test1 test) {
		
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

	public int JVMHashCodeForA() {
		
		return super.hashCode();
	}
}
