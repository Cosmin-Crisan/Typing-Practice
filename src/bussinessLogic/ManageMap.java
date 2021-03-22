package bussinessLogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ManageMap {
    // current char
    private char currentChar;
    // the number of letters in the alphabet
    private final int numberOfLetters = 3;
    // create a string to store the chars when needed as string
    private String charString;
    // empty hash map for storing the alphabet and adding the reaction time for each
    // character
    private final LinkedHashMap<String, Integer> charMap = new LinkedHashMap<>();
    // hash map for storing the number of times a char is displayed (needed for
    // calculating the average)
    private final LinkedHashMap<String, Integer> dividerMap = new LinkedHashMap<>();

    private LinkedHashMap<String, Integer> sortedMap;

    /**
     * creates a new charMap and ads the chars to the map
     */
    private void setNewCharMap() {
        // Add elements to the map
        currentChar = 'a';

        for (int i = 0; i < numberOfLetters; i++) {
            charString = Character.toString(currentChar);
            charMap.put(charString, 0);
            dividerMap.put(charString, 0);
            currentChar++;
        }
    }

    /**
     * sort the charMap in ascending order
     */
    private void sortCharMap() {
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
     * @param typedChar
     */

    public void addDividerToMap(char typedChar) {
        int divider = dividerMap.get(charString);
        charString = Character.toString(typedChar);
        dividerMap.put(charString, divider + 1);
    }

    /**
     * add the reaction time for the typed char
     * @param elapsedTime
     * @param typedChar
     */
    public void addTimeToMap(int elapsedTime, char typedChar) {
        charString = Character.toString(typedChar);
        int sum = charMap.get(charString) + elapsedTime;
        charMap.put(charString, sum);
    }

    public LinkedHashMap<String, Integer> getSortedMap(){
        return sortedMap;
    }
    public LinkedHashMap<String, Integer> getCharMap(){
        return charMap;
    }
    public LinkedHashMap<String, Integer> getDividerMap(){
        return dividerMap;
    }
}
