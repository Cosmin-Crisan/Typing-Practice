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
     *
     */
    void manageEvaluationData();

    /**
     *
     */
    void managePracticeData();

    /**
     * generate an array containing all letters for a number of alphabetMultiplier times
     *
     * @param alphabetMultiplier - the number of times each letter is repeated in the array.
     */
    private void setCharArray(int alphabetMultiplier) {

    }

    /**
     * shuffle the array
     *
     * @param charArray - the array that needs to be shuffled
     */
    private void shuffleCharArray(char[] charArray) {

    }

    /**
     * return the shuffled array
     */
    char[] getShuffledArray();


}
