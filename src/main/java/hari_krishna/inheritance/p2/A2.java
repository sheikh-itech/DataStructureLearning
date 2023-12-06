package hari_krishna.inheritance.p2;

import hari_krishna.inheritance.p1.A1;

public class A2 extends A1 {
	
	void a2m1() {
		System.out.println("A2:default m1()");
	}
	
	protected void a2m2() {
		System.out.println("A2:protected m2()");
	}
	
	public void a2m3() {
		System.out.println("A2:public m3()");
	}
}
