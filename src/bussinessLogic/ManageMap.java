/*
 * 
 * key = letter
 * value = (count, time)
 * 
 * LM = (key, value) -> (letter, (count, time))
 * 
 * 
 * 
 * TODO - Example of thod to write.
 * public LinkedHashMap<String, LetterAttributes> calculateAverage(LinkedHashMap<String, LetterAttributes> map) {
 * sort algorithm.
 * }
 * 
 * */


package bussinessLogic;

import interfaces.MapManager;
import models.LetterAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ManageMap implements MapManager {

    // empty hash map for storing the alphabet and adding the reaction time for each
    // character
    // LinkedHashMap<String, Integer> charMap = new LinkedHashMap<>();
    // hash map for storing the number of times a char is displayed (needed for
    // calculating the average)
    LinkedHashMap<String, Integer> dividerMap = new LinkedHashMap<>();
    LinkedHashMap<String, Integer> sortedMap;

    // TODO - use this instead of charMap, dividerMap and sortedMap.
    LinkedHashMap<String, LetterAttributes> map = new LinkedHashMap<>();
    LetterAttributes la =  (LetterAttributes)map.get("a");
    /**
     *
     *  map.put("a", new LetterAttributes(0, 0));
    	map.put("b", new LetterAttributes(0, 0));
    	map.put("c", new LetterAttributes(0, 0));

    	LetterAttributes la =  (LetterAttributes)map.get("a");
     */

    /**
     * creates a new charMap and ads the chars to the map
     */
    public void setNewCharMap() {
    	String charString;
        // Add elements to the map
        char currentChar = 'a';

        for (int i = 0; i < Constants.NUMBER_OF_LETTERS; i++) {
            charString = Character.toString(currentChar);
            // charMap.put(charString, 0);
            map.put(charString, new LetterAttributes(0, 0));
            dividerMap.put(charString, 0);
            currentChar++;
        }
    }

    /**
     * sort the charMap in ascending order
     */
    public void sortCharMap() {
        // generate a new, empty sortedMap
        sortedMap = new LinkedHashMap<>();
        // arrayList for storing and sorting the chars
        ArrayList<Integer> charList = new ArrayList<>();
        // transfer the chars from charMap to charList
        for (Map.Entry<String, Integer> entry : charMap.entrySet()) {
            charList.add(entry.getValue());
        }
        // rank the chars by typing speed (fastest to slowest)
        Collections.sort(charList);
        // transfer the ranked list to sortedMap
        for (int num : charList) {
            for (Map.Entry<String, Integer> entry : charMap.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }
    }


    /**
     * calculate how many times a char was deployed and store the result in a hashmap
     *
     * @param typedChar
     */

    public void addDividerToMap(char typedChar) {
    	String typedCharacter = Character.toString(typedChar);
        LetterAttributes la =  (LetterAttributes)map.get(typedCharacter);
        int divider = la.getCount();
        la.setCount(divider + 1);
    }

    /**
     * add the reaction time for the typed char
     *
     * @param elapsedTime
     * @param typedChar
     */
    public void addTimeToMap(int elapsedTime, char typedChar) {
        String typedCharacter = Character.toString(typedChar);
        LetterAttributes la =  (LetterAttributes)map.get(typedCharacter);
        int sum = la.getTime() + elapsedTime;
        la.setTime(sum);
    }

    /**
     * calculates the average time for each char and stores it in charMap
     */
    public void calculateAverage() {
    	String charString;
        char currentChar = 'a';
        int averageTime;

        for (int i = 0; i < Constants.NUMBER_OF_LETTERS; i++) {
            charString = Character.toString(currentChar);
            LetterAttributes la =  (LetterAttributes)map.get(charString);
            averageTime = la.getTime() / la.getCount();
            la.setTime(averageTime);
            currentChar++;
        }
    }

    /**
     * getter method to return the sorted map
     *
     * @return
     */
    public LinkedHashMap<String, Integer> getSortedMap() {
        return sortedMap;
    }

    /**
     * getter method to return the charMap
     *
     * @return
     */
    public LinkedHashMap<String, Integer> getCharMap() {
        return charMap;
    }

    /**
     * getter method to return the dividerMap
     *
     * @return
     */
    public LinkedHashMap<String, Integer> getDividerMap() {
        return dividerMap;
    }
}
