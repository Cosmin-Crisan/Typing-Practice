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
     */
    void setEvaluationArray();

    /**
     * shuffle the array
     *
     * @param charArray - the array that needs to be shuffled
     */
    void shuffleCharArray(char[] charArray);

    /**
     * generate an array with characters repeating proportionally to the reaction
     * time for each char
     */
    void setPracticeArray();

    /**
     * return the evaluation array
     */
    char[] getEvaluationArray();

    /**
     * return the shuffled array
     */
    char[] getShuffledArray();

    /**
     * return the practice array
     */
    char[] getPracticeArray();


}
