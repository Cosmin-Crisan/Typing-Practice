package bussinessLogic;

import interfaces.ArrayManager;
import interfaces.MapManager;

import java.util.Arrays;
import java.util.Random;

public class ManageArray implements ArrayManager {
    // Random object for shuffling
    private static final Random RANDOM = new Random();
    // hash map for storing and recording the sorted chars
    private final MapManager manageMap;
    // array for storing the letters needed in the evaluation phase
    private final char[] evaluationArray = new char[Constants.NUMBER_OF_LETTERS * Constants.ALPHABETMULTIPLIER];
    // array to store the shuffled letters
    private char[] shuffledArray;
    // array for transferring the chars from the sorted map and displaying them on
    // private char[] charArrayFromSortedMap;
    // array for storing the letters needed in the practice phase
    private char[] practiceArray;
    // create a string to store the chars when needed as string
    private String charString;

    /**
     * constructor of the manageArray class
     *
     * @param manageMap
     */
    public ManageArray(MapManager manageMap) {
        this.manageMap = manageMap;
    }

    /**
     * generate an array containing all letters for a number of alphabetMultiplier times
     */
    public void setEvaluationArray() {
        char currentChar = 'a';

        for (int i = 0; i <= evaluationArray.length - Constants.ALPHABETMULTIPLIER; i += Constants.ALPHABETMULTIPLIER) {
            for (int k = i; k < i + Constants.ALPHABETMULTIPLIER; k++) {
                evaluationArray[k] = currentChar;
            }
            currentChar++;
        }
        System.out.println(Arrays.toString(evaluationArray));

    }

    /**
     * shuffle the array
     *
     * @param charArray - the array that needs to be shuffled
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
     * generate an array with characters repeating proportionally to the reaction
     * time for each char
     */
    public void setPracticeArray() {
        char[] rankingArray = manageMap.getRankingArray();
        // calculate the size of the practiceArray
        int sizeOfPracticeArray = Constants.NUMBER_OF_LETTERS * (Constants.NUMBER_OF_LETTERS + 1) / 2;
        // create the array
        practiceArray = new char[sizeOfPracticeArray];
        int index = 0;

        //add the chars to the array depending on the reaction time (more chars for slower RT)
        for (int i = 0; i < rankingArray.length; i++) {
            for (int j = 0; j <= i; j++) {
                practiceArray[index] = rankingArray[i];
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
    public char[] getPracticeArray() {
        return practiceArray;
    }


}
