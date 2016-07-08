package de.reserveddomain.addressbook.model;

import java.util.Date;

public class Person implements Comparable<Person>{
	
	private String firstname;
	private String lastname;
	private Date birthDate;
	private Gender gender;
	
	
	public Person() {
		
	}


	public int compareTo(Person o) {
		if(getBirthDate() == null || o.getBirthDate() == null)
			return 0;
		return getBirthDate().compareTo(o.getBirthDate());
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return getFirstname()+" "+getLastname();
	}
	
	
	

}
