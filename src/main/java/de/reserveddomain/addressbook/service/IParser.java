package de.reserveddomain.addressbook.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IParser {
	
	List<String> parseTxtFile(String filename) throws FileNotFoundException, IOException;

}
