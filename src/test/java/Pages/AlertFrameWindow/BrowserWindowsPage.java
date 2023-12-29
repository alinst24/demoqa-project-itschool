package Pages.AlertFrameWindow;

import Logger.LoggerUtility;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsPage extends BasePage {

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    private WebElement newTabButton;

    @FindBy(id = "windowButton")
    private WebElement newWindowButton;

    public void clickNewTabButton() {
        newTabButton.click();        // deschidem un nou tab prin butonul de pe pagina
        LoggerUtility.info("The user clicks on newTabButton button.");
//        System.out.println("URL : " + driver.getCurrentUrl());      // asta am facut-o ca sa vedem in consola daca se muta cu focusul sau nu        (Si nu se muta cu focusul pe tab pentru ca nu am dat comanda)
//
//        List<String> Tabs = new ArrayList<>(driver.getWindowHandles());        // identificam multimea de taburi deschise  ( taburile sunt considerate stringuri, deci lista de stringuri) ; getWindowHandles() = returneaza cate taburi sunt deschise
//        driver.switchTo().window(Tabs.get(1));            // ne mutam cu focusul pe un anumit tab  (cu index)
//
//        System.out.println("URL : " + driver.getCurrentUrl());         // la fel , sa vedem daca s-a mutat cu focusul.
//        driver.close();                   // asta inchide doar tabul pe care ne aflam ; iar quit inchide browserul        ; iar apoi intotdeauna trebuie sa ne mutam cu focusul pe alt tab.
//
//        driver.switchTo().window(Tabs.get(0));

        windowMethods.switchToSpecificWindow(1);
        LoggerUtility.info("The user switches to a new tab");
        windowMethods.closeCurrentWindow();
        LoggerUtility.info("The user closes the current tab");
        windowMethods.switchToSpecificWindow(0);
        LoggerUtility.info("The user switches back to the main tab");

    }

    public void clickNewWindowButton(){
        newWindowButton.click();
        LoggerUtility.info("The user clicks on interractWindow button");

//        List<String> Windows = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(Windows.get(1));
//
//        System.out.println("URL : "+ driver.getCurrentUrl());
//        driver.close();
//
//        driver.switchTo().window(Windows.get(0));
        windowMethods.switchToSpecificWindow(1);
        LoggerUtility.info("The user switches to a new window");
        windowMethods.closeCurrentWindow();
        LoggerUtility.info("The user closes the current window");
        windowMethods.switchToSpecificWindow(0);
        LoggerUtility.info("The user switches back tot the main window");
    }
}
