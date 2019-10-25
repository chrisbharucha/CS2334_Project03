
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class DateTimeTwo {
	
	private LocalDate today; //calendar used for data
	private HashMap<LocalDate, Integer> map;
	
	
	public DateTimeTwo() {
		//initializing the local private variables
		today = LocalDate.now();
		map = new HashMap<>();
	}
	
	public void daysOfCurrentMonth() {
		//Creating a YearMonth to find the value of tenth and eighteenth day as an LocalDate object
		YearMonth ym = YearMonth.now();
		LocalDate tenthDay = ym.atDay(10);
		LocalDate eighteenthDay = ym.atDay(18);
		
		//calling getDayOfWeek() to convert LocalDate value to a String
		System.out.println("The tenth day of this month is " + tenthDay.getDayOfWeek() + " and eighteenth is " 
		+ eighteenthDay.getDayOfWeek());
	}
	
	public void daysOfAnyMonth(int month, int year) {
		//Creating a YearMonth to find the value of tenth and eighteenth day as an LocalDate object
		YearMonth ym = YearMonth.of(year, month);
		LocalDate fifteenthDay = ym.atDay(15);
		LocalDate lastDay;
		if (ym.lengthOfMonth() == 30) {
			lastDay = ym.atDay(30);
		}
		else if (ym.lengthOfMonth() == 29) {
			lastDay = ym.atDay(29);
		}
		else if (ym.lengthOfMonth() == 28) {
			lastDay = ym.atDay(29);
		}
		else {
			lastDay = ym.atDay(31);
		}
		//calling getDayOfWeek() to convert LocalDate value to a String
		System.out.println("For the year (" + year + ") and month (" + month + "), the fifteenth day"
				+ " is " + fifteenthDay.getDayOfWeek() + " and the last day is " + lastDay.getDayOfWeek());
	}
	
	public void compareYear() throws IOException {
		//format for changing String to LocalDate
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MM.dd.yyyy");
		
		//creating a BufferedReader to read in the Dates.txt
		BufferedReader br = new BufferedReader(new FileReader("Dates.txt"));
		
		//reading the first line of data and storing it in a String
		String dataLine = br.readLine();
		Integer value = 1;
		
		while (br.ready()) {
			LocalDate dataLineLDT = LocalDate.parse(dataLine, format);
			map.put(dataLineLDT, value++);
			dataLine = br.readLine();
		}
		//closing the BufferedReader
		br.close();
		
		for (LocalDate date : map.keySet()) {
			//Period variable used to find all the differences between dates
			Period differences = Period.between(today, date);
			
			if (!date.isLeapYear()) {
				System.out.println(date.getYear() + " is not a leap year, and Difference: " + 
						Math.abs(differences.getYears()) + " years, " + Math.abs(differences.getMonths()) +
						" months, and " + Math.abs(differences.getDays()) + " days.");
			}
			else {
				System.out.println(date.getYear() + " is a leap year, and Difference: " + 
						Math.abs(differences.getYears()) + " years, " + Math.abs(differences.getMonths()) + 
						" months, and " + Math.abs(differences.getDays()) + " days.");
			}
		}
	}
	
	public void dateHashMap() {
		
	}
	
	public void dateHashMapSorted() {
		
	}
}
