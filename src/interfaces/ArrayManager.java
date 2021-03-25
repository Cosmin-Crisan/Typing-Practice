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
     * prepare all the data necessary for the practice phase
     */
    void managePracticeData();

    /**
     * generate an array containing all letters for a number of alphabetMultiplier times
     *
     * @param alphabetMultiplier - the number of times each letter is repeated in the array.
     */
    public default void setEvaluationArray(int alphabetMultiplier) {

    }

    /**
     * shuffle the array
     *
     * @param charArray - the array that needs to be shuffled
     */
    public default void shuffleCharArray(char[] charArray) {

    }

    /**
     * return the evaluation array
     */
    public char[] getEvaluationArray();

    /**
     * return the shuffled array
     */
    char[] getShuffledArray();


}
