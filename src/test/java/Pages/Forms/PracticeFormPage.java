package Pages.Forms;

import Logger.LoggerUtility;
import ObjectData.FormsTableObject;
import Pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
    private WebElement actualmessage;

    @FindBy(css = ".table-dark>tbody>tr")
    private List<WebElement> validationTable;

    @FindBy(id = "closeLargeModal")
    private WebElement closeButton;


    //    public void fillPracticeForm(String firstName, String lastName, String email, String mobilephone, String subjects, String address, String state, String city){
    public void fillPracticeForm(FormsTableObject formsTableObject) {
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

    public List<String> getValuesForm() {
        List<String> formValues = new ArrayList<>();
        formValues.add(gender.getText());
        formValues.add(hobbies.getText());
        return formValues;
    }

    public void fillFirstName(String firstNameValue) {
//        firstname.sendKeys(firstNameValue);
        elementMethods.fillElement(firstname, firstNameValue);
        LoggerUtility.info("The user fills First Name with value : " + firstNameValue);
    }

    public void fillLastName(String lastNameValue) {
//        lastname.sendKeys(lastNameValue);
        elementMethods.fillElement(lastname, lastNameValue);
        LoggerUtility.info("The user fills First Name with value : " + lastNameValue);
    }

    public void fillEmail(String emailValue) {
//        email.sendKeys(emailValue);
        elementMethods.fillElement(email, emailValue);
        LoggerUtility.info("The user fills email with value : " + emailValue);

    }

    public void fillGender() {
//        gender.click();
        elementMethods.clickElement(gender);
        LoggerUtility.info("The user clicks on gender : " + gender);
    }

    public void fillMobilePhone(String mobilePhoneValue) {
//        mobilephone.sendKeys(mobilePhoneValue);
        elementMethods.fillElement(mobilephone, mobilePhoneValue);
        LoggerUtility.info("The user fills mobile with value : " + mobilePhoneValue);
    }

    public void fillSubjects(String subjectsValue) {
//        subjects.sendKeys(subjectsValue);
//        subjects.sendKeys(Keys.ENTER);
        elementMethods.fillElement(subjects, subjectsValue, Keys.ENTER);
        LoggerUtility.info("The user fills subjects with value : " + subjectsValue);
    }

    public void fillHobbies() {
//    hobbies.click();
        elementMethods.clickElement(hobbies);
        LoggerUtility.info("The user clicks on :" + hobbies);
    }

    public void uploadPicture(String filepath) {
        File file = new File(filepath);
        uploadPicture.sendKeys(file.getAbsolutePath());
        LoggerUtility.info("The user uploads the file :" + file.getName());
    }

    public void fillCurrentAdress(String currentAdressValue) {
//    currentAdress.sendKeys(currentAdressValue);
        elementMethods.fillElement(currentAdress, currentAdressValue);
        LoggerUtility.info("The user fills address with value : " + currentAdressValue);
    }

    public void fillState(String selectstateValue) {
        elementMethods.scrollByPixel(0, 450);
        LoggerUtility.info("The user fills scrolls down the page");
        elementMethods.clickJSelement(state);
        LoggerUtility.info("The user clicks on : " + state);
        elementMethods.fillElement(selectstate, selectstateValue, Keys.ENTER);
        LoggerUtility.info("The user selects state : " + selectstateValue);

//    selectstate.sendKeys(selectstateValue);
//    selectstate.sendKeys(Keys.ENTER);

    }

    public void fillCity(String cityvalue) {
        elementMethods.clickJSelement(city);
        LoggerUtility.info("The user clicks on : " + city);
        elementMethods.fillElement(selectCity, cityvalue, Keys.ENTER);
        LoggerUtility.info("The user selects city : " + cityvalue);

//    city.click();
//    selectCity.sendKeys(cityvalue);
//    selectCity.sendKeys(Keys.ENTER);

    }

    public void submitButton() {
//    submit.click();
//    JavascriptExecutor js = (JavascriptExecutor) driver;
//    js.executeScript("arguments[0].click();", submit);
        elementMethods.clickJSelement(submit);
        LoggerUtility.info("The user clicks on submit button");
    }

    public void clickClose() {
        elementMethods.fillElement(closeButton, Keys.ENTER);
        LoggerUtility.info("The user clicks on close button");
        //        closeButton.sendKeys(Keys.ENTER);
    }

    //public void validatePracticeForm(String mesajasteptat, String prenume, String lastnamevalue, String emailValue, String gendervalue, String mobilephonevalue, String subjectsValue, String hobbiesvalue, String currentadressvalue, String statevalue,String cityvalue, File file){
    public void validatePracticeForm(FormsTableObject formsTableObject) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM,yyyy");            // aici facem pattern-ul cerut de tabel : dd MMMM, yy , si am folosit debug ca sa vedem cum ne arata data.
        LocalDateTime now = LocalDateTime.now();
        String dateofbirthvalue = dtf.format(now);

//    String mesajprimit=validaremesaj.getText();
//    Assert.assertEquals(mesajasteptat,mesajprimit);

        elementMethods.validateElementMessage(actualmessage, formsTableObject.getMesajasteptat());
        LoggerUtility.info("Validating display message.");

        Assert.assertTrue(validationTable.get(0).getText().contains("Student Name"));
        LoggerUtility.info("Validating default text on first field.");
        Assert.assertTrue(validationTable.get(0).getText().contains(formsTableObject.getFirstNameValue() + " " + formsTableObject.getLastnamevalue()));
        LoggerUtility.info("Validating data in the first field.");

        Assert.assertTrue(validationTable.get(1).getText().contains("Student Email"));
        LoggerUtility.info("Validating default text on second field.");
        Assert.assertTrue(validationTable.get(1).getText().contains(formsTableObject.getEmailValue()));
        LoggerUtility.info("Validating data in the second field.");

        Assert.assertTrue(validationTable.get(2).getText().contains("Gender"));
        LoggerUtility.info("Validating default text on third field.");
        Assert.assertTrue(validationTable.get(2).getText().contains(formsTableObject.getGender()));
        LoggerUtility.info("Validating data in the third field.");

        Assert.assertTrue(validationTable.get(3).getText().contains("Mobile"));
        LoggerUtility.info("Validating default text on fourth field.");
        Assert.assertTrue(validationTable.get(3).getText().contains(formsTableObject.getMobilephonevalue()));
        LoggerUtility.info("Validating data in the fourth field.");

        Assert.assertTrue(validationTable.get(4).getText().contains("Date of Birth"));
        LoggerUtility.info("Validating default text on fifth field.");
        Assert.assertTrue(validationTable.get(4).getText().contains(dateofbirthvalue));
        LoggerUtility.info("Validating data in the fifth field.");

        Assert.assertTrue(validationTable.get(5).getText().contains("Subjects"));
        LoggerUtility.info("Validating default text on sixth field.");
        Assert.assertTrue(validationTable.get(5).getText().contains(formsTableObject.getSubjectsValue()));
        LoggerUtility.info("Validating data in the sixth field.");

        Assert.assertTrue(validationTable.get(6).getText().contains("Hobbies"));
        LoggerUtility.info("Validating default text on seventh field.");
        Assert.assertTrue(validationTable.get(6).getText().contains(formsTableObject.getHobbies()));
        LoggerUtility.info("Validating data in the seventh field.");

        Assert.assertTrue(validationTable.get(7).getText().contains("Picture"));
        LoggerUtility.info("Validating default eighth on first field.");
        Assert.assertTrue(validationTable.get(7).getText().contains(formsTableObject.getFile().getName()));
        LoggerUtility.info("Validating data in the eighth field.");

        Assert.assertTrue(validationTable.get(8).getText().contains("Address"));
        LoggerUtility.info("Validating default text on ninth field.");
        Assert.assertTrue(validationTable.get(8).getText().contains(formsTableObject.getCurrentadressvalue()));
        LoggerUtility.info("Validating data in the ninth field.");

        Assert.assertTrue(validationTable.get(9).getText().contains("State and City"));
        LoggerUtility.info("Validating default text on tenth field.");
        Assert.assertTrue(validationTable.get(9).getText().contains(formsTableObject.getStateandcityvalue() + " " + formsTableObject.getCityvalue()));
        LoggerUtility.info("Validating data in the tenth field.");
    }
}

