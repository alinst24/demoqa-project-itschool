package ShareData;

import Logger.LoggerUtility;
import ShareData.Browser.BrowserFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class ShareData {               // aceasta clasa o folosim ca sa ruleze anumite conditii before si after method in alte clase   ( deci inferomatii legate de BROWSER pe care sa le folosim peste tot)

    private WebDriver driver;                  // daca declaram aici driverul , nu mai e nevoie in celelate clase care mostenesc aceasta clasa sa mai avem driver ; (incapsulat)


//    @BeforeMethod                      // preconditie:                // deci mai intai se executa beforemethod (inainte de metoda de test din alta clasa), apoi testul , apoi aftermethod
    public void setup(){
//        driver = new ChromeDriver();
//        driver.get("https://demoqa.com/");
//        driver.manage().window().maximize();
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));        // asta e un wait implicit , care de obicei se pune la inceputul codului , de obicei 10 secunde
//        LoggerUtility.info("The browser was opened with succes.");

        driver=new BrowserFactory().getBrowserDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");
        // Doar o singura daca initiem javascriptexecutorul, in rest daca vrem sa facem mai multe scrolluri , copiem doar linia a doua din acel scroll.
    }

//    @AfterMethod                   // postconditie:
    public void clear(){
        driver.quit();
        LoggerUtility.info("The browser was closed with success.");
    }

    public WebDriver getDriver() {
        return driver;
    }
}
