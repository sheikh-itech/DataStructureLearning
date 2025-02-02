package core.generics.patterns.builder;

public class ComputerBuilder<T extends Computer> {

	private String CPU;
    private int RAM;

    public ComputerBuilder<T> setCPU(String CPU) {
        this.CPU = CPU;
        return this;
    }

    public ComputerBuilder<T> setRAM(int RAM) {
        this.RAM = RAM;
        return this;
    }

    @SuppressWarnings("unchecked")
	public T build() {
        return (T) new Computer(CPU, RAM);
    }
}
