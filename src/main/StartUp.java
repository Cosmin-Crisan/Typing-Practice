package main;
import bussinessLogic.ManageArray;
import bussinessLogic.ManageData;
import bussinessLogic.ManageMap;
import interfaces.ArrayManager;
import interfaces.DataManager;
import interfaces.MapManager;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.Duration;
import java.time.Instant;

public class StartUp {
    private static final MapManager manageMap = new ManageMap();
    private static final ArrayManager manageArray = new ManageArray(manageMap);
    private static final DataManager manageData = new ManageData(manageArray, manageMap);

    private static final TextField textField = new TextField(10);
    // generate a start and end Instant for calculating the elapsed time
    static Instant start = Instant.now(), end = Instant.now();
    // the frame
    private static Frame mainFrame;
    // label for displaying the letters
    private static Label headerLabel;
    // add panel
    private static Panel controlPanel;
    // int for accessing the index of an array
    private static int charArrayIndex = 0;

    public static void main(String[] args) {
        prepareGUI();
        // evaluate the typing speed for each character
        runEvaluation();
    }

    // prepare the GUI
    private static void prepareGUI() {
        mainFrame = new Frame("Typing Practice");
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
        // label for displaying additional information
        Label statusLabel = new Label();
        statusLabel.setAlignment(Label.CENTER);
        statusLabel.setSize(350, 100);

        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }


    // calculates the reaction time
    private static int calculateElapsedTime(Instant start, Instant end) {
        Duration timeElapsed = Duration.between(start, end);
        return (int) timeElapsed.toMillis();
    }


    private static void runProgram(char[] array) {
        //display the text that needs to be typed
        headerLabel.setText(String.valueOf(array[charArrayIndex]));

        textField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {

                char typedChar = e.getKeyChar();
                end = Instant.now();

                if (typedChar == array[charArrayIndex]) {

                    manageMap.addTimeToMap(calculateElapsedTime(start, end), typedChar);
                    manageMap.addDividerToMap(typedChar);
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
    private static void runEvaluation() {
        manageData.manageEvaluationData();
        runProgram(manageArray.getShuffledArray());
    }

    private static void runPractice() {
        manageData.managePracticeData();
        runProgram(manageArray.getShuffledArray());
    }
}