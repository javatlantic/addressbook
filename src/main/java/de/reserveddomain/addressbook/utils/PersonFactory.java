package de.reserveddomain.addressbook.utils;


import java.text.ParseException;
import java.util.List;
import java.util.TreeSet;

import de.reserveddomain.addressbook.model.Gender;
import de.reserveddomain.addressbook.model.Person;

public class PersonFactory {

	
	
	
	public static Person stringToPerson(String line) throws ParseException {
		Person person = new Person();
		String attrs[] = stringToArray(line);
		person.setFirstname(attrs[0]);
		person.setLastname(attrs[1]);
		person.setGender(Gender.convert(attrs[2]));
		person.setBirthDate(DateUtil.stringtoDate(attrs[3]));
		return person;
	}
	
	public static String[] stringToArray(String row){
		return row.split("(?:,|\\s)\\s*");
	}
	
	
}
