package bussinessLogic;

import interfaces.ArrayManager;
import interfaces.MapManager;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class ManageArray implements ArrayManager {
    // Random object for shuffling
    private static final Random RANDOM = new Random();
    // numberOfLetters in the alphabet
    private int numberOfLetters;
    // int for calculating how many times a letter is displayed in the evaluation
    // sequence
    private int alphabetMultiplier;
    // hash map for storing and recording the sorted chars
    private final MapManager manageMap;
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

    /**
     * constructor of the manageArray class
     *
     * @param manageMap
     */
    public ManageArray(MapManager manageMap) {
        this.manageMap = manageMap;
        this. numberOfLetters = Constants.NUMBER_OF_LETTERS;
        this.alphabetMultiplier = Constants.ALPHABETMULTIPLIER;
        this.evaluationArray = new char[numberOfLetters * alphabetMultiplier];
    }

    /**
     * generate an array containing all letters for a number of alphabetMultiplier times
     *
     */
    public void setEvaluationArray() {
        currentChar = 'a';

        for (int i = 0; i <= evaluationArray.length - alphabetMultiplier; i += alphabetMultiplier) {
            for (int k = i; k < i + alphabetMultiplier; k++) {
                evaluationArray[k] = currentChar;
            }
            currentChar++;
        }     System.out.println(Arrays.toString(evaluationArray));

    }

    /**
     * shuffle the array
     *
     * @param charArray
     */
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

    /**
     * transfer the sorted chars to a char array
     */
    public void setCharArrayFromSortedMap() {
        charArrayFromSortedMap = manageMap.getSortedMap().keySet().stream().map(String::valueOf).collect(Collectors.joining())
                .toCharArray();

    }

    /**
     * generate an array with characters repeating proportionally to the reaction
     * time for each char
     */
    public void setPracticeArray() {

        // calculate the size of the practiceArray
        int sizeOfPracticeArray = numberOfLetters * (numberOfLetters + 1) / 2;
        // create the array
        practiceArray = new char[sizeOfPracticeArray];
        int index = 0;

        //add the chars to the array depending on the reaction time (more chars for slower RT)
        for (int i = 0; i < charArrayFromSortedMap.length; i++) {
            for (int j = 0; j <= i; j++) {
                practiceArray[index] = charArrayFromSortedMap[i];
                index++;
            }
        }
    }

    /**
     * return the evaluation array
     */
    @Override
    public char[] getEvaluationArray() {
        return evaluationArray;
    }

    /**
     * return the shuffled array
     */
    @Override
    public char[] getShuffledArray() {
        return shuffledArray;
    }

    /**
     * return the practice array
     */
    @Override
    public char[] getPracticeArray(){return practiceArray;}


}
