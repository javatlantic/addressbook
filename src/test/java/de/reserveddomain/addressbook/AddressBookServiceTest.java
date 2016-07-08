package de.reserveddomain.addressbook;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.text.ParseException;

import de.reserveddomain.addressbook.model.Person;
import de.reserveddomain.addressbook.service.AddressBookService;
import de.reserveddomain.addressbook.service.IAddressBookService;
import junit.framework.TestCase;


public class AddressBookServiceTest extends TestCase {	
	
	IAddressBookService personService = AddressBookService.getInstance();
	
	private String filename = "Personenlist.txt";	
	
	@Override
	protected void setUp() throws Exception {
		personService.init(filename);
	}
	
	public void testPersonListSize() throws FileNotFoundException, IOException, ParseException{
		assertEquals(5, personService.getPersonList().size());	
	}
		
	public void testOldestPerson() throws FileNotFoundException, IOException, ParseException{		
		assertEquals("Wes Jackson", personService.getSortedPersonList().first().toString());
	}
	
	public void testRecentPerson(){
		assertEquals("Gemma Lane", personService.getSortedPersonList().last().toString());
	}
	
	public void testGetFemaleCounter(){
		assertEquals(2, personService.getFemaleCounter());
	}
	
	public void testDtOfBirthDifference() throws FileNotFoundException, IOException, ParseException{
		Person p1 = personService.getPersonList().get(0);
		Person p2 = personService.getPersonList().get(1);		
		assertEquals(2889, personService.dtOfBirthDifference(p1, p2));
	}
	

}
