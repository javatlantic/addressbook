package de.reserveddomain.addressbook.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;


import de.reserveddomain.addressbook.model.Gender;
import de.reserveddomain.addressbook.model.Person;
import de.reserveddomain.addressbook.utils.PersonFactory;

public class AddressBookService implements IAddressBookService {

	private static IAddressBookService addressBookServie;
	
	private static IParser parser = TxtFileParser.getInstance();
	
	private List<Person> personList;
	
	private AddressBookService(){
		
	}
	
	public static IAddressBookService getInstance(){
		if(addressBookServie == null)
			addressBookServie = new AddressBookService();
		return addressBookServie;
	}
	public long dtOfBirthDifference(Person person1, Person person2) {
		Date date1 = person1.getBirthDate();
		Date date2 = person2.getBirthDate();
		Calendar calendar1 = Calendar.getInstance();
		calendar1.clear();
		calendar1.setTime(date1);
		
		Calendar calendar2 = Calendar.getInstance();
		calendar2.clear();
		calendar2.setTime(date2);
		
		long date1Time = calendar1.getTimeInMillis();
		long date2Time = calendar2.getTimeInMillis();
		if(date1Time > date2Time)
			return TimeUnit.DAYS.convert(date1Time-date2Time, TimeUnit.MILLISECONDS);		
		return TimeUnit.DAYS.convert(date2Time-date1Time, TimeUnit.MILLISECONDS);
	}

	public int getFemaleCounter() {
		List<Person> females = new ArrayList<Person>();
		for(Person p : personList){
			if(p.getGender().getGenderValue().equals(Gender.Female.name()))
				females.add(p);
		}
		return females.size();
	}

	public Person getOldestEntry() {
		return getSortedPersonList().first();
	}

	public TreeSet<Person> getSortedPersonList() {
		TreeSet<Person> sortedSet = new TreeSet<Person>();
		sortedSet.addAll(personList);
		return sortedSet;
		
	}

	public List<Person> getPersonList() throws FileNotFoundException, IOException, ParseException {		
		return personList;	
	}
	

	public void init(String filename) throws FileNotFoundException, IOException, ParseException {
		List<String> lines = parser.parseTxtFile(filename);
		personList = new ArrayList<Person>();
		for(String line : lines){
			Person p = PersonFactory.stringToPerson(line);
			personList.add(p);
		}
	}

}
