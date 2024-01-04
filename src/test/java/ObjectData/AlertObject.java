package ObjectData;

import java.util.HashMap;

public class AlertObject {

    private String promptAlertValue;

    public String getPromptAlertValue() {
        return promptAlertValue;
    }

    public void setPromptAlertValue(String promptAlertValue) {
        this.promptAlertValue = promptAlertValue;
    }

    public AlertObject (HashMap<String, String> tesData){
        populateObject(tesData);

    }

    //Facem o metoda care sa mapeze valorile din Properties la variabilele din clasa

    private void populateObject(HashMap<String, String> testData) {
        for (String Key : testData.keySet()) {
            switch (Key) {
                case "promptAlertValue":
                    setPromptAlertValue(testData.get(Key));
                    break;
            }
        }
    }
}