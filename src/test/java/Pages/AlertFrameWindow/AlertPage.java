package Pages.AlertFrameWindow;

import Logger.LoggerUtility;
import ObjectData.AlertObject;
import Pages.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertPage extends BasePage {
    // Design pattern de programare(adica un sablon care structureaza codul): "Page Object Model"      (acest concept spune ca: daca avem un flow end-to-end,exista posibilitatea ca
    // unele teste sa treaca prin aceleasi pagini si elemente , si astfel sa reducem codul duplicat, creeand o clasa pentru fiecare pagina )
    // - daca se modifica ceva in cod, vom modifica doar intr-un singur loc si se propaga peste tot unde este folosit.
//    public WebDriver driver;
//
//    public AlertPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver,this);                      // cu linia asta se initializeaza elementele din clasa(cele cu findby), si ne da eroare daca nu o avem  ; deci in Page Object Model , PageFactory ne initializeaza elementele
//    }

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    // mereu ar fi bine sa identificam mai intai elementele si apoi sa fac metodele
    @FindBy(id = "alertButton")
    private WebElement button1;
    @FindBy(id = "timerAlertButton")
    private WebElement alertDelayButton;
    @FindBy(id = "confirmButton")
    private WebElement alert3;
    @FindBy(id = "promtButton")
    private WebElement promtButton;


    public void interractAlertOk() {
//        button1.click();
//        Alert alertOk= driver.switchTo().alert();            // facem un obiect de tipul alert ca sa ne mutam cu focusul pe alerta
//        alertOk.accept();                                 // la o alerta putem avea accept(=ok) sau dismiss(=cancel)
        elementMethods.clickElement(button1);
        LoggerUtility.info("The user clicks on first alert button.");
        alertMethods.acceptAlert();
        LoggerUtility.info("The user clicks accept on alert.");
    }

    public void interractAlertDelay() {
//        alertDelayButton.click();
        // ca sa punem un delay ,folosim wait-uri. (spre ex: atunci cand site-ul nu se incarca atat de repede pe cat ne-am dori)
        // Wait-urile sunt de 2 tipuri : implicite si explicite. Wait-ul implicit: prin wait implicit setam un timp maxim de asteptare(afecteaza toate elementele de pe pagina identificate) ; Wait-ul explicit: il folosim tintit(doar unde este nevoie de un timp de asteptare) ; Deci ambele tipuri asteapta un timp maxim(daca conditia se indeplineste mai devreme,face actiunea).
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.alertIsPresent());        // pana cand :conditia:alerta este prezenta

//        Alert alertdelay= driver.switchTo().alert();
//        alertdelay.accept();
        elementMethods.clickElement(alertDelayButton);
        LoggerUtility.info("The user clicks on alertDelayButton");
        alertMethods.acceptAlert();
        LoggerUtility.info("The user clicks on acceptAlert");
    }

    public void interractAlertDismiss() {
//        alert3.click();
//        Alert alertcancel=driver.switchTo().alert();
//        alertcancel.dismiss();
        elementMethods.clickElement(alert3);
        LoggerUtility.info("The user clicks on third alert button.");
        alertMethods.cancelAlert();
        LoggerUtility.info("The user clicks on dismiss.");
    }

    //    public void interractAlertValue(String value){            // facem un parametru si dam valoarea in clasa de test
    public void interractAlertValue(AlertObject alertObject) {

        elementMethods.clickElement(promtButton);
        LoggerUtility.info("The user clicks on promtButton");

        alertMethods.fillAlert(alertObject.getPromptAlertValue());
        LoggerUtility.info("The user fills the PromptAlertValue" + promtButton);

//        promtButton.click();
//        alertObject.getPromptAlertValue();
//        Alert alertPromt = driver.switchTo().alert();  //facem switchul pe alerta
//        alertPromt.sendKeys(value);
//        alertPromt.accept();
    }
}

