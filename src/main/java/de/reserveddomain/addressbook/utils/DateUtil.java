package de.reserveddomain.addressbook.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	private static DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

	public static Date stringtoDate(String dateStr) throws ParseException {
		return df.parse(dateStr);
	}

}
