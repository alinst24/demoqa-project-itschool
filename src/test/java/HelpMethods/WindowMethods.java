package HelpMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class WindowMethods {

    private WebDriver driver;              // facem driverul privat , pt ca scopul acestei clase este sa ne ofere metodele , nu si driverul
    public WindowMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToSpecificWindow(Integer size){
        List<String> Tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(Tabs.get(size));
        System.out.println("URL : " + driver.getCurrentUrl());
    }

    public void closeCurrentWindow(){
        driver.close();
    }
}
