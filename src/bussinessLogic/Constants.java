package bussinessLogic;

import interfaces.ConstantsInterface;

public class Constants implements ConstantsInterface {
    // the number of letters in the alphabet
    final int numberOfLetters = 3;
    // int for calculating how many times a letter is displayed in the evaluation
    // sequence
    private int alphabetMultiplier = 1;

    public int getNumberOfLetters(){
        return numberOfLetters;
    }
    public int getAlphabetMultiplier(){
        return alphabetMultiplier;
    }
}
