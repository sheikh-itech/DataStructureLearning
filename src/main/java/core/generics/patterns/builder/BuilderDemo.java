package core.generics.patterns.builder;

public class BuilderDemo {

	public static void main(String[] args) {
		
		Computer computer = new ComputerBuilder<Computer>()
                .setCPU("Intel i7")
                .setRAM(16)
                .build();
		System.out.println(computer);
	}
}
