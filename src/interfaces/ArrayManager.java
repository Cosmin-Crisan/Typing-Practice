/**
 *
 */
package interfaces;

/**
 * @author dan.nicoara
 *
 * Creates arrays and manages array data.
 */
public interface ArrayManager {

    /**
     * generate an array containing all letters for a number of alphabetMultiplier times
     *
     * @param alphabetMultiplier - the number of times each letter is repeated in the array.
     */
    public void setEvaluationArray(int alphabetMultiplier);

    /**
     * shuffle the array
     *
     * @param charArray - the array that needs to be shuffled
     */
    public void shuffleCharArray(char[] charArray);

    /**
     * calculates the average time for each char
     */
    public void calculateAverage();

    /**
     * transfer the sorted chars to a char array
     */
    public void setCharArrayFromSortedMap();

    /**
     * generate an array with characters repeating proportionally to the reaction
     * time for each char
     */
    public void setPracticeArray();

    /**
     * return the evaluation array
     */
    public char[] getEvaluationArray();

    /**
     * return the shuffled array
     */
    public char[] getShuffledArray();

    /**
     * return the practice array
     */
    public char[] getPracticeArray();


}
