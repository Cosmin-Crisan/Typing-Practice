/**
 * 
 */
package interfaces;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author dan.nicoara
 * 
 * Creates arrays and manages array data. (TODO - SOLVED?)
 */
public interface ArrayManager {
	/**
	 * generate an array containing all letters for a number of alphabetMultiplier times
	 * 
	 * @param alphabetMultiplier - the number of times each letter is repeated in the array (TODO - SOLVED)
	 */
	public void setCharArray(int alphabetMultiplier);

	/**
	 * shuffle the array
	 *
	 * @param charArray
	 */
	 public void shuffleCharArray(char[] charArray);

	public void manageEvaluationData();

	/**
	 * create a new charMap and ads the chars to the map
	 */
	 public void setNewCharMap();

	public char[] getShuffledArray();

	public LinkedHashMap<String, Integer> getCharMap();

	public LinkedHashMap<String, Integer> getDividerMap();
}
