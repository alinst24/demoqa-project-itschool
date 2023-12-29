package Tests;

import ObjectData.AlertObject;
import Pages.AlertFrameWindow.AlertFrameWindowPage;
import Pages.AlertFrameWindow.AlertPage;
import Pages.HomePage;
import ShareData.Hooks;
import org.testng.annotations.Test;

public class AlertTest extends Hooks {

    @Test
    public void testMetoda() {

        AlertObject alertObject = new AlertObject(testData);


        HomePage homePage = new HomePage(getDriver());             // in fiecare pagina facem un obiect , si pe acel obiect apelam metoda specifica. ; deci dupa fiecare metoda de test facuta , venim in pagina curenta si facem obiect si chemam metoda
        homePage.clickAlertWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.clickAlerts();

        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.interractAlertOk();
        alertPage.interractAlertDelay();
        alertPage.interractAlertDismiss();
        alertPage.interractAlertValue(alertObject);
    }
}