//    Assert.assertTrue(validationTable.get(0).getText().contains("Student Name"));
//    Assert.assertTrue(validationTable.get(0).getText().contains(prenume+ " "+lastnamevalue));

    // equals = sa fie acelasi lucru , contains= sa contina.

//    Assert.assertTrue(validationTable.get(1).getText().contains("Student Email"));
//    Assert.assertTrue(validationTable.get(1).getText().contains(emailValue));
//
//    Assert.assertTrue(validationTable.get(2).getText().contains("Gender"));
//    Assert.assertTrue(validationTable.get(2).getText().contains(gendervalue));
//
//    Assert.assertTrue(validationTable.get(3).getText().contains("Mobile"));
//    Assert.assertTrue(validationTable.get(3).getText().contains(mobilephonevalue));
//
//    Assert.assertTrue(validationTable.get(4).getText().contains("Date of Birth"));
//    Assert.assertTrue(validationTable.get(4).getText().contains(dateofbirthvalue));
//
//    Assert.assertTrue(validationTable.get(5).getText().contains("Subjects"));
//    Assert.assertTrue(validationTable.get(5).getText().contains(subjectsValue));
//
//    Assert.assertTrue(validationTable.get(6).getText().contains("Hobbies"));
//    Assert.assertTrue(validationTable.get(6).getText().contains(hobbiesvalue));
//
//    Assert.assertTrue(validationTable.get(7).getText().contains("Picture"));
//    Assert.assertTrue(validationTable.get(7).getText().contains(file.getName()));      // .getName() ca sa ia numele fisierului
//
//    Assert.assertTrue(validationTable.get(8).getText().contains("Address"));
//    Assert.assertTrue(validationTable.get(8).getText().contains(currentadressvalue));
//
//    Assert.assertTrue(validationTable.get(9).getText().contains("State and City"));
//    Assert.assertTrue(validationTable.get(9).getText().contains(statevalue + " " +cityvalue));
//}

