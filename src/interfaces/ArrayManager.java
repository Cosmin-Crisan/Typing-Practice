/**
 *
 */
package interfaces;

/**
 * @author dan.nicoara
 *
 * Creates arrays and manages array data. (TODO - SOLVED?)
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
     * @param alphabetMultiplier - the number of times each letter is repeated in the array (TODO - SOLVED)
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
     * calculates the average time for each char
     */
    void calculateAverage();

    /**
     * sort the charMap in ascending order
     */
    void sortCharMap();

    /**
     * transfer the sorted chars to a char array
     */
    void setCharArrayFromSortedMap();

    /**
     * generate an array with characters repeating proportionally to the reaction
     * time for each char
     */
    void setPracticeArray();

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
