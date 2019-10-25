
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Calendar;

public class DateTimeTwo {
	
	private Calendar calendar; //calendar used for data
	
	public DateTimeTwo() {
		//initializing the local private variables
		calendar = Calendar.getInstance();
	}
	
	public void daysOfCurrentMonth() {
		//Creating a YearMonth to find the value of tenth and eighteenth day as an int
		YearMonth ym = YearMonth.now();
		LocalDate tenthDay = ym.atDay(10);
		LocalDate eighteenthDay = ym.atDay(18);
		
		//calling getDayOfWeek() to convert int value to a String
		System.out.println("The tenth day of this month is " + tenthDay.getDayOfWeek() + " and eighteenth is " + eighteenthDay.getDayOfWeek());
	}
	
	public void daysOfAnyMonth(int month, int year) {
		
		
		
		System.out.println("For the year (" + year + ") and month (" + month + "), the fifteenth day"
				+ " is " + fifteenthDay + " and the last day is " + lastDay;
	}
	
	public void compareYear() {
		
	}
	
	public void dateHashMap() {
		
	}
	
	public void dateHashMapSorted() {
		
	}
}
