package ShareData;

import PropertyUtility.PropertyUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;


//clasa utilizata pentru coceptul data driven testing . Conceptul acesta Hooks va avea rol sa construiasca toate componentele arhitecturii noastre (una dintre componente fiind driverul)
public class Hooks extends ShareData{

    public HashMap<String,String> testData;

    @BeforeMethod


    public void prepareEnvironment(){
        setup();
        String testName = this.getClass().getSimpleName();
        PropertyUtility propertyUtility = new PropertyUtility(testName);
        testData = propertyUtility.getAllData();                                    // logica care ar trebui sa ne scoata dinamic datele
    }

    @AfterMethod

    public void clearEnvironment(){
        clear();
    }
}
