package ShareData.Browser;

import PropertyUtility.PropertyUtility;

import java.util.HashMap;

public class BaseBrowserService {

    // o logica comuna , ca toate serviciile de browser sa aiba acelasi set de date

    public HashMap<String,String> getBrowserOptions(){           // citim proprietatile si le scoatem intr-un hashmap
        PropertyUtility propertyUtility = new PropertyUtility("Browser");
        return propertyUtility.getAllData();        //citim proprietatea si returnam rezultatul

    }
}
