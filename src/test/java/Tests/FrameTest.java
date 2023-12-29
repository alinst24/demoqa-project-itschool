package Tests;

import Pages.AlertFrameWindow.AlertFrameWindowPage;
import Pages.AlertFrameWindow.FramesPage;
import Pages.HomePage;
import org.testng.annotations.Test;
import ShareData.Hooks;

public class FrameTest extends ShareData.Hooks {

    @Test
    public void testMetoda() {

        // Frame si iFrame-uri ; Frame = intreaga pagina pe care o vedem ; iar iFrame-uri = pagini mici in pagina mare
        // Deci ca sa interactionam cu anumite elemente trebuie sa ne mutam cu focusul
        // Si pot fi astfel de frame-uri mascate pe unele site-uri
        // le putem identifica dupa tag-ul "<iframe"      ; il putem identifica dupa id cel mai des, dar daca nu avem id , cautam un alt atribut , sub forma de locater

        HomePage homePage = new HomePage(getDriver());
        homePage.clickAlertWindow();

        AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(getDriver());
        alertFrameWindowPage.clickFrames();

        FramesPage framesPage = new FramesPage(getDriver());
        framesPage.interractFrame1();
        framesPage.interractFrame2();
    }
}
