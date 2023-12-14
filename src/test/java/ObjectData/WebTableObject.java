package ObjectData;

import java.util.HashMap;

public class WebTableObject {

    private String firstnamevalue;

    private String prenume;

    private String emailvalue;

    private String varsta;

    private String salariuvaloare;

    private String departamentvaloare;

    public String getFirstnamevalue() {
        return firstnamevalue;
    }

    public void setFirstnamevalue(String firstnamevalue) {
        this.firstnamevalue = firstnamevalue;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmailvalue() {
        return emailvalue;
    }

    public void setEmailvalue(String emailvalue) {
        this.emailvalue = emailvalue;
    }

    public String getVarsta() {
        return varsta;
    }

    public void setVarsta(String varsta) {
        this.varsta = varsta;
    }

    public String getSalariuvaloare() {
        return salariuvaloare;
    }

    public void setSalariuvaloare(String salariuvaloare) {
        this.salariuvaloare = salariuvaloare;
    }

    public String getDepartamentvaloare() {
        return departamentvaloare;
    }

    public void setDepartamentvaloare(String departamentvaloare) {
        this.departamentvaloare = departamentvaloare;
    }

    public WebTableObject(HashMap<String,String> testData){
        populateObject(testData);
    }

    private void populateObject(HashMap<String, String> testData) {
        for (String Key : testData.keySet()) {
            switch (Key) {
                case "firstnamevalue":
                    setFirstnamevalue(testData.get(Key));
                    break;
                case "prenume":
                    setPrenume(testData.get(Key));
                    break;
                case "emailvalue":
                    setEmailvalue(testData.get(Key));
                    break;
                case "varsta":
                    setVarsta(testData.get(Key));
                    break;
                case "salariuvaloare":
                    setSalariuvaloare(testData.get(Key));
                    break;
                case "departamentvaloare":
                    setDepartamentvaloare(testData.get(Key));
                    break;
            }
        }
    }
}
