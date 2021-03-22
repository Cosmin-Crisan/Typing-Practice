package bussinessLogic;

import interfaces.ArrayManager;
import interfaces.MapManager;

import java.util.*;
import java.util.stream.Collectors;

public class ManageArray implements ArrayManager {
    // Random object for shuffling
    private static final Random RANDOM = new Random();
    // the number of letters in the alphabet
    private final int numberOfLetters = 3;
    // empty hash map for storing the alphabet and adding the reaction time for each
    // character
    private final LinkedHashMap<String, Integer> charMap = new LinkedHashMap<>();
    // hash map for storing the number of times a char is displayed (needed for
    // calculating the average)
    private final LinkedHashMap<String, Integer> dividerMap = new LinkedHashMap<>();
    // int for calculating how many times a letter is displayed in the evaluation
    // sequence
    private int alphabetMultiplier = 1;
    // array for storing the letters needed in the evaluation phase
    private char[] evaluationArray;
    // array to store the shuffled letters
    private char[] shuffledArray;
    // array for transferring the chars from the sorted map and displaying them on
    private char[] charArrayFromSortedMap;
    // array for storing the letters needed in the practice phase
    private char[] practiceArray;
    // create a string to store the chars when needed as string
    private String charString;
    // current char
    private char currentChar;
    // hash map for storing and recording the sorted chars
    private static MapManager manageMap = new MapManager() {
        @Override
        public void sortCharMap() {

        }

        @Override
        public LinkedHashMap<String, Integer> getSortedMap() {
            return null;
        }

        @Override
        public void addDividerToMap(char typedChar) {

        }

        @Override
        public void addTimeToMap(int elapsedTime, char typedChar) {

        }

        @Override
        public LinkedHashMap<String, Integer> getCharMap() {
            return null;
        }

        @Override
        public LinkedHashMap<String, Integer> getDividerMap() {
            return null;
        }
    };

    /**
     * prepare all the data necessary for the evaluation phase
     */
    public void manageEvaluationData() {
        setCharArray(alphabetMultiplier);
        shuffleCharArray(evaluationArray);
        manageMap.setNewCharMap();
    }

    /**
     * prepare all the data necessary for the evaluation phase 
     */
    public void managePracticeData() {
        calculateAverage();
        manageMap.sortCharMap();
        setCharArrayFromSortedMap();
        // reset the charMap to store new data
        manageMap.setNewCharMap();
        setPracticeArray();
        shuffleCharArray(practiceArray);
    }

    /**
     * generate an array containing all letters for a number of alphabetMultiplier times
     * @param alphabetMultiplier
     */
    private void setCharArray(int alphabetMultiplier) {
        this.alphabetMultiplier = alphabetMultiplier;
        evaluationArray = new char[numberOfLetters * alphabetMultiplier];
        currentChar = 'a';

        for (int i = 0; i <= evaluationArray.length - alphabetMultiplier; i += alphabetMultiplier) {
            for (int k = i; k < i + alphabetMultiplier; k++) {
                evaluationArray[k] = currentChar;
            }
            currentChar++;
        }
    }

    /**
     * shuffle the array
     * @param charArray
     */
    private void shuffleCharArray(char[] charArray) {
        this.shuffledArray = charArray;
        int charArrayLength = shuffledArray.length;

        while (charArrayLength > 1) {
            int random = RANDOM.nextInt(charArrayLength--);
            char tmp = shuffledArray[random];
            shuffledArray[random] = shuffledArray[charArrayLength];
            shuffledArray[charArrayLength] = tmp;
        }
    }

    /**
     * calculates the average time for each char
     */
    private void calculateAverage() {
        currentChar = 'a';
        int average;

        for (int i = 0; i < numberOfLetters; i++) {
            charString = Character.toString(currentChar);
            average = manageMap.getCharMap().get(charString) / manageMap.getDividerMap().get(charString);
            charMap.put(charString, average);
            currentChar++;
        }
    }



    /**
     * transfer the sorted chars to a char array
     */
    private void setCharArrayFromSortedMap() {
        charArrayFromSortedMap = manageMap.getSortedMap().keySet().stream().map(String::valueOf).collect(Collectors.joining())
                .toCharArray();

    }

    /**
     * generate an array with characters repeating proportionally to the reaction
     * time for each char
     */
    private void setPracticeArray() {

        // calculate the size of the practiceArray
        int sizeOfPracticeArray = numberOfLetters * (numberOfLetters + 1) / 2;
        // create the array
        practiceArray = new char[sizeOfPracticeArray];
        // set index
        int index = 0;

        for (int i = 0; i < charArrayFromSortedMap.length; i++) {
            for (int j = 0; j <= i; j++) {
                practiceArray[index] = charArrayFromSortedMap[i];
                index++;
            }
        }
    }

    /**
     * return the shuffled array
     */
    @Override
    public char[] getShuffledArray() {
        return shuffledArray;
    }


}
