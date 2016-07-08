package de.reserveddomain.addressbook.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TxtFileParser implements IParser {
	
	private static IParser parser;
	
	private TxtFileParser(){
		
	}
	
	public static IParser getInstance(){
		if(parser == null){
			parser = new TxtFileParser();
		}
		return parser;
	}

	public List<String> parseTxtFile(String filename) throws IOException  {
		File file = new File(filename);
		List<String> rows= null;
		if(!file.canRead() || !file.isFile()){
			System.exit(0);
		}
		BufferedReader in = new BufferedReader(new FileReader(filename));
		rows = new ArrayList<String>();
		try {
			String row = null;
			while((row = in.readLine()) != null){
				rows.add(row);
			}
		}finally {
			in.close();
		}			
		return rows;
	}	
	
}
