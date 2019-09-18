package assignment4;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateValidator {
	
	static Date signupDate, formDate;
	static SimpleDateFormat signUpDateFormatter, formDateFormatter;
	
	/* convert given string to date */
	public static void convertStringToDate(String signUpDateString, String formDateString) {
		
		try {
			signUpDateFormatter = new SimpleDateFormat("dd-MM-yyyy");
			signupDate = signUpDateFormatter.parse(signUpDateString);
			formDateFormatter = new SimpleDateFormat("dd-MM-yyyy");
			formDate = formDateFormatter.parse(formDateString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/* convert calendar format to string */
	public static void convertDateToString(Date fromDate, Date toDate) {
		
		String fromDateOutputString = signUpDateFormatter.format(fromDate);
		String toDateOutputString = signUpDateFormatter.format(toDate);
		printOutputDates(fromDateOutputString, toDateOutputString);
		
	}
	
	/* prints the output */
	public static void printOutputDates(String fromDateOutputString, String toDateOutputString) {
	
		System.out.print(fromDateOutputString);
		System.out.print(" ");
		System.out.println(toDateOutputString);
		
	}

	public static void getKycDateRanges(String signUpDateString, String formDateString) {
		
		convertStringToDate(signUpDateString, formDateString);
		try {
			if (signupDate.after(formDate)) {
				System.out.println("No range");
			} else {
				
				Date fromDate = signupDate;
				fromDate.setYear(formDate.getYear());//get year from formdate for fromdate
				Calendar cal = Calendar.getInstance();
				cal.setTime(fromDate);
				cal.add(Calendar.DATE, -30);//subtracts 30 days from current date to get from date
				fromDate = cal.getTime();
				cal.add(Calendar.DATE, 60);//adds 60 days to fromdate to get todate 
				Date toDate = cal.getTime();
				
				/* if toDate is after formDate the toDate is formDate */
				if (toDate.after(formDate)) {
					toDate = formDate;
				}
	
				convertDateToString(fromDate, toDate);// converts date back to string to print

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		getKycDateRanges("16-07-1998", "27-06-2017"); //output: 16-06-2017 27-06-2017
		getKycDateRanges("04-02-2016", "04-04-2017"); //output: 05-01-2017 06-03-2017
		getKycDateRanges("04-05-2017", "04-04-2017"); //output: No range
		getKycDateRanges("04-04-2015", "04-04-2016"); //output: 05-03-2016 04-04-2016
		getKycDateRanges("04-04-2015", "15-03-2016"); //output: 05-03-2016 15-03-2016
		
	}
}
