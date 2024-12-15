package problems.SOLID.LibraryManagement.utilities.impl;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	public static Date addDays(Date date,int daysToAdd){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE,daysToAdd);
		return calendar.getTime();
	}
}
