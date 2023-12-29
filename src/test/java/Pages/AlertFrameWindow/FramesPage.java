package Pages.AlertFrameWindow;

import Logger.LoggerUtility;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Base64;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver) {
        super(driver);
    }

@FindBy(id = "sampleHeading")
    private WebElement frameText;

    public void interractFrame1(){
//        driver.switchTo().frame("frame1");  // ne mutam cu focusul pe frame: (dupa id)
//        System.out.println(frameText.getText()); // asta e ca sa vedem ca l-a identificat
//        // mai intai ca sa ne mutam pe alt frame , trebuie sa iesim din cel mic, pe pagina mare (default)
//        driver.switchTo().defaultContent();
//
        frameMethods.switchToFrame("frame1");
        LoggerUtility.info("The user clicks on specific frame.");
        System.out.println(frameText.getText());
        LoggerUtility.info("The user prints the frameText value");
        frameMethods.switchMainFrame();
        LoggerUtility.info("The user switches back to primary frame.");
    }

    public void interractFrame2(){
//        driver.switchTo().frame("frame2");
//        System.out.println(frame2Text.getText());

        frameMethods.switchToFrame("frame2");
        LoggerUtility.info("The user switches on the second frame.");
        System.out.println(frameText.getText());
        LoggerUtility.info("The user prints the frameText value");
    }
}
