package assignment2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class A{
	public void getkycdateranges(String signupdatestring,String formdatestring){
		try {
			SimpleDateFormat signupdateformatter=new SimpleDateFormat("dd-MM-yyyy");
			Date signupdate=signupdateformatter.parse(signupdatestring);
			SimpleDateFormat formdateformatter=new SimpleDateFormat("dd-MM-yyyy");
			Date formdate=formdateformatter.parse(formdatestring);
			if(signupdate.after(formdate)){
				System.out.println("No range");
			}
			else {
				 Date fromdate=signupdate;
				 fromdate.setYear(formdate.getYear());
				 Calendar cal = Calendar.getInstance();
				 cal.setTime(fromdate);
				 cal.add(Calendar.DATE, -30);
				 fromdate = cal.getTime(); 
				 cal.add(Calendar.DATE, 60);
				 Date todate = cal.getTime();
				 if(todate.after(formdate)) {
					 todate=formdate;
				 }
				 String fromdateoutputstring = signupdateformatter.format(fromdate);
				 String todateoutputstring = signupdateformatter.format(todate);      
				 System.out.print(fromdateoutputstring);
				 System.out.print(" ");
				 System.out.println(todateoutputstring);
			}
			}catch (Exception e) {
				e.printStackTrace();
				}
		}
}
public class Main {
	public static void main(String[] args) {
		A a=new A();
		a.getkycdateranges("16-07-1998","27-06-2017");
		a.getkycdateranges("04-02-2016","04-04-2017");
		a.getkycdateranges("04-05-2017","04-04-2017");
		a.getkycdateranges("04-04-2015","04-04-2016");
		a.getkycdateranges("04-04-2015","15-03-2016");
	}
}