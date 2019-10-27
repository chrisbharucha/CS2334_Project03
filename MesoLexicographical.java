import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MesoLexicographical extends MesoSortedAbstract
{
	protected Map<String, Integer> notSorted;
	
	public MesoLexicographical(HashMap<String, Integer> unsorted) {
		this.notSorted = sortedMap(unsorted); //method call returns a sorted HashMap
	}
	
	public Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted){
		TreeMap<String, Integer> sorted = new TreeMap<String, Integer>(unsorted);
		for (String key : sorted.keySet()) {
			System.out.println(key);
		}
		return sorted;
	}
}