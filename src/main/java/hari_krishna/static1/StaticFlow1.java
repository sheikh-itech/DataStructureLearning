package hari_krishna.static1;

public class StaticFlow1 {

	/*
	static {
        x += 5;	// CE:: Cannot reference a field before it is defined
        System.out.println("Static block: " + x);
    }*/
	
	static int x = initialize();

    static int initialize() {
        System.out.println("Static initializer");
        return 10;
    }

    static {
        x += 5;
        System.out.println("Static block: " + x);
    }
    

    public static void main(String[] args) {
        System.out.println("Main: " + x);
    }
}
