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
