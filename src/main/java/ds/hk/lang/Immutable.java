package ds.hk.lang;

public final class Immutable implements Cloneable {

	private final String field;
	
	public Immutable() {
		
		this.field = "XYZ";
	}
	
	@Override
	public Immutable clone() throws CloneNotSupportedException {
		
		return (Immutable) super.clone();
	}
	
	public String getField() {
		
		return this.field;
	}

	public long fieldHash() {

		return field.hashCode();
	}
	
	public long classHash() {

		return this.hashCode();
	}
}
