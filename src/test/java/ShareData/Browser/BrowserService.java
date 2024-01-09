package ShareData.Browser;

// Sa trateze o interfata ca si cum ar fi un serviciu      ;                               deci vrem sa avem 2 browsere , iar pt aman2 sa se respecte acelasi comportament (setam un comportament pentru fiecare browser)
public interface BrowserService {

    void openBrowser(Boolean cicd);
    void closeBrowser();
    Object prepareBrowserOptions(Boolean cicd);



}
