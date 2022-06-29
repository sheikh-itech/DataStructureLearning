package ds.generics;

/**
 * @author Hapheej
 *
 */
/*public class FruitAppleAsianApple {

	@Override
	public String toString() {
	   return "I am a Fruit !!";
	}
}*/

class Fruit {

	@Override
	public String toString() {
	   return "I am a Fruit !!";
	}
}

class Apple extends Fruit {
	@Override
	public String toString() {
		return "I am an Apple !!";
	}
}

class AsianApple extends Apple {
	@Override
	public String toString() {
		return "I am an AsianApple !!";
	}
}