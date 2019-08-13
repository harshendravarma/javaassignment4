package assignment4;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class DateValidator {
	static Date signupDate,formDate;
	static SimpleDateFormat signUpDateFormatter,formDateFormatter;
	public static void convertStringToDate(String signUpDateString,String formDateString) {
		/*convert given string to date*/
		try {
		signUpDateFormatter=new SimpleDateFormat("dd-MM-yyyy");
		signupDate=signUpDateFormatter.parse(signUpDateString);
		formDateFormatter=new SimpleDateFormat("dd-MM-yyyy");
		formDate=formDateFormatter.parse(formDateString);
		}catch (Exception e) {
			e.printStackTrace();
			}
	}
	public static void convertDateToString(Date fromDate,Date toDate) {
		 /*convert calendar format to string*/
		 String fromDateOutputString = signUpDateFormatter.format(fromDate);
		 String toDateOutputString = signUpDateFormatter.format(toDate);
		 printOutputDates(fromDateOutputString,toDateOutputString );
	}
	public static void printOutputDates(String fromDateOutputString,String toDateOutputString ) {
		/*prints the output*/
		 System.out.print(fromDateOutputString);
		 System.out.print(" ");
		 System.out.println(toDateOutputString);
	}
	public static void getKycDateRanges(String signUpDateString,String formDateString){
		convertStringToDate(signUpDateString,formDateString);
		try {
			if(signupDate.after(formDate)){
				System.out.println("No range");
			}
			else {
				/*take current year signUp dates date and month*/
				 Date fromDate=signupDate;
				 fromDate.setYear(formDate.getYear());
				 Calendar cal = Calendar.getInstance();
				 cal.setTime(fromDate);
				 cal.add(Calendar.DATE, -30);
				 fromDate = cal.getTime(); 
				 cal.add(Calendar.DATE, 60);
				 Date toDate = cal.getTime();
				 /*if toDate is after formDate the toDate is formDate*/
				 if(toDate.after(formDate)) {
					 toDate=formDate;
				 }
				 convertDateToString(fromDate,toDate);
				
			}
			}catch (Exception e) {
				e.printStackTrace();
				}
		}


	public static void main(String[] args) {
		getKycDateRanges("16-07-1998","27-06-2017");
		getKycDateRanges("04-02-2016","04-04-2017");
		getKycDateRanges("04-05-2017","04-04-2017");
		getKycDateRanges("04-04-2015","04-04-2016");
		getKycDateRanges("04-04-2015","15-03-2016");
	}
}
