import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;


public class DateTimeOne extends MesoDateTimeOneAbstract
{

	private static final int MILLI_CONSTANT = 1000;
	Calendar calendar; //calendar used for data
	Date today; //date used for different TimeZones
	HashMap<String, String> map;
	HashMap<String, String> noZoneMap;
	
	
	public DateTimeOne() {
		//initializing the calendar and HashMap
		calendar = Calendar.getInstance();
		today = new Date();
		map = new HashMap<>();
		noZoneMap = new HashMap<>();
	}
	
	public int getValueOfSecond() {
		//using the milli conversion factor to get time in seconds as a long
		long sec = (System.currentTimeMillis() / MILLI_CONSTANT);
		
		/* finding the current second by taking the long and finding its remainder of 60 (this is
		 * also the return value)
		 */
		int currentSec = (int)(sec % 60);
		
		System.out.println("The value of Second now: " + currentSec);
		return currentSec;
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
		
		//printing out default TimeZone
		System.out.println("Time on Server: " + hourFormat.format(today));
		
		//changing to GMT TimeZone and printing
		hourFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		System.out.println("GMT: " + hourFormat.format(today));
		
		//changing to BST TimeZone and printing
		hourFormat.setTimeZone(TimeZone.getTimeZone("BST"));
		System.out.println("BST (90E): " + hourFormat.format(today));
		
		//changing to CST TimeZone and printing
		hourFormat.setTimeZone(TimeZone.getTimeZone("CST"));
		System.out.println("CST (90W): " + hourFormat.format(today));
	}
	
	public void dateTimeDifferentZone() {
		//format for the date output of other timeZone is as follows:
		SimpleDateFormat zoneDateFormat = new SimpleDateFormat("MM/dd/yyyy k:mm");
		
		//changing to GMT TimeZone, adding to HashMap and printing
		zoneDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		String gmtValue = zoneDateFormat.format(today);
		map.put("GMT", gmtValue);
		System.out.println("GMT: " + zoneDateFormat.format(today));
				
		//changing to BST TimeZone, adding to HashMap and printing
		zoneDateFormat.setTimeZone(TimeZone.getTimeZone("BST"));
		String bstValue = zoneDateFormat.format(today);
		map.put("BST", bstValue);
		System.out.println("BST: " + zoneDateFormat.format(today));
				
		//changing to CST TimeZone, adding to HashMap and printing
		zoneDateFormat.setTimeZone(TimeZone.getTimeZone("CST"));
		String cstValue = zoneDateFormat.format(today);
		map.put("CST", cstValue);
		System.out.println("CST: " + zoneDateFormat.format(today));
	}
	
	public void timeZoneHashMap() {
		//adding two new time zones and their dates to the first HashMap
		map.put("ZST", "11/05/2018 19:59");
		map.put("AST", "10/01/2020 19:59");
		
		/* adding the contents of the first HashMap to the new one, using the values from first HashMap
		 * as the keys for the new HashMap
		 */
		noZoneMap.put(map.get("GMT"), "");
		noZoneMap.put(map.get("BST"), "");
		noZoneMap.put(map.get("CST"), "");
		noZoneMap.put(map.get("ZST"), "");
		noZoneMap.put(map.get("AST"), "");
		
		//declaring an array to store the values of the first HashMap
		LocalDateTime[] array = new LocalDateTime[map.size()];
		
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
		
		//creating a sortedMap using the keys in map HashMap
		TreeMap<String, String> sortedMap = new TreeMap<>(map);
		
		System.out.println("Print Style 1:");
		for (String date : sortedMap.keySet()) {
			System.out.println(date + " " + sortedMap.get(date));
		}
		
		//creating a sortedNoZoneMap using the keys in noZoneMap HashMap
		TreeMap<String, String> sortedNoZoneMap = new TreeMap<>(noZoneMap);
		System.out.println("Print Style 3:");
		for (String date : sortedNoZoneMap.keySet()) {
			System.out.println(date + " " + sortedNoZoneMap.get(date));
		}
		
		//sorting the array contents in descending order
		Arrays.sort(array, Collections.reverseOrder());
		System.out.println("Print Style 5: Final sorted Array:");
		for (int i = 0; i < array.length; ++i) {
			System.out.println(array[i]);
		}
	}
}