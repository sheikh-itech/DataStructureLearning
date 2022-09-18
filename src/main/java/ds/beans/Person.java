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
	
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate birthDate;
	private Sex gender;

	
	
	public Person(String firstName, String lastName, Sex gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
		return "Person{firstName: " + firstName + ", lastName: " + lastName + "}";
	}
};
