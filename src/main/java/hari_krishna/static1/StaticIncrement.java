package hari_krishna.static1;

public class StaticIncrement {

	static int x = 10;

    static {
        x = x++ + ++x;
    }

    // x++ uses 10 (post-increment), ++x becomes 12 → x = 10 + 12 = 22
    
    public static void main(String[] args) {
        System.out.println(x);	// 22
    }
}
