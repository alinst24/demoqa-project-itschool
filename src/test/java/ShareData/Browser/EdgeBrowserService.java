package ShareData.Browser;

import PropertyUtility.PropertyUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.HashMap;

public class EdgeBrowserService extends BaseBrowserService implements BrowserService {

    private WebDriver driver;

    @Override
    public void openBrowser() {

    }

    @Override
    public void closeBrowser() {

    }

    @Override
    public Object prepareBrowserOptions() {
//        PropertyUtility propertyUtility = new PropertyUtility("Browser");
        HashMap<String,String> testData = getBrowserOptions();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments(testData.get("headless"));
        edgeOptions.addArguments(testData.get("gpu"));
        edgeOptions.addArguments(testData.get("infobars"));
        edgeOptions.addArguments(testData.get("sandbox"));
        edgeOptions.addArguments(testData.get("resolution"));
        return edgeOptions;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
