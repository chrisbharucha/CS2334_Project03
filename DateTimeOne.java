import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
		//format for the output is as follows:
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy hh:mm a");
		System.out.println("Current Date/Time: " + dateFormat.format(calendar.getTime()));
	}
	
	
	public void dateTimeOfOtherCity() {
		
	}
	
	public void dateTimeDifferentZone() {
		
	}
	
	public void timeZoneHashMap() {
		
	}
}