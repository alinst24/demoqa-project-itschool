package ShareData.Browser;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class BrowserFactory {

    // Facem o metoda care sa citeasca valorile unor variabile de sistem din pom.xml
    // Pe baza acestor valori vom lua o decizie in functie de environmentul pe care se ruleaza testele automate

    public WebDriver getBrowserDriver(){
        Boolean cicd = Boolean.parseBoolean(System.getProperty("cicd"));
        String browser = null;

        //Trebuie sa decidem care este tipul de browser in momentul cand rulam pe local si remote
        //Daca este pe REMOTE trebuie sa citeasca valoarea din pom.xml
        // Daca este pe LOCAL trebuie sa citeasca valoarea din BrowserData.properties
        if (cicd){
            browser = System.getProperty("browser");
        }
        else {
            HashMap<String,String> testData = new BaseBrowserService().getBrowserOptions();
            browser = testData.get("browser");
        }
        // Facem un switch case care sa decida ce browser sa se initializeze
        // Aplicam design pattern-ul de tip "Creational" cu numele Factory Method

        switch(browser){
            case "chrome":
                ChromeBrowserService chromeBrowserService = new ChromeBrowserService();
                chromeBrowserService.openBrowser(cicd);
                return chromeBrowserService.getDriver();
            case "edge":
                EdgeBrowserService edgeBrowserService = new EdgeBrowserService();
                edgeBrowserService.openBrowser(cicd);
                return  edgeBrowserService.getDriver();
        }
        return null;
    }
}
