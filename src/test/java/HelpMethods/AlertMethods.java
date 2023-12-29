package HelpMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertMethods {
    private WebDriver driver; // scopul clasei e sa ne ofere doar metodele, nu si driverul, de aceea putem face driverul privat
    public AlertMethods(WebDriver driver) {
        this.driver = driver;
    }

    private void waitForAlert(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(){
        waitForAlert();                                      //inainte sa dea accept, daca e sau nu nevoie de wait se activeaza singur
        Alert alertOk= driver.switchTo().alert();
        alertOk.accept();
    }

    public void cancelAlert(){
        waitForAlert();
        Alert alertcancel=driver.switchTo().alert();
        alertcancel.dismiss();
    }

    public void fillAlert(String value){
        waitForAlert();
        Alert alertPromt = driver.switchTo().alert();  //facem switchul pe alerta
        alertPromt.sendKeys(value);
        alertPromt.accept();
    }
}
