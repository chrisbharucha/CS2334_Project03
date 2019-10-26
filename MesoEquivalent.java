import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MesoEquivalent {

	private String stID; //the given stID from main
	private int stIDAvg; //the average ascii value of stID
	private ArrayList<String> stArray; //used to store the stID's from Mesonet.txt
	private HashMap<String, Integer> mapID; //used to store the stID's that have the same ascii average
	
	public MesoEquivalent(String stID) throws IOException {
		//initializing the local class variables
		this.stID = stID;
		stIDAvg = 0;
		stArray = new ArrayList<>();
		mapID = new HashMap<>();
		
		//creating a BufferedReader to read in the Mesonet.txt file
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		
		//reading through the first three lines in the Mesonet.txt that don't contain data
		for (int i = 0; i < 3; ++i) {
			br.readLine();
		}
		//first line of actual data
		String dataLine = br.readLine();
		
		while (dataLine != null) {
			String info = dataLine.split("\\s+")[1]; //we want the first index because [0] is a whitespace
			stArray.add(info); //add it to the ArrayList
			dataLine = br.readLine();
		}
		br.close();
	}
	
	public HashMap<String, Integer> calAsciiEqual() {
		/*
		 * The next three lines of code use the given stID passed in from main to calculate the average value
		 * used for comparing to the Mesonext.txt stations
		 */
		MesoStation stationID = new MesoStation(stID);
		MesoAsciiCal asciiCalID = new MesoAsciiCal(stationID);
		stIDAvg = asciiCalID.calAverage();
		
		for (int index = 0; index < stArray.size(); ++index) {
			/*
			 * The next three lines of code use other classes already created and the stID's from Mesonet.txt
			 * to 1) create a MesoStation object, 2) use that MesoStation object to create a asciiCal object, 3)
			 * use that asciiCal object's calAverage method to calculate the average
			 */
			MesoStation stationAtIndex = new MesoStation(stArray.get(index)); 
			MesoAsciiCal asciiCal = new MesoAsciiCal(stationAtIndex);
			int stationAvg = asciiCal.calAverage(); 
			
			//now if the two averages are equal, take the stID from the arrayList and add it to the HashMap
			if (stIDAvg == stationAvg) {
				mapID.put(stArray.get(index), stIDAvg);
			}
		}
		return mapID;
	}
	
	@Override
	public String toString() {
		int i = 0;
		String result = "{";
		for (String stIDs : mapID.keySet()) {
			if (i++ == mapID.size() - 1) {
				result += (stIDs + "=" + mapID.get(stIDs));
			}
			else {
				result += (stIDs + "=" + mapID.get(stIDs) + ", ");
			}
		}
		result += "}";
		return result;
	}
	
}
