import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.TimeZone;


public class DateTimeOne extends MesoDateTimeOneAbstract
{

	private static final int ARRAY_SIZE = 10;
	private static final int MILLI_CONSTANT = 1000;
	Calendar calendar; //calendar used for data
	HashMap<String, String> map;
	
	
	public DateTimeOne() {
		//initializing the calendar and HashMap
		calendar = new GregorianCalendar();
		map = new HashMap<String, String>();
	}
	
	public int getValueOfSecond() {
		//using the milli conversion factor to get time in seconds
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
		//adding two new time zones and their dates to the first HashMap
		map.put("ZST", "11/05/2018 19:59");
		map.put("AST", "10/01/2020 19:59");
		
		//declaring a new HashMap
		HashMap<String,String> noZoneMap = new HashMap<String,String>();
		
		/* adding the contents of the first HashMap to the new one, using the values from first HashMap
		 * as the keys for the new HashMap
		 */
		noZoneMap.put(map.get("GMT"), map.get("GMT"));
		noZoneMap.put(map.get("BST"), map.get("BST"));
		noZoneMap.put(map.get("CST"), map.get("CST"));
		noZoneMap.put(map.get("ZST"), map.get("ZST"));
		noZoneMap.put(map.get("AST"), map.get("AST"));
		
		//declaring an array to store the values of the first HashMap
		LocalDateTime[] array = new LocalDateTime[ARRAY_SIZE];
		
		//creating a format to use for converting String to LocalDateTime objects
		DateTimeFormatter arrFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy k:mm");
		
		//creating the LocalDateTime objects
		LocalDateTime gmtLDT = LocalDateTime.parse(map.get("GMT"), arrFormat);
		LocalDateTime bstLDT = LocalDateTime.parse(map.get("BST"), arrFormat);
		LocalDateTime cstLDT = LocalDateTime.parse(map.get("CST"), arrFormat);
		LocalDateTime zstLDT = LocalDateTime.parse(map.get("ZST"), arrFormat);
		LocalDateTime astLDT = LocalDateTime.parse(map.get("AST"), arrFormat);
		
		//adding the LocalDateTime objects to the array
		array[0] = gmtLDT;
		array[1] = bstLDT;
		array[2] = cstLDT;
		array[3] = zstLDT;
		array[4] = astLDT;


		
		System.out.println("Print Style 1:");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("Print Style 3:");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("Print Style 5:");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}
}