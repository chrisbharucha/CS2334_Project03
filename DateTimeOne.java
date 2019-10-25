import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.TimeZone;


public class DateTimeOne extends MesoDateTimeOneAbstract
{

	private static final int MILLI_CONSTANT = 1000;
	Calendar calendar; //calendar used for data
	HashMap<String, String> map;
	
	
	public DateTimeOne() {
		//initializing the calendar and HashMap
		calendar = new GregorianCalendar();
		map = new HashMap<String, String>();
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
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy h:mm a");
		System.out.println("Current Date/Time: " + dateFormat.format(calendar.getTime()));
	}
	
	public void dateTimeOfOtherCity() {
		//format for the hour output is as follows:
		SimpleDateFormat hourFormat = new SimpleDateFormat("k:mm");
		
		//getting the time zones for the GMT, BST, and CST time zones
		TimeZone GMT = TimeZone.getTimeZone("GMT");
		TimeZone BST = TimeZone.getTimeZone("BST");
		TimeZone CST = TimeZone.getTimeZone("CST");
		
		//creating calendars for the time zones
		Calendar gmt = Calendar.getInstance(GMT);
		Calendar bst = Calendar.getInstance(BST);
		Calendar cst = Calendar.getInstance(CST);
		
		//printing out in the right format
		System.out.println("Time on Server: " + hourFormat.format(calendar.getTime()));
		System.out.println("GMT: " + hourFormat.format(gmt.getTime()));
		System.out.println("BST (90E): " + hourFormat.format(bst.getTime()));
		System.out.println("CST (90W): " + hourFormat.format(cst.getTime()));
	}
	
	public void dateTimeDifferentZone() {
		//format for the date output of other timeZone is as follows:
		SimpleDateFormat zoneDateFormat = new SimpleDateFormat("MM/dd/yyyy k:mm");
		
		//getting the time zones for the GMT, BST, and CST time zones
		TimeZone GMT = TimeZone.getTimeZone("GMT");
		TimeZone BST = TimeZone.getTimeZone("BST");
		TimeZone CST = TimeZone.getTimeZone("CST");
				
		//creating calendars for the time zones
		Calendar gmt = Calendar.getInstance(GMT);
		Calendar bst = Calendar.getInstance(BST);
		Calendar cst = Calendar.getInstance(CST);
		
		//Getting the String representations of the date to store in HashMap
		String gmtValue = zoneDateFormat.format(gmt.getTime());
		String bstValue = zoneDateFormat.format(bst.getTime());
		String cstValue = zoneDateFormat.format(cst.getTime());
		
		//adding the time zones to the HashMap
		map.put("GMT", gmtValue);
		map.put("BST", bstValue);
		map.put("CST", cstValue);
		
		//printing out in the right format
		System.out.println("GMT: " + gmtValue);
		System.out.println("BST: " + bstValue);
		System.out.println("CST: " + cstValue);
	}
	
	public void timeZoneHashMap() {
		
	}
}