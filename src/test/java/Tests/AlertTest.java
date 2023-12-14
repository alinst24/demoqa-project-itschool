package Tests;

import ObjectData.AlertObject;
import Pages.AlertFrameWindow.AlertFrameWindowPage;
import Pages.AlertFrameWindow.AlertPage;
import Pages.HomePage;
import ShareData.ShareData;
import org.testng.annotations.Test;

public class AlertTest extends ShareData {

    @Test
    public void testMetoda() {

        AlertObject alertObject = new AlertObject(testData);


        HomePage homePage = new HomePage(getDriver());             // in fiecare pagina facem un obiect , si pe acel obiect apelam metoda specifica. ; deci dupa fiecare metoda de test facuta , venim in pagina curenta si facem obiect si chemam metoda
        homePage.clickAlertFrameWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.clickAlerts();

        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.interractAlertOk();
        alertPage.interractAlertDelay();
        alertPage.interractAlertDismiss();
        alertPage.interractAlertValue(alertObject);
    }
}
