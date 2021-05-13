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

    // hash map for storing the alphabet and adding the reaction time for each
    // character
    LinkedHashMap<String, LetterAttributes> map = new LinkedHashMap<>();
    // array for storing the letters relative to the reaction time in ascending order
    private char[] rankingArray;

    /**
     * creates a new charMap and ads the chars to the map
     */
    public void setNewCharMap() {
        String charString;
        // Add elements to the map
        char currentChar = 'a';

        for (int i = 0; i < Constants.NUMBER_OF_LETTERS; i++) {
            charString = Character.toString(currentChar);
            map.put(charString, new LetterAttributes(0, 0));
            currentChar++;
        }
    }

    /**
     * transfers the chars from map to rankingArray and
     * arranges each char relative to its correlated reaction time
     */
    public void rankChars() {

        rankingArray = new char[map.size()];
        int index = 0;
        // arrayList for storing and sorting the chars relative to the typing speed
        ArrayList<Integer> charList = new ArrayList<>();
        // transfer the chars from charMap to charList
        for (Map.Entry<String, LetterAttributes> entry : map.entrySet()) {
            LetterAttributes la = map.get(entry.getKey());
            charList.add(la.getTime());
        }
        // rank the chars by typing speed (fastest to slowest)
        Collections.sort(charList);
        // transfer the keys corresponding to the sorted list values to rankingArray
        for (int num : charList) {
            for (Map.Entry<String, LetterAttributes> entry : map.entrySet()) {
                LetterAttributes la = map.get(entry.getKey());
                if (la.getTime() == (num)) {
                    rankingArray[index] = entry.getKey().charAt(0);
                    index++;
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
        LetterAttributes la = map.get(typedCharacter);
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
        LetterAttributes la = map.get(typedCharacter);
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
            LetterAttributes la = map.get(charString);
            averageTime = la.getTime() / la.getCount();
            la.setTime(averageTime);
            currentChar++;
        }
    }


    /**
     * @return - returns the rankingArray
     */
    public char[] getRankingArray() {
        return rankingArray;
    }

}
