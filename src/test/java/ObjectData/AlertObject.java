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

    private void populateObject(HashMap<String, String> tesData) {
        for (String Key : tesData.keySet()) {
            switch (Key) {
                case "promptAlertValue":
                    setPromptAlertValue(tesData.get(Key));
                    break;
            }
        }
    }
}