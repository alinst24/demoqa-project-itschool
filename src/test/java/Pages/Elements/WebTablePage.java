package Pages.Elements;

import ObjectData.WebTableObject;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class WebTablePage extends BasePage {

    public WebTablePage(WebDriver driver) {
        super(driver);
    }


    // cum sa gasim un element dupa text :( cu xpath):       ex cand avem un text : ".... > TEXTUL <  - intre mai mare si mai mic ><.              = este hardcodat, si putem face doar cu xpath

    // Dam un scroll ca sa gaseasca elementul

//        Actions scroll = new Actions(driver);
//        scroll.moveToElement(elements).perform();
//       SAU ALTA METODA DE SCROLL :

//    JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,450)", "");                            // Este deja introdus in sharedata
@FindBy(xpath = "//span[text()='Web Tables']")
    private WebElement webtables;

    @FindBy(id = "addNewRecordButton")
    private WebElement addelement;

    @FindBy(id = "firstName")
    private WebElement firstname;

    @FindBy(id = "lastName")
    private WebElement lastname;

    @FindBy(id = "userEmail")
    private WebElement email;

    @FindBy(id = "age")
    private WebElement age;

    @FindBy(id = "salary")
    private WebElement salariu;

    @FindBy(id = "department")
    private WebElement departament;

    @FindBy(id = "submit")
    private WebElement submitbutton;

    @FindBy(xpath = "//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']")
    private List<WebElement> actualEntries;

    @FindBy(xpath = "//div[@class='rt-tbody']/div/div[@class='rt-tr -odd' or @class='rt-tr -even']")
    private List<WebElement> expectedEntries;


    public void clickWebTables(){
        webtables.click();
    }
//
//    private Integer actualTableSize;          // am declarat asa ca sa poata fi accesibila in toate metodele din clasa
//    public void defaultTableSize(){
//        actualTableSize=actualEntries.size();    //  deci practic aici va avea valoarea 3 - pentru ca sunt deja 3 randuri cu valori  in tabel ( si doar cele completate au even si odd, restul au si altceva) ; // ne ia dimensiunea listei actuale
//    }
//
//    public void clickAdd(){
//        addelement.click();
//    }
//
//    public void fillForm(String firstname,String lastnamevalue,String emailvalue,String agevalue, String salariuvalue,String departmentvalue){
//        fillFirstName(firstname);
//        fillLastName(lastnamevalue);
//        fillEmail(emailvalue);
//        fillAge(agevalue);
//        fillSalary(salariuvalue);
//        fillDepartment(departmentvalue);
//    }
//
//    public void fillFirstName(String firstnamevalue){
//        firstname.sendKeys(firstnamevalue);
//    }
//
//    public void fillLastName(String lastnamevalue){
//        lastname.sendKeys(lastnamevalue);
//    }
//
//    public void fillEmail(String emailvalue){
//        email.sendKeys(emailvalue);
//    }
//
//    public void fillAge(String agevalue){
//        age.sendKeys(agevalue);
//    }
//
//    public void fillSalary(String salariuvalue){
//        salariu.sendKeys(salariuvalue);                 // Nu am putea sa il facem integer pentru ca sendKeys accepta doar string-uri
//    }
//
//    public void fillDepartment(String departmentvalue){
//        departament.sendKeys(departmentvalue);
//    }
//
//    public void submitButton(){
//        submitbutton.click();
//    }
//
//    public void expectedTableSize(){
//        Integer expectedTableSize=expectedEntries.size();   // linia asta ne da 4 randuri,iar noi il vrem pe al4-lea, iar ca si index pornim de la 0, deci vrem indexul 3
//        Assert. assertTrue(actualTableSize+1==expectedTableSize);
////        // assertTrue este o conditie booleana
////        // Trebuie sa validam dimensiunea dar si continutul ( datele pe care le-am introdus noi mai sus)  -    dar doar la ultima linie , nu ne intereseaza celelalte.
//    }
//
//    public void lastEntryContent(String nume,String prenume, String emailvalue, String varsta, String salariuvaloare, String departamentvaloare){
//        String lastEntryTable =expectedEntries.get(actualTableSize).getText();// linia asta ne da textul de pe tot randul ; //deci ca sa luam ultimul rand din tabel folosim get(expectedTableSize) ; deci chemam lista, si dam get(..) care ne returneaza elementul din lista ; deci get de(3) este diferit de get ca size ; deci la linia asta ia indexul, nu marimea!
//        Assert.assertTrue(lastEntryTable.contains(nume));          // contains e folosit sa vedem daca contine valoarea de la variabila respectiva
//        Assert.assertTrue(lastEntryTable.contains(prenume));
//        Assert.assertTrue(lastEntryTable.contains(emailvalue));
//        Assert.assertTrue(lastEntryTable.contains(varsta));
//        Assert.assertTrue(lastEntryTable.contains(salariuvaloare));
//        Assert.assertTrue(lastEntryTable.contains(departamentvaloare));
//    }
//
//
//








//    public void addnewEntry(String firstnamevalue,String lastnamevalue,String emailvalue,String agevalue,String salaryvalue,String departmentvalue){
public void addnewEntry(WebTableObject webTableObject){
        Integer actualTableSize=actualEntries.size();
//        addelement.click();
        elementMethods.clickElement(addelement);
        elementMethods.fillElement(firstname,webTableObject.getFirstnamevalue());
        elementMethods.fillElement(lastname,webTableObject.getPrenume());
        elementMethods.fillElement(email,webTableObject.getEmailvalue());
        elementMethods.fillElement(age,webTableObject.getVarsta());
        elementMethods.fillElement(salariu,webTableObject.getSalariuvaloare());
        elementMethods.fillElement(departament,webTableObject.getDepartamentvaloare());
        elementMethods.clickElement(submitbutton);

//        firstname.sendKeys(firstnamevalue);
//        lastname.sendKeys(lastnamevalue);
//        email.sendKeys(emailvalue);
//        age.sendKeys(agevalue);
//        salariu.sendKeys(salaryvalue);
//        departament.sendKeys(departmentvalue);
//        submitbutton.click();
        validateNewEntry(actualTableSize,webTableObject);
    }

//    private void validateNewEntry(Integer actualTableSize,String firstnamevalue,String lastnamevalue,String emailvalue,String agevalue,String salaryvalue,String departmentvalue){
private void validateNewEntry(Integer actualTableSize, WebTableObject webTableObject){

    Integer expectedTableSize=actualEntries.size();
        Assert.assertTrue(actualTableSize+1==expectedTableSize);
        String lastentryTable=actualEntries.get(actualTableSize).getText();
        Assert.assertTrue(lastentryTable.contains(webTableObject.getFirstnamevalue()));
        Assert.assertTrue(lastentryTable.contains(webTableObject.getPrenume()));
        Assert.assertTrue(lastentryTable.contains(webTableObject.getEmailvalue()));
        Assert.assertTrue(lastentryTable.contains(webTableObject.getVarsta()));
        Assert.assertTrue(lastentryTable.contains(webTableObject.getSalariuvaloare()));
        Assert.assertTrue(lastentryTable.contains(webTableObject.getDepartamentvaloare()));
    }
}
