package bussinessLogic;

import interfaces.ArrayManager;
import interfaces.DataManager;
import interfaces.MapManager;

public class ManageData implements DataManager {
    private MapManager manageMap;
    private final ArrayManager manageArray;

    public ManageData(ArrayManager manageArray, MapManager manageMap) {
        this.manageArray = manageArray;
        this.manageMap = manageMap;
    }

    /**
     * prepare all the data necessary for the evaluation phase
     */
    public void manageEvaluationData() {
        this.manageArray.setEvaluationArray();
        this.manageArray.shuffleCharArray(manageArray.getEvaluationArray());
        this.manageMap = new ManageMap();
    }

    /**
     * prepare all the data necessary for the practice phase
     */
    public void managePracticeData() {
        this.manageMap.calculateAverage();
        this.manageMap.sortCharMap();
        this.manageArray.setCharArrayFromSortedMap();
        // reset the charMap to store new data
        this.manageMap = new ManageMap();
        this.manageArray.setPracticeArray();
        this.manageArray.shuffleCharArray(manageArray.getPracticeArray());
    }
}
