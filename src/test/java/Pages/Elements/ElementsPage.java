package Pages.Elements;

import Logger.LoggerUtility;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends BasePage {
    public ElementsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//span[text()='Web Tables']")
    private WebElement webtables;


    public void clickWebTables(){
        webtables.click();
        LoggerUtility.info("The user clicks on webtables element");
    }
}