import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MesoLexicographical extends MesoSortedAbstract
{
	private HashMap<String, Integer> unsorted;
	private Map<String, Integer> sorted;
	
	public MesoLexicographical(HashMap<String, Integer> unsorted) {
		//Initializing the classes local variables
		this.unsorted = unsorted;
		sorted = sortedMap(unsorted);
	}
	
	public Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted){
		//using TreeMap to sort
		TreeMap<String, Integer> sortedMap = new TreeMap<>(unsorted);
		for (String key : sortedMap.keySet()) {
			System.out.println(key);
		}
		return sortedMap;
	}
}