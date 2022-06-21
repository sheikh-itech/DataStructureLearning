package ds.beans;

public class Address {
	
	private String street;
	private String city;
	private String zone;
	private String country;
	private int areaCode;
	
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}
	
	public Address(String street, String city, String zone, String country, int areaCode) {
		this.street = street;
		this.city = city;
		this.zone = zone;
		this.country = country;
		this.areaCode = areaCode;
	}
	public Address() {
		
	}
	@Override
	public String toString() {
		return this.street+" "+this.city+" "+this.zone+" "+this.country+", "+this.areaCode;
	}	
}
