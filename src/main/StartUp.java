package main;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class StartUp {
    // the frame
    private Frame mainFrame;
    // label for displaying the letters
    private Label headerLabel;
    // label for displaying additional information
    private Label statusLabel;
    // add panel
    private Panel controlPanel;
    // array for storing the letters needed in the evaluation phase
    private char[] evaluationArray;
    // array for transferring the chars from the sorted map and displaying them on
    private char[] charArrayFromSortedMap;
    // array to store the shuffled letters
    private char[] shuffledArray;
    // array for storing the letters needed in the practice phase
    private char[] practiceArray;
    // Random object for shuffling
    private static final Random RANDOM = new Random();
    // int for accessing the index of an array
    private int charArrayIndex = 0;
    // int for calculating how many times a letter is displayed in the evaluation
    // sequence
    private int alphabetMultiplier = 2;
    // the number of letters in the alphabet
    private final int numberOfLetters = 26;
    private final TextField textField = new TextField(10);
    // generate a start and end Instant for calculating the elapsed time
    Instant start = Instant.now(), end = Instant.now();
    // create a string to store the chars when needed as string
    private String charString;
    // current char
    private char currentChar;
    // empty hash map for storing the alphabet and adding the reaction time for each
    // character
    private LinkedHashMap<String, Integer> charMap = new LinkedHashMap<>();
    // hash map for storing and recording the sorted chars
    private LinkedHashMap<String, Integer> sortedMap;
    // hash map for storing the number of times a char is displayed (needed for
    // calculating the average)
    private LinkedHashMap<String, Integer> dividerMap = new LinkedHashMap<>();
    // char for storing the current typed char
    private char typedChar;
    // int for storing the elapsed time
    private int time;

    // evaluate the typing speed for each character
    public StartUp() {
        prepareGUI();
        setCharArray(alphabetMultiplier);
        shuffleCharArray(evaluationArray);
        setNewCharMap();
        runEvaluation();

    }

    public static void main(String[] args) {
        new StartUp();
    }

    // prepare the GUI
    private void prepareGUI() {
        mainFrame = new Frame("Java AWT Examples");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        headerLabel = new Label();
        headerLabel.setAlignment(Label.CENTER);
        headerLabel.setFont(new Font("Serif", Font.PLAIN, 43));
        statusLabel = new Label();
        statusLabel.setAlignment(Label.CENTER);
        statusLabel.setSize(350, 100);

        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    // generate an array containing all letters for a number of n times
    private void setCharArray(int size) {
        this.alphabetMultiplier = size;
        evaluationArray = new char[numberOfLetters * alphabetMultiplier];
        char character = 'a';

        for (int i = 0; i <= evaluationArray.length - alphabetMultiplier; i += alphabetMultiplier) {
            for (int k = i; k < i + alphabetMultiplier; k++) {
                evaluationArray[k] = character;
            }
            character++;
        }
    }

    // shuffle the array
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

    // creates a new charMap and ads the chars to the map
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

    /*
     * generate an array with characters repeating proportionally to the reaction
     * time for each char
     */
    private void setPracticeArray(char[] array) {

        // calculate the size of the practiceArray
        int sizeOfPracticeArray = numberOfLetters * (numberOfLetters + 1) / 2;
        // create the array
        practiceArray = new char[sizeOfPracticeArray];
        // set index
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= i; j++) {
                practiceArray[index] = array[i];
                index++;
            }
        }
    }

    // sort the charMap in ascending order
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
            for (Entry<String, Integer> entry : charMap.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }
    }

    // transfer the sorted chars to a char array
    private void setCharArrayFromSortedMap() {
        charArrayFromSortedMap = sortedMap.keySet().stream().map(String::valueOf).collect(Collectors.joining())
                .toCharArray();

    }

    // calculates the reaction time
    private void calculateElapsedTime(Instant start, Instant end) {
        this.start = start;
        this.end = end;
        Duration timeElapsed = Duration.between(start, end);
        time = (int) timeElapsed.toMillis();
    }

    // ads the reaction time for the typed char
    private void addTimeToMap(int time) {
        this.time = time;
        charString = Character.toString(typedChar);
        int sum = charMap.get(charString) + time;
        charMap.put(charString, sum);
    }

    // how many times the time was added for the typed char
    private void addDividerToMap() {
        int divider = dividerMap.get(charString);
        charString = Character.toString(typedChar);
        dividerMap.put(charString, divider + 1);
    }

    // calculates the average time for each char
    private void calculateAverage() {
        currentChar = 'a';
        int average;

        for (int i = 0; i < numberOfLetters; i++) {
            charString = Character.toString(currentChar);
            average = charMap.get(charString) / dividerMap.get(charString);
            charMap.put(charString, average);
            currentChar++;
        }
    }

    private void runProgram(char[] array) {

        headerLabel.setText(String.valueOf(array[charArrayIndex]));

        textField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {

                typedChar = e.getKeyChar();
                end = Instant.now();

                if (typedChar == array[charArrayIndex] && charArrayIndex < array.length) {

                    calculateElapsedTime(start, end);
                    addTimeToMap(time);
                    addDividerToMap();
                    charArrayIndex++;

                    if (charArrayIndex >= array.length) {
                        headerLabel.setText("END OF EVALUATION");
                        textField.setText("");
                        textField.removeKeyListener(this);
                        // reset the index
                        charArrayIndex = 0;
                        runPractice();
                    } else {
                        headerLabel.setText(String.valueOf(array[charArrayIndex]));
                        textField.setText("");
                        start = Instant.now();
                    }
                }
            }
        });

        controlPanel.add(textField);
        mainFrame.setVisible(true);
        // automatically set the cursor on the textField
        textField.requestFocusInWindow();
    }

    // display the chars and evaluate the typing
    private void runEvaluation() {
        runProgram(shuffledArray);
    }

    private void runPractice() {
        calculateAverage();
        sortCharMap();
        setCharArrayFromSortedMap();
        // reset the charMap to store new data
        setNewCharMap();
        setPracticeArray(charArrayFromSortedMap);
        shuffleCharArray(practiceArray);
        runProgram(shuffledArray);
    }
}