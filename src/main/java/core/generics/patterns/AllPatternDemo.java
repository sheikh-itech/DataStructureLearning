package core.generics.patterns;

import core.generics.patterns.singleton.SingletonHolder;

public class AllPatternDemo {

	@SuppressWarnings("unused")
	public static void main(String []args) {
		
		//Singleton Demo
		ProductA singletonProductA = SingletonHolder.getInstance(ProductA.class);
		ProductB singletonProductB = SingletonHolder.getInstance(ProductB.class);
	}
}
