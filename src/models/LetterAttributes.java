/**
 * 
 */
package models;

/**
 * @author dan.nicoara
 *
 *         Stores the Letter Attributes.
 */
public class LetterAttributes {
	/**
	 * Counts the number of times the letter is typed.
	 */
	private int Count;

	/**
	 * Stores the elapsed time between displaying the character and typing it.
	 */
	private int Time;

	/**
	 * Constructor. Initializes the object with the two properties.
	 * 
	 * @param {int} count
	 * @param {int} time
	 */
	public LetterAttributes(int count, int time) {
		this.Count = count;
		this.Time = time;
	}

	/**
	 * Return Count
	 * 
	 * @return Count
	 */
	public int getCount() {
		return this.Count;
	}

	/**
	 * Return Time
	 * 
	 * @return Time
	 */
	public int getTime() {
		return this.Time;
	}

	/**
	 * Set Count
	 */
	public void setCount(int count) {
		this.Count = count;
	}

	/**
	 * Set Time
	 */
	public void setTime(int time) {
		this.Time = time;
	}
}