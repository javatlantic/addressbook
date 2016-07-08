package de.reserveddomain.addressbook;


import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Logger;
import de.reserveddomain.addressbook.model.Person;
import de.reserveddomain.addressbook.service.AddressBookService;
import de.reserveddomain.addressbook.service.IAddressBookService;

public class AddressBook {
	
	private static IAddressBookService service =  AddressBookService.getInstance();
	
	private static Logger logger = Logger.getLogger(AddressBook.class.getName());	
	
	public static void main(String[] args) {
		
		try {
			String filename = "Personenlist.txt";
			service.init(filename);	
			int femaleCounter = service.getFemaleCounter();
			System.out.println(String.format("1.%s",femaleCounter));
			Person oldestOne = service.getOldestEntry();
			System.out.println(String.format("2.%s",oldestOne.toString()));
			List<Person> personList;
			personList = service.getPersonList();
			if(personList != null && personList.size() >= 2){
				Person p1 = service.getPersonList().get(0);
				Person p2 = service.getPersonList().get(1);
				long daysDifference = 	service.dtOfBirthDifference(p1, p2);
				System.out.println(String.format("3.%s",daysDifference));	
			}
		} catch ( IOException e) {
			logger.severe(e.getMessage());
			e.printStackTrace();
		} catch(ParseException e){
			logger.severe(e.getMessage());
			e.printStackTrace();
		}
	}

}
