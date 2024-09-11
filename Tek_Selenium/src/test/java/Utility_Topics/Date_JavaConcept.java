package Utility_Topics;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Date_JavaConcept {

	public static void main(String[] args) {
		
		Date dateref = new Date();
	//	System.out.println(dateref.toString()); // Wed May 22 12:45:09 IST 2024
		
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String actDate = sim.format(dateref);
		System.out.println(actDate);   // 2024-05-22
		
		
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String datarequries = sim.format(cal.getTime());
		System.out.println(datarequries);  // 2024-06-21

	}

}
