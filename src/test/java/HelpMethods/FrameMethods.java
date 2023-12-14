package HelpMethods;

import org.openqa.selenium.WebDriver;

public class FrameMethods {

    private WebDriver driver;
    public FrameMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToFrame(String stringvalue){
        driver.switchTo().frame(stringvalue);
    }

    public void switchMainFrame(){
        driver.switchTo().defaultContent();
    }
}
