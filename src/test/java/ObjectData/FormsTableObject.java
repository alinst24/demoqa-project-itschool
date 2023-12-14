package ObjectData;

import java.util.HashMap;

public class FormsTableObject {

    private String firstNameValue;         //definim niste variabile globale care sa aiba acelasi nume cu cheile din fisier ,deoarece maparea se face prin parcurgerea fisierului nostru

    private String lastnamevalue;

    private String emailValue;

    private String mobilephonevalue;

    private String subjectsValue;

    private String currentadressvalue;

    private String stateandcityvalue;

    private String cityvalue;

    private String mesajasteptat;

    private String examen;        // apoi facem getter si setter (jos)



    // pentru ca sunt private ne trbuie getteri si setteri , mai jos
    // trebuie sa stim ce vrem sa afisam(adica getteri) si ce sa modificam(setteri) , in cazul acesta , ambele.


    public FormsTableObject(HashMap<String,String>testData){         // acesta primeste multimea cheie=valoare
        populateObject(testData);         // apoi aici apelam metoda cu parametrul testdata
    }

    // facem o metoda care sa mapeze valorile din properties la variabilele din clasa

    private void populateObject(HashMap<String, String> testData) {
        for (String Key : testData.keySet()) {       // asta ne da toate cheile din hashmap , si daca stim cheia putem accesa valoarea
            switch (Key) {
                case "firstNameValue":
                    setFirstNameValue(testData.get(Key));
                    break;
                case "lastnamevalue":
                    setLastnamevalue(testData.get(Key));
                    break;
                case "emailValue":
                    setEmailValue(testData.get(Key));
                    break;
                case "mobilephonevalue":
                    setMobilephonevalue(testData.get(Key));
                    break;
                case "subjectsValue":
                    setSubjectsValue(testData.get(Key));
                    break;
                case "currentadressvalue":
                    setCurrentadressvalue(testData.get(Key));
                    break;
                case "stateandcityvalue":
                    setStateandcityvalue(testData.get(Key));
                    break;
                case "cityvalue":
                    setCityvalue(testData.get(Key));
                    break;
                case "mesajasteptat":
                    setMesajasteptat(testData.get(Key));
                    break;
                case "examen":
                    setExamen(testData.get(Key));
                    break;
            }
        }
    }


    public String getFirstNameValue() {
        return firstNameValue;
    }

    public void setFirstNameValue(String firstNameValue) {
        this.firstNameValue = firstNameValue;
    }

    public String getLastnamevalue() {
        return lastnamevalue;
    }

    public void setLastnamevalue(String lastnamevalue) {
        this.lastnamevalue = lastnamevalue;
    }

    public String getEmailValue() {
        return emailValue;
    }

    public void setEmailValue(String emailValue) {
        this.emailValue = emailValue;
    }

    public String getMobilephonevalue() {
        return mobilephonevalue;
    }

    public void setMobilephonevalue(String mobilephonevalue) {
        this.mobilephonevalue = mobilephonevalue;
    }

    public String getSubjectsValue() {
        return subjectsValue;
    }

    public void setSubjectsValue(String subjectsValue) {
        this.subjectsValue = subjectsValue;
    }

    public String getCurrentadressvalue() {
        return currentadressvalue;
    }

    public void setCurrentadressvalue(String currentadressvalue) {
        this.currentadressvalue = currentadressvalue;
    }

    public String getStateandcityvalue() {
        return stateandcityvalue;
    }

    public void setStateandcityvalue(String stateandcityvalue) {
        this.stateandcityvalue = stateandcityvalue;
    }

    public String getCityvalue() {
        return cityvalue;
    }

    public void setCityvalue(String cityvalue) {
        this.cityvalue = cityvalue;
    }

    public String getMesajasteptat() {
        return mesajasteptat;
    }

    public void setMesajasteptat(String mesajasteptat) {
        this.mesajasteptat = mesajasteptat;
    }

    public String getExamen() {
        return examen;
    }

    public void setExamen(String examen) {
        this.examen = examen;
    }
    // Si apoi adaugam inca un case , sus
}
