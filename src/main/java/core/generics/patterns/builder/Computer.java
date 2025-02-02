package core.generics.patterns.builder;

public class Computer {
	
	private final String CPU;
    private final int RAM;
    
    public Computer(String CPU, int RAM) {
        this.CPU = CPU;
        this.RAM = RAM;
    }

    @Override
    public String toString() {
        return "Computer with CPU=" + CPU + ", RAM=" + RAM;
    }
}
