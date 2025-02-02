package core.generics.patterns.factory;

public class FactoryDemo {

	public static void main(String[] args) {

		Factory<ProductA> productAFactory = new Factory<>(ProductA.class);
		Product productA = productAFactory.createInstance();
		productA.use();
	}
}
