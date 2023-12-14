package Pages.Forms;

import ObjectData.FormsTableObject;
import Pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    private WebElement firstname;

    @FindBy(id = "lastName")
    private WebElement lastname;

    @FindBy(id = "userEmail")
    private WebElement email;

    @FindBy(css = "label[for='gender-radio-1']")
    private WebElement gender;

    @FindBy(id = "userNumber")
    private WebElement mobilephone;

    @FindBy(id = "subjectsInput")
    private WebElement subjects;

    @FindBy(css = "label[for='hobbies-checkbox-1']")
    private WebElement hobbies;

    @FindBy(id = "uploadPicture")
    private WebElement uploadPicture;

    @FindBy(id = "currentAddress")
    private WebElement currentAdress;

    @FindBy(id = "react-select-3-input")
    private WebElement selectstate;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "react-select-4-input")
    private WebElement selectCity;

    @FindBy(id = "submit")
    private WebElement submit;

    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement validaremesaj;

    @FindBy(css=".table-dark>tbody>tr")
    private List<WebElement> validationTable;

    @FindBy(id = "closeLargeModal")
    private WebElement closepopup;


//    public void fillPracticeForm(String firstName, String lastName, String email, String mobilephone, String subjects, String address, String state, String city){
public void fillPracticeForm(FormsTableObject formsTableObject){
//    fillFirstName(firstName);
//    fillLastName(lastName);
//    fillEmail(email);
//    fillGender();
//    fillMobilePhone(mobilephone);
//    fillSubjects(subjects);
//    fillHobbies();
//    uploadPicture("src/test/resources/drive.txt");                     // aceasta linie face uplaod la fisier cand completeaza campurile.
//    fillCurrentAdress(address);
//    fillState(state);
//    fillCity(city);
//    }

    fillFirstName(formsTableObject.getFirstNameValue());     // asa scoatem din obiectul nostru datele de care avem nevoie
    fillLastName(formsTableObject.getLastnamevalue());
    fillEmail(formsTableObject.getEmailValue());
    fillGender();
    fillMobilePhone(formsTableObject.getMobilephonevalue());
    fillSubjects(formsTableObject.getSubjectsValue());
    fillHobbies();
    uploadPicture("src/test/resources/drive.txt");                     // aceasta linie face uplaod la fisier cand completeaza campurile.
    fillCurrentAdress(formsTableObject.getCurrentadressvalue());
    fillState(formsTableObject.getStateandcityvalue());
    fillCity(formsTableObject.getCityvalue());
}

    public List<String> getValuesForm(){
        List<String> formValues = new ArrayList<>();
        formValues.add(gender.getText());
        formValues.add(hobbies.getText());
        return formValues;
    }

    public void fillFirstName(String firstNameValue){
//        firstname.sendKeys(firstNameValue);
        elementMethods.fillElement(firstname,firstNameValue);
    }

    public void fillLastName(String lastNameValue){
        lastname.sendKeys(lastNameValue);
    }

    public void fillEmail(String emailValue){
        email.sendKeys(emailValue);
    }

    public void fillGender(){
//        gender.click();
        elementMethods.clickElement(gender);
    }

    public void fillMobilePhone(String mobilePhoneValue){
        mobilephone.sendKeys(mobilePhoneValue);
    }

    public void fillSubjects(String subjectsValue){
//        subjects.sendKeys(subjectsValue);
//        subjects.sendKeys(Keys.ENTER);
        elementMethods.fillElement(subjects,subjectsValue,Keys.ENTER);
    }

public void fillHobbies(){
    hobbies.click();
}

public void uploadPicture(String filepath){
    File file= new File(filepath);
    uploadPicture.sendKeys(file.getAbsolutePath());
}

public void fillCurrentAdress(String currentAdressValue){
    currentAdress.sendKeys(currentAdressValue);
}

public void fillState(String selectstateValue){
        elementMethods.scrollByPixel(0,450);
        elementMethods.clickJSelement(state);
        elementMethods.fillElement(selectstate,selectstateValue,Keys.ENTER);

//    selectstate.sendKeys(selectstateValue);
//    selectstate.sendKeys(Keys.ENTER);

}

public void fillCity(String cityvalue){
    elementMethods.clickJSelement(city);
    elementMethods.fillElement(selectCity,cityvalue,Keys.ENTER);

//    city.click();
//    selectCity.sendKeys(cityvalue);
//    selectCity.sendKeys(Keys.ENTER);

}

public void submitButton(){
    submit.click();
//    JavascriptExecutor js = (JavascriptExecutor) driver;
//    js.executeScript("arguments[0].click();", submit);

    elementMethods.clickJSelement(submit);
}

public void clickClose(){
    closepopup.sendKeys(Keys.ENTER);
}

public void validatePracticeForm(String mesajasteptat, String prenume, String lastnamevalue, String emailValue, String gendervalue, String mobilephonevalue, String subjectsValue, String hobbiesvalue, String currentadressvalue, String statevalue,String cityvalue, File file){
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM,yyyy");            // aici facem pattern-ul cerut de tabel : dd MMMM, yy , si am folosit debug ca sa vedem cum ne arata data.
    LocalDateTime now = LocalDateTime.now();
    String dateofbirthvalue=dtf.format(now);

//    String mesajprimit=validaremesaj.getText();
//    Assert.assertEquals(mesajasteptat,mesajprimit);

    elementMethods.validateElementMessage(validaremesaj,mesajasteptat);


    Assert.assertTrue(validationTable.get(0).getText().contains("Student Name"));
    Assert.assertTrue(validationTable.get(0).getText().contains(prenume+ " "+lastnamevalue));

    // equals = sa fie acelasi lucru , contains= sa contina.

    Assert.assertTrue(validationTable.get(1).getText().contains("Student Email"));
    Assert.assertTrue(validationTable.get(1).getText().contains(emailValue));

    Assert.assertTrue(validationTable.get(2).getText().contains("Gender"));
    Assert.assertTrue(validationTable.get(2).getText().contains(gendervalue));

    Assert.assertTrue(validationTable.get(3).getText().contains("Mobile"));
    Assert.assertTrue(validationTable.get(3).getText().contains(mobilephonevalue));

    Assert.assertTrue(validationTable.get(4).getText().contains("Date of Birth"));
    Assert.assertTrue(validationTable.get(4).getText().contains(dateofbirthvalue));

    Assert.assertTrue(validationTable.get(5).getText().contains("Subjects"));
    Assert.assertTrue(validationTable.get(5).getText().contains(subjectsValue));

    Assert.assertTrue(validationTable.get(6).getText().contains("Hobbies"));
    Assert.assertTrue(validationTable.get(6).getText().contains(hobbiesvalue));

    Assert.assertTrue(validationTable.get(7).getText().contains("Picture"));
    Assert.assertTrue(validationTable.get(7).getText().contains(file.getName()));      // .getName() ca sa ia numele fisierului

    Assert.assertTrue(validationTable.get(8).getText().contains("Address"));
    Assert.assertTrue(validationTable.get(8).getText().contains(currentadressvalue));

    Assert.assertTrue(validationTable.get(9).getText().contains("State and City"));
    Assert.assertTrue(validationTable.get(9).getText().contains(statevalue + " " +cityvalue));
}
}
