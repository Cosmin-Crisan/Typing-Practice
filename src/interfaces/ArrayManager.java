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
    void setCharArray(int alphabetMultiplier);

    /**
     * shuffle the array
     *
     * @param charArray - the array that needs to be shuffled
     */
    void shuffleCharArray(char[] charArray);

    /**
     * create a new charMap and add the chars to the map
     */
    void setNewCharMap();

    /**
     * return the shuffled array
     */
    char[] getShuffledArray();

    /**
     * calculate how many times a char was deployed and store the result in a hashmap
     *
     * @param typedChar - the char that was received as input in the last keystroke
     */
    void addDividerToMap(char typedChar);

    /**
     * add the reaction time for the typed char
     *
     * @param elapsedTime - the time that elapsed between
     * @param typedChar - the char that was received as input in the last keystroke
     */
    void addTimeToMap(int elapsedTime, char typedChar);

}
