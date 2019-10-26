import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class DateSortingUsingAlgorithm {

	private static final int SORTINGDATES_SIZE = 20;
	private HashMap<LocalDate, Integer> map; //HashMap used for sorting
	
	/*
	 * This class will use Insertion sort to sort the HashMap. The reason for choosing Insertion sort is that the 
	 * algorithm is fairly simple, and although it isn't the most efficient for big lists, the amount of stations
	 * that share the same ascii average value should not be very large (maybe 30 stations max).
	 */
	public DateSortingUsingAlgorithm() throws IOException {
		//initialize the classes local variables
		map = new HashMap<LocalDate, Integer>();
		String[] mapData = new String[3];
		
		//using a BufferedReader to read in data from the SortingDates.txt file
		BufferedReader br = new BufferedReader(new FileReader("SortingDates.txt"));
		
		//begin reading in the data from the file
		String dataLine = br.readLine().trim();
		
		//the format of the SortingDates.txt dates
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-dd-MM");
		Integer value = 0;
		String result = "";
		/*
		 * this while loop continues to read from the file while there is still data to read in. it 
		 * takes the data as a String and parses it into a LocalDate date using the formatter above. Lastly,
		 * it adds the LocalDate to the HashMap to be sorted later
		 */
		while (br.ready()) {
			mapData = dataLine.split("-");
			//using a for loop to trim any whitespace in the yyyy-dd-MM format
			mapData[].trim();
			}
			LocalDate mapDataLDT = LocalDate.parse(result, format);
			map.put(mapDataLDT, value++);
			dataLine = br.readLine();
		}
		br.close();
	}
	
	public void dateHashMapSortedDescending() {
		System.out.println("f");
	}
	
	public void dateHashMapSorted() {
		//the HashMap that contains the sorted keys
		HashMap<LocalDate, Integer> sortedMap = new HashMap<>();
		//array used to store the key values of the unsorted HashMap
		LocalDate[] unsortedArr = new LocalDate[SORTINGDATES_SIZE];
	
		//adding all the keys to unsortedArr
		int i = 0;
		for (LocalDate key : map.keySet()) {
				unsortedArr[i++] = key;
			}
		
		for (int currIndex = 1; currIndex < unsortedArr.length; currIndex++) {
			LocalDate date = unsortedArr[currIndex];
			int k = currIndex - 1;
				
			/*
			 * while the index for the array stays above 0 and the element in the previous
			 * index is greater than the element at the currentIndex
			 */
			while (k >= 0 && unsortedArr[k].isAfter(date)) {
				//shifting the elements to the right
				unsortedArr[k + 1] = unsortedArr[k];
				//decrement x to test the next case
				k = k - 1;	
			}
			unsortedArr[k + 1] = date;
		}
		
		for (i = 0; i < unsortedArr.length; ++i) {
			sortedMap.put(unsortedArr[i], i);
		}
		
		for (LocalDate key : sortedMap.keySet()) {
			System.out.println(key.toString());
		}
	}
	
}
