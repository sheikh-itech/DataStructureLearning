package core.collection.list;

public class Student {

	private int roll;
	private float percent;
	
	public Student(int roll, float percent) {
		this.roll = roll;
		this.percent = percent;
	}
	
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public float getPercent() {
		return percent;
	}
	public void setPercent(float percent) {
		this.percent = percent;
	}
	@Override
	public String toString() {
		return "Student [roll: " + roll + ", percent: " + percent + "]";
	}
}
