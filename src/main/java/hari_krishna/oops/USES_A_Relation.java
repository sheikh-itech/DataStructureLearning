package hari_krishna.oops;

public class USES_A_Relation {

	public static void main(String[] args) {
		
		Wifi wifi = new Wifi(8);
		Mobile mobile = new Mobile("One+7");
		
		mobile.internetOn(wifi);
		mobile.internetOff();
	}
}


class Wifi {
	
	private int speed;
	
	Wifi(int speed){
		this.speed = speed;
	}
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}

class Mobile {
	
	private String name;
	
	Mobile(String name){
		this.name = name;
	}
	
	void internetOn(Wifi wifi) {
		
		System.out.println("Mobile "+this.name+" connected to wifi with speed: "+wifi.getSpeed()+" mbps");
	}
	
	void internetOff() {
		
		Wifi wifi = new Wifi(10);
		
		System.out.println("Mobile "+this.name+" connected to wifi with speed: "+wifi.getSpeed()+" mbps");
	}
}