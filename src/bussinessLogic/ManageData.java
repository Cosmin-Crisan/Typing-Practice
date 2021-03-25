package bussinessLogic;

import interfaces.ArrayManager;
import interfaces.DataManager;
import interfaces.MapManager;

public class ManageData implements DataManager {
    private final MapManager manageMap;
    private final ArrayManager manageArray;
    // int for calculating how many times a letter is displayed in the evaluation
    // sequence
    private int alphabetMultiplier = 1;

    public ManageData(ArrayManager manageArray, MapManager manageMap) {
        this.manageArray = manageArray;
        this.manageMap = manageMap;
    }

    /**
     * prepare all the data necessary for the evaluation phase
     */
    public void manageEvaluationData() {
        manageArray.setEvaluationArray(alphabetMultiplier);
        manageArray.shuffleCharArray(manageArray.getEvaluationArray());
        manageMap.setNewCharMap();
    }
}
