package Pages.AlertFrameWindow;

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
        windowMethods.closeCurrentWindow();
        windowMethods.switchToSpecificWindow(0);

    }

    public void clickNewWindowButton(){
        newWindowButton.click();

//        List<String> Windows = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(Windows.get(1));
//
//        System.out.println("URL : "+ driver.getCurrentUrl());
//        driver.close();
//
//        driver.switchTo().window(Windows.get(0));
        windowMethods.switchToSpecificWindow(1);
        windowMethods.closeCurrentWindow();
        windowMethods.switchToSpecificWindow(0);

    }



}
