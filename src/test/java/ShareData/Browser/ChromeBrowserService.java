package ShareData.Browser;

import Logger.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;

public class ChromeBrowserService extends BaseBrowserService implements BrowserService{

    private WebDriver driver;

    @Override
    public void openBrowser(Boolean cicd) {
        ChromeOptions chromeOptions = (ChromeOptions) prepareBrowserOptions(cicd);
        driver = new ChromeDriver(chromeOptions);
        driver.get(getBrowserOptions().get("url"));
//        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoggerUtility.info("The browser was opened with succes.");

    }

    @Override
    public void closeBrowser() {
        driver.quit();
        LoggerUtility.info("The browser was closed with succes.");
    }

    @Override
    public Object prepareBrowserOptions(Boolean cicd) {
//        PropertyUtility propertyUtility = new PropertyUtility("Browser");
        HashMap<String,String> testData = getBrowserOptions();
        ChromeOptions chromeOptions = new ChromeOptions();      //acesta este un obiect specific de chrome care ne da posibilitatea sa-i specificam la instanta de driver ca vrem sa avem un browser cu anumite proprietati(cele din fisierul .properties)
        if (cicd){
            chromeOptions.addArguments("--headless");
        }
        if (!testData.get("headless").isEmpty()){
            chromeOptions.addArguments(testData.get("headless"));
        }
        chromeOptions.addArguments(testData.get("gpu")); // addArguments = metoda care seteaza o anumita proprietate in functie de ce optiune vrem sa contina browserul
        chromeOptions.addArguments(testData.get("infobars"));
        chromeOptions.addArguments(testData.get("sandbox"));
        chromeOptions.addArguments(testData.get("resolution"));
        return chromeOptions;       // ca sa returneze optiunile de chrome     ;         deci cand o sa avem nevoie sa facem modficari la serviciul de chrome vom lucra doar in aceasta clasa
    }

    public WebDriver getDriver() {
        return driver;
    }
}
