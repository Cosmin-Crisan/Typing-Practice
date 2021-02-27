package bussinessLogic;

import interfaces.ArrayManager;

import java.util.LinkedHashMap;
import java.util.Random;

public class ManageArray implements ArrayManager {
    // Random object for shuffling
    private static final Random RANDOM = new Random();
    // the number of letters in the alphabet
    private final int numberOfLetters = 26;
    // int for calculating how many times a letter is displayed in the evaluation
    // sequence
    private int alphabetMultiplier = 2;
    // array for storing the letters needed in the evaluation phase
    private char[] evaluationArray;
    // array to store the shuffled letters
    private char[] shuffledArray;
    // create a string to store the chars when needed as string
    private String charString;
    // current char
    private char currentChar;
    // empty hash map for storing the alphabet and adding the reaction time for each
    // character
    private final LinkedHashMap<String, Integer> charMap = new LinkedHashMap<>();
    // hash map for storing the number of times a char is displayed (needed for
    // calculating the average)
    private final LinkedHashMap<String, Integer> dividerMap = new LinkedHashMap<>();
    // char for storing the current typed char


    public void manageEvaluationData() {
        setCharArray(alphabetMultiplier);
        shuffleCharArray(evaluationArray);
        setNewCharMap();
    }

    // generate an array containing all letters for a number of alphabetMultiplier times
    @Override
    public void setCharArray(int alphabetMultiplier) {
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

    // shuffle the array
    @Override
    public void shuffleCharArray(char[] charArray) {
        this.shuffledArray = charArray;
        int charArrayLength = shuffledArray.length;

        while (charArrayLength > 1) {
            int random = RANDOM.nextInt(charArrayLength--);
            char tmp = shuffledArray[random];
            shuffledArray[random] = shuffledArray[charArrayLength];
            shuffledArray[charArrayLength] = tmp;
        }
    }

    // creates a new charMap and ads the chars to the map
    @Override
    public void setNewCharMap() {
        // Add elements to the map
        currentChar = 'a';

        for (int i = 0; i < numberOfLetters; i++) {
            charString = Character.toString(currentChar);
            charMap.put(charString, 0);
            dividerMap.put(charString, 0);
            currentChar++;
        }
    }

    public LinkedHashMap<String, Integer> getCharMap() {
        return charMap;
    }

    public LinkedHashMap<String, Integer> getDividerMap() {
        return dividerMap;
    }

    public char[] getShuffledArray() {
        return shuffledArray;
    }


}
