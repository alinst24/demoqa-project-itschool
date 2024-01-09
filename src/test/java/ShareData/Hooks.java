package ShareData;

import Logger.LoggerUtility;
import PropertyUtility.PropertyUtility;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;


//clasa utilizata pentru coceptul data driven testing . Conceptul acesta Hooks va avea rol sa construiasca toate componentele arhitecturii noastre (una dintre componente fiind driverul)
public class Hooks extends ShareData{      // va avea ca rol sa aduca impreuna toate componentele arhitecturii noastre

    public HashMap<String,String> testData;

    public String testName;

    @BeforeMethod
    public void prepareEnvironment(){
        testName = this.getClass().getSimpleName();
        PropertyUtility propertyUtility = new PropertyUtility(testName);
        testData = propertyUtility.getAllData();                                    // logica care ar trebui sa ne scoata dinamic datele
        LoggerUtility.startTestCase(testName);                        //in mod normal faceam obiect ,dar am facut static si avem metodele
                                                                       // deci apelam metoda STATICA pentru log-uri , nu avem nevoie de obiect
        setup();                   //apare metoda de setup fiindca avem extends ShareData
    }

    @AfterMethod
    public void clearEnvironment(ITestResult result){    // itresult result este un listener care atunci cand il definim la nivel de parametru intr-o metoda adnotata cu after , are ca rol sa vegheze asupra test result-ului nostru(statusul testului)
        if (result.getStatus()==ITestResult.FAILURE){
            LoggerUtility.error(result.getThrowable().getMessage());   //getThrowable = ne scoate ce exceptie ne-a dat.  ;
        }
        else {
            clear();    // tot asa, apare clear fiindca avem extends ShareData
            LoggerUtility.endTestCase(testName);

            //adaugam un listener pe statusul testului pentru a ne ajuta sa printam in log-uri eroare daca apare
        }
    }

    // Ne trebuie un after suite pentru ca dupa ce s-au terminat de executat testele trebuie sa cheme metoda de merge
    @AfterSuite
    public void finishArtifacts(){
        LoggerUtility.mergeLogsIntoOne();
    }
}
