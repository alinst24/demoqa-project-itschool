package Tests;

import ObjectData.WebTableObject;
import Pages.HomePage;
import Pages.Elements.WebTablePage;
import ShareData.ShareData;
import org.testng.annotations.Test;

public class WebtableTest extends ShareData {

    @Test
    public void testMetoda(){

        WebTableObject webTableObject = new WebTableObject(testData);


        HomePage homePage = new HomePage(getDriver());
        homePage.clickElements();

        WebTablePage webTablePage = new WebTablePage(getDriver());
        webTablePage.clickWebTables();
        //        // acum ar trebuii sa stim cate elemente avem deja in tabel  si facem o lista:          (pentru validare mai tarziu)            (dupa ce am identificat lista, luam dimensiunea listei)
        // iar ulterior facem o lista cu expectedEntries, dupa ce am adaugat randul


//        webTablePage.defaultTableSize();         // ca sa ia  cate randuri exista acum.
//        webTablePage.clickAdd();
               //pe astea le-am comentat pentru ca asa am facut eu prima data testul. A fost gandit altfel.


//        String firstnamevalue="Stanciu"; // mereu trebuie declarate deasupra pentru ca altfel nu le citeste
//        String prenume = "Alin-Georgian";
//        String emailvalue = "alinstanciu707@yahoo.com";
//        String varsta="25";
//        String salariuvaloare ="15000";
//        String departamentvaloare ="IT";


//        webTablePage.addnewEntry(firstnamevalue,prenume,emailvalue,varsta,salariuvaloare,departamentvaloare);
webTablePage.addnewEntry(webTableObject);
//        webTablePage.fillForm(firstnamevalue,prenume,emailvalue,varsta,salariuvaloare,departamentvaloare);
//        webTablePage.submitButton();
//        webTablePage.expectedTableSize();
//        webTablePage.lastEntryContent(firstnamevalue,prenume,emailvalue,varsta,salariuvaloare,departamentvaloare);










        // pentru a valida : trebuie sa tinem cont de ce avem initial = adica un tabel cu 3 randuri
        // trebuie sa indentificam toate randurile din tabel.   (continutul)
        // aflam cate randuri avem initial - in ctrl f ( cate avem si trebuie sa bagam +1 , pentru ca noi am mai introdus un rand)
        // o clasa pe css este cu "." si apoi valoarea , si ca sa cobori din elemente , folosim " >" : ex : .rt-tbody>div>div[....
        // si daca spre ex. avem un tabel cu 3 randuri populate si restul nu, trebuie sa gasim la cele populare un element care diferentiaza de cele nepopulate ; si folosim un xpath : ex : //div[@class='rt-body']/div/div[@class='rt-tr -odd' or @class='rt-rt -even']
        // aici sus am folosit in xpath "or" ca sa ne caute 2 clase diferite
        // un id este cu #
        // In schimb , in xpath o clasa este cu "@"


        // daca vrem sa coboram cate un rand in xpath (in ctrl-f) , folosim "/" , daca vrem sa sarim mai mult folosim "//"        ; EXEMPLU : //div[contains(@class,'ContWindow')]//input[@name='email']
        // EXEMPLU : //div[@id='card_grid']/div[@class='card-item card-standard js-product-data' or @class='card-item card-standard js-product-data js-card-ads-listing card-ads-listing']
        // Aici sus am identificat o multime de elemente si am mers sa gasim toate elementele din multime
        // Si spre exemplu daca vrem doar pe al doilea element dintr-o multime mai adaugam la final " [X] "
        // EXEMPLU : //div[@id='card_grid']/div[@class='card-item card-standard js-product-data' or @class='card-item card-standard js-product-data js-card-ads-listing card-ads-listing'][2]
        // Sau spre exemplu daca valorile au o un atribut(in cazul asta o clasa) care e aproape la fel, putem simplifica:  //div[@id='card_grid']/div[contains(@class,'card-item card-standard js-product-data')]
        // Alt exemplu : //ul[@class='dropdown-menu']/li[2]     (dintr-un drop-down sa selecteze a doua optiune)
        // Sau daca tratam ca pe o lista : " List x = driver.findElements....
        //                                   x.get(1).click().       , unde 1 = ordinea elementului


//        // assertequals = folosit pentru a compara 2 valori , exemplu string-uri
//        // assertTrue = folosit pentru a vedea daca conditia este falsa sau adevarata
//        // Mai este si assertfalse sau assertnull
//
//
//        // Daca am fi adaugat mai multe randuri in tabel , atunci nu ar mai fi mers cu get(actualTableSize), ci am fi folosit structuri repetitive:
//        // am fi facut un for , de cati vrem sa introducem si bucata aceea o puneam in for, iar afara aveam un index si o porneam de la 0, iar de fiecare data cand dadeam pe submit imi crestea indexul cu 1, iar la final nu faceam actualtablesize+1,
//        // ci actualTableSize + cat am calculat noi
    }
}
