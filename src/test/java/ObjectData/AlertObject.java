package ObjectData;

import java.util.HashMap;

public class AlertObject {

    private String interractAlertValue;

    public String getInterractAlertValue() {
        return interractAlertValue;
    }

    public void setInterractAlertValue(String interractAlertValue) {
        this.interractAlertValue = interractAlertValue;
    }

    public AlertObject(HashMap<String,String> testData){
        populateObject(testData);
    }

    private void populateObject(HashMap<String, String> testData) {
        for (String Key : testData.keySet()) {
            switch (Key) {
                case "interractAlertValue":
                    setInterractAlertValue(testData.get(Key));
                    break;
            }
        }
    }
}
