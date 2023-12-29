package HelpMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ElementMethods {
    private WebDriver driver;
    public ElementMethods(WebDriver driver) {
        this.driver = driver;
    }

    private void waitVisibleElement(WebElement element){       // o facem privata pentru ca nu avem nevoie in alte clase     ;         // Webelement element = va primi elementul dupa care va trebui sa astepte wait-ul.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));                    // Wait-ul explicit : cand exista o problema de incarcare a unei valori si necesita sa avem un timp de asteptare     (asteapta pana cand se incarca si poate interactiona cu elementul)
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickElement(WebElement element){
        waitVisibleElement(element);                                          //Deci de fiecare data inainte sa actioneze, mai intai sa ne asiguram ca s-a incarcat elementul
        element.click();
    }

    public void fillElement(WebElement element, String value){
        waitVisibleElement(element);
        element.sendKeys(value);
    }

    public void fillElement(WebElement element, Keys keyboardPress){
        waitVisibleElement(element);
        element.sendKeys(keyboardPress);
    }

    public void fillElement(WebElement element, String value,Keys keyboardPress){
        waitVisibleElement(element);
        element.sendKeys(value);
        element.sendKeys(keyboardPress);
    }

    public void fillElement(WebElement element, String value,String keyboardPress){
        waitVisibleElement(element);
        element.sendKeys(value);
        element.sendKeys(keyboardPress);
    }

    public void scrollByPixel(Integer x, Integer y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+x+","+y+")","");
    }

    public void clickJSelement(WebElement element){
        waitVisibleElement(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void validateElementMessage(WebElement element,String value){
        waitVisibleElement(element);
        String mesajprimit=element.getText();
        Assert.assertEquals(mesajprimit,value);
    }
}
