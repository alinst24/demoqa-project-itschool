package Tests;

import Pages.AlertFrameWindow.AlertFrameWindowPage;
import Pages.AlertFrameWindow.BrowserWindowsPage;
import Pages.HomePage;
import ShareData.ShareData;
import org.testng.annotations.Test;

public class WindowTest extends ShareData {

    @Test
    public void testMetoda() {

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.clickBrowserWindows();

        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(getDriver());
        browserWindowsPage.clickNewTabButton();
        browserWindowsPage.clickNewWindowButton();
    }
}
