package Tests;

import Pages.AlertFrameWindow.AlertFrameWindowPage;
import Pages.AlertFrameWindow.BrowserWindowsPage;
import Pages.HomePage;
import ShareData.Hooks;
import org.testng.annotations.Test;

public class WindowTest extends Hooks {

    @Test
    public void testMetoda() {

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.clickBrowserWindows();

        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(getDriver());
        browserWindowsPage.clickNewTabButton();
        browserWindowsPage.clickNewWindowButton();
    }
}
