package interfaces;

/**
 * @author cosmin.crisan
 *
 * Creates maps and manages map data.
 */

import java.util.LinkedHashMap;

public interface MapManager {
    /**
     * create a new charMap and add the chars to the map
     */
    void setNewCharMap();

    /**
     * sort the charMap in ascending order
     */
    void sortCharMap();

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
     * @param typedChar   - the char that was received as input in the last keystroke
     */
    void addTimeToMap(int elapsedTime, char typedChar);

    /**
     * calculates the average time for each char
     */
    public void calculateAverage();

    /**
     * return the sortedMap
     */
    LinkedHashMap<String, Integer> getSortedMap();

    /**
     * return the charMap
     */
    LinkedHashMap<String, Integer> getCharMap();

    /**
     * return the dividerMap
     */
    LinkedHashMap<String, Integer> getDividerMap();
}
