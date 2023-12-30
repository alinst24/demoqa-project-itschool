package Tests;

import ObjectData.FormsTableObject;
import Pages.Forms.FormsPage;
import Pages.HomePage;
import Pages.Forms.PracticeFormPage;
import org.testng.annotations.Test;
import ShareData.Hooks;

public class FormsTableTest extends Hooks {

    @Test
    public void testMetoda() {

        FormsTableObject formsTableObject = new FormsTableObject(testData);

        // Doar o singura daca initiem javascriptexecutorul, in rest daca vrem sa facem mai multe scrolluri , copiem doar linia a doua din acel scroll.
        HomePage homePage = new HomePage(getDriver());
        homePage.clickForms();

        FormsPage formsPage = new FormsPage(getDriver());
        formsPage.clickPracticeForms();

//        String firstNameValue = "Stanciu";
//        String lastnamevalue = "Alin-Georgian";
//        String emailValue = "alinstanciu707@yahoo.com";
//        String mobilephonevalue = "0771702457";
//        String subjectsValue = "English";
//        String currentadressvalue = "Braila";
//        String stateandcityvalue = "NCR";
//        String cityvalue = "Delhi";
//        String mesajasteptat = "Thanks for submitting the form";
//        String filepath= "src/test/resources/drive.txt";                            // si in caz ca vrem sa modificam vreo valoare , o facem aici din acestea toate
        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
//        practiceFormPage.fillPracticeForm(firstNameValue, lastnamevalue, emailValue, mobilephonevalue, subjectsValue, currentadressvalue,stateandcityvalue, cityvalue);      // fiindca am apelat fillpracticeform, ne-a facut upload si la fisier, deci aici nu trebuie sa am File ca parametru
        practiceFormPage.fillPracticeForm(formsTableObject);

//        List<String> formValues = practiceFormPage.getValuesForm();
        practiceFormPage.submitButton();
        practiceFormPage.validatePracticeForm(formsTableObject);

//        practiceFormPage.validatePracticeForm(mesajasteptat, firstNameValue, lastnamevalue, emailValue, formValues.get(0), mobilephonevalue, subjectsValue, formValues.get(1), currentadressvalue, stateandcityvalue,cityvalue,new File(filepath));   //in schimb aici la validare, initiem cu "new" File (si path-ul)
        practiceFormPage.clickClose();
//        // cand avem un radiobox , sa mergem mai intai dupa input , pentru ca acela este cerculetul( si cautam un id sau ceva), daca nu... mergem dupa label (adica dupa text)
//        WebElement gender= driver.findElement(By.cssSelector("label[for='gender-radio-1']"));
//        gender.click();
//        // stringul de mai jos l-am facut pentru validare
//        String gendervalue=gender.getText();

//        WebElement mobilephone=driver.findElement(By.id("userNumber"));
//        String mobilephonevalue="0771702457";
//        mobilephone.sendKeys(mobilephonevalue);

        // Apoi am sarit peste dateofbirth


        // Aici , la dropdown, nu putem face inspect si trebuie sa punem o valoare si apoi sa apasam enter.
        // Pentru asta , mai intai identificam campul, cautam un input si un id mai sus sau mai jos in div-uri daca exista.
//        WebElement subjects=driver.findElement(By.id("subjectsInput"));
//        String subjectsValue="English";
//        subjects.sendKeys(subjectsValue);
//        subjects.sendKeys(Keys.ENTER);

//        WebElement hobbies=driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
//        hobbies.click();
//        String hobbiesvalue=hobbies.getText();


        // chooseFile ; trebuie sa ii dam un path catre fisierul nostru ; mai intai sa cautam input ; in caz de avarie: folosim div/label ; linia care poate sa primeasca un path de obicei are "type="file" , sau ceva cu "upload"
//        WebElement uploadPicture=driver.findElement(By.id("uploadPicture"));
//        File file= new File("src/test/resources/drive.txt");
//        uploadPicture.sendKeys(file.getAbsolutePath());
        // trebuie ca fisierul resources sa fie in "tests" si acolo introducem fisierul nostru.
        // dupa care click dreapta pe fisier si copy path/reference si dam click pe al 3lea , path from content root


//        WebElement currentAdress=driver.findElement(By.id("currentAddress"));
//        String currentadressvalue="test,nr test";
//        currentAdress.sendKeys(currentadressvalue);

//        WebElement stateandcity = driver.findElement(By.id("react-select-3-input"));
//        String stateandcityvalue= "NCR";
//        stateandcity.sendKeys(stateandcityvalue);
//        stateandcity.sendKeys(Keys.ENTER);

//        WebElement city = driver.findElement(By.id("city"));
//        city.click();
//
//        WebElement selectCity=driver.findElement(By.id("react-select-4-input"));
//        String cityvalue = "Delhi";
//        selectCity.sendKeys(cityvalue);
//        selectCity.sendKeys(Keys.ENTER);

//        WebElement submit = driver.findElement(By.id("submit"));
//        submit.click();


        //pentru data de nastere:
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM,yyyy");            // aici facem pattern-ul cerut de tabel : dd MMMM, yy , si am folosit debug ca sa vedem cum ne arata data.
//        LocalDateTime now = LocalDateTime.now();
//        String dateofbirthvalue=dtf.format(now);
//
//
//
//
//// Dar daca nu mergea click-ul din cauza ca nu il vedem pe pagina( din cauza rezolutiei) , putem folosi javascript executor: ( ca alternativa finala) , ca un click fortat pe un element stiind ca elementul e pe pagina:
//        // js.executeScript("arguments[0].click();", submit);
//
//
//
//
//
//        // VALIDARE :
//        WebElement validaremesaj =driver.findElement(By.id("example-modal-sizes-title-lg"));
//        String mesajasteptat="Thanks for submitting the form";
//        String mesajprimit=validaremesaj.getText();
//        Assert.assertEquals(mesajasteptat,mesajprimit);
//
//
//
//
//        // VALIDARE CONTINUT :
//
//        // luam si verificam fiecare valoare in parte daca este pusa unde trebuie( la email , nr de telefon etc)
//        // mai intai trebuie sa gasim tabelul si apoi coboram din el
//        // Daca avem o clasa sau un id ceva cu valoare mare(adica mult scris), putem sa identificam doar o bucata prin css doar !!!! ex : ".table-dark"
//        List<WebElement> validationTable=driver.findElements(By.cssSelector(".table-dark>tbody>tr"));
//        Assert.assertTrue(validationTable.get(0).getText().contains("Student Name"));
//        Assert.assertTrue(validationTable.get(0).getText().contains(prenume+ " "+lastnamevalue));
//
//        // equals = sa fie acelasi lucru , contains= sa contina.
//
//        Assert.assertTrue(validationTable.get(1).getText().contains("Student Email"));
//        Assert.assertTrue(validationTable.get(1).getText().contains(emailValue));
//
//        Assert.assertTrue(validationTable.get(2).getText().contains("Gender"));
//        Assert.assertTrue(validationTable.get(2).getText().contains(gendervalue));
//
//        Assert.assertTrue(validationTable.get(3).getText().contains("Mobile"));
//        Assert.assertTrue(validationTable.get(3).getText().contains(mobilephonevalue));
//
//        Assert.assertTrue(validationTable.get(4).getText().contains("Date of Birth"));
//        Assert.assertTrue(validationTable.get(4).getText().contains(dateofbirthvalue));
//
//        Assert.assertTrue(validationTable.get(5).getText().contains("Subjects"));
//        Assert.assertTrue(validationTable.get(5).getText().contains(subjectsValue));
//
//        Assert.assertTrue(validationTable.get(6).getText().contains("Hobbies"));
//        Assert.assertTrue(validationTable.get(6).getText().contains(hobbiesvalue));
//
//        Assert.assertTrue(validationTable.get(7).getText().contains("Picture"));
//        Assert.assertTrue(validationTable.get(7).getText().contains(file.getName()));      // .getName() ca sa ia numele fisierului
//
//        Assert.assertTrue(validationTable.get(8).getText().contains("Address"));
//        Assert.assertTrue(validationTable.get(8).getText().contains(currentadressvalue));
//
//        Assert.assertTrue(validationTable.get(9).getText().contains("State and City"));
//        Assert.assertTrue(validationTable.get(9).getText().contains(statevalue + " " +cityvalue));
//
//
//        WebElement closepopup=driver.findElement(By.id("closeLargeModal"));
//        closepopup.sendKeys(Keys.ENTER);


    }

}