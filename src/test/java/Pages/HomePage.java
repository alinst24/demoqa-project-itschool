package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }


//    public WebDriver driver;                      // facem import in caz ca ne apare
//
//    public HomePage(WebDriver driver) {            // facem un constructor care sa primeasca driverul ca parametru ; ne trebuie aceeasi instanta de driver peste tot(nu facem un driver nou), si pt asta ne trebuie un constructor care primeste driver ca parametru
//        this.driver = driver;
//        PageFactory.initElements(driver,this);
//    }



    // apoi aici definim elementele specifice paginii de homepage
    // Deci in page object model sa definim un element : presupune sa facem o variabila globala si sa ii dam adnotarea cu @FindBy
    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elements;

    @FindBy (xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertsFrameWindows;         // facem o variabila globala

    @FindBy (xpath = "//h5[text()='Forms']")
    private  WebElement forms;


    public void clickAlertFrameWindow(){                 // metodele trebuie sa fie specifice clasei, deci cand le denumim sa fie sugestiv
        alertsFrameWindows.click();
        // iar apoi in testul nostru , facem un nou obiect  : //AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(driver);
                                                              //alertFrameWindowPage.clickAlerts();
    }
    public void clickForms(){
        forms.click();
    }                   // adica de pe pagina de homepage(aceasta) sa faca click pe forms

    public void clickElements(){
        elements.click();
    }
}
