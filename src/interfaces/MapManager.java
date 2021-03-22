package interfaces;

import java.util.LinkedHashMap;
import java.util.Map;

public interface MapManager {
    /**
     * create a new charMap and add the chars to the map
     */
    default void setNewCharMap() {

    }

    void sortCharMap();

    LinkedHashMap<String, Integer> getSortedMap();


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

    LinkedHashMap<String, Integer> getCharMap();
    LinkedHashMap<String, Integer> getDividerMap();
}
