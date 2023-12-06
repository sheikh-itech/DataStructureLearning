package hari_krishna.enum1;


public enum MonthsEnum {
	
	JAN, FEB, MARCH;
}

enum MonthsEnum1 {
	
	//The constructor MonthsEnum1() is undefined
	//JAN, FEB, MARCH;
	
	JAN(1), FEB(2), MARCH(3);
	
	MonthsEnum1(int value) {
		
	}
}

enum MonthEnum {
	
	JAN(1), FEB(2), MARCH(3), APRIL(4), MAY(5);
	
	private int num;
	
	MonthEnum(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}