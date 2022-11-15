package models;
import java.time.LocalDate;
import java.time.Period;


public class Contact {
	private String name;
	private int age;
	private String birthDate;
	private String phoneNumber;
	
	  
	
	public Contact(String name, String phoneNumber, String birthDate) {
		if (name==null || name.isBlank() || phoneNumber==null || phoneNumber.isBlank() ||phoneNumber.length()<5) {
			throw new IllegalArgumentException("Name or phone is not valid.");
		}
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
		LocalDate today = LocalDate.now();
	    LocalDate birthday = LocalDate.parse(birthDate);
	    Period period = Period.between(birthday, today);
	    this.age =period.getYears();	
			
	}
	
	public Contact(Contact source) {   //copy constructor to eliminate reference trap
	this.name = source.name;
	this.phoneNumber = source.phoneNumber;
	this.birthDate = source.birthDate;
	this.age = source.age;
    }
	
	public String getName() {
		return this.name;
	}
	
	public void  setName(String name) {
		if(name==null || name.isBlank()) {
			throw new IllegalArgumentException("Name cannot be  null or blank");
		}else {
			this.name = name;	
		}
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void  setPhoneNumber(String phoneNumber) {
		if (phoneNumber ==null || phoneNumber.isBlank() || phoneNumber.length()<5) {
			throw new IllegalArgumentException("Phone number should not be null, blank or with less than 5 digits.");
		}
			
		this.phoneNumber = phoneNumber;
	}
	
	public String getBirthDate() {
		return this.birthDate;
	}
	
	public void  setBirthDate(String birthDate) {
		this.birthDate = birthDate;
		this.setAge(birthDate);  //set age again if the birthday is updated.
	}
	
	private void setAge(String birthDate) {
		LocalDate today = LocalDate.now();
    	LocalDate birthday = LocalDate.parse(birthDate);
    	Period period = Period.between(birthday, today);
    	this.age =period.getYears();
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String toString() {
		return "Name: " + this.name + "\n" +
				"Phone number: " + this.phoneNumber + "\n" +
				"Birth Date: " + this.birthDate + "\n" +
				"Age: " + this.age + " years old\n";
	}
	

}
