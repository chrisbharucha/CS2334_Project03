import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MesoLexicographical extends MesoSortedAbstract
{
	private Map<String, Integer> unsorted;
	
	public MesoLexicographical(HashMap<String, Integer> unsorted) {
		//Initializing the classes local variables
		this.unsorted = sortedMap(unsorted);
	}
	
	public Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted){
		//using TreeMap to sort
		TreeMap<String, Integer> sortedMap = new TreeMap<>(unsorted);
		int i = 0;
		for (String key : sortedMap.keySet()) {
			unsorted.put(key, i++);
			System.out.println(key);
		}
		return unsorted;
	}
}