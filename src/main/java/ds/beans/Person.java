package ds.beans;

import java.time.LocalDate;

/**
 * @author Hapheej
 *
 */
public class Person {

	public Person() { }
	
	public enum Sex {
		MALE, FEMALE
	};
	
	private String name;
	private String email;
	private LocalDate birthDate;
	private Sex gender;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public Sex getGender() {
		return gender;
	}
	public void setGender(Sex gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", birthDate=" + birthDate + ", gender=" + gender + "]";
	}
};
