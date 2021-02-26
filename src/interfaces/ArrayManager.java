/**
 * 
 */
package interfaces;

/**
 * @author dan.nicoara
 * 
 * Manage arrays. (TODO - find a better comment here to write)
 */
public interface ArrayManager {
	/**
	 * generate an array containing all letters for a number of n times
	 * 
	 * @param size - the length of the array?! (TODO - clarify what is this
	 *             parameter)
	 */
	public void setCharArray(int size);

	/**
	 * shuffle the array
	 * 
	 * @param charArray
	 */
	public void shuffleCharArray(char[] charArray);

	/**
	 * creates a new charMap and ads the chars to the map
	 */
	public void setNewCharMap();
}
