package de.reserveddomain.addressbook.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.TreeSet;

import de.reserveddomain.addressbook.model.Person;

public interface IAddressBookService {
	
	public void init(String filename) throws FileNotFoundException, IOException, ParseException;

	public long dtOfBirthDifference(Person person1, Person person2);
	
	public int getFemaleCounter();
	
	public Person getOldestEntry();
	
	public TreeSet<Person> getSortedPersonList();
	
	public List<Person> getPersonList() throws FileNotFoundException, IOException, ParseException;
 
	
}
