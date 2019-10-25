import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;


public class DateTimeOne extends MesoDateTimeOneAbstract
{

	private static final int MILLI_CONSTANT = 1000;
	Calendar calendar; //calendar used for data
	
	public DateTimeOne() {
		//initializing the calendar
		calendar = new GregorianCalendar();
	}
	
	public int getValueOfSecond() {
	return (int)(System.currentTimeMillis() / MILLI_CONSTANT);
	}
	
	public void sleepForFiveSec() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("me no wanna go sleep");
		}
	}
	
	public void dateTimeNow() {
		//format for the date output is as follows:
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy h:mm a");
		System.out.println("Current Date/Time: " + dateFormat.format(calendar.getTime()));
	}
	
	public void dateTimeOfOtherCity() {
		//format for the hour output is as follows:
		SimpleDateFormat hourFormat = new SimpleDateFormat("k:mm");
		
		//getting the time zones for the GMT, BST, and CST time zones
		TimeZone gmt = TimeZone.getTimeZone("GMT");
		TimeZone bst = TimeZone.getTimeZone("BST");
		TimeZone cst = TimeZone.getTimeZone("CST");
		
		//printing out in the right format
		System.out.println("Time on Server: " + hourFormat.format(calendar.getTime()));
		System.out.println("GMT: " + hourFormat.format(gmt));
		System.out.println("BST (90E): " + hourFormat.format(bst));
		System.out.println("CST (90W): " + hourFormat.format(cst));
	}
	
	public void dateTimeDifferentZone() {
		
	}
	
	public void timeZoneHashMap() {
		
	}
}