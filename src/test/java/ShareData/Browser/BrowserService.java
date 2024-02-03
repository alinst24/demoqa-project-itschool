package ShareData.Browser;

// Sa trateze o interfata ca si cum ar fi un serviciu      ;                               deci vrem sa avem 2 browsere , iar pt aman2 sa se respecte acelasi comportament (setam un comportament pentru fiecare browser)
public interface BrowserService {

    void openBrowser(Boolean cicd);
    void closeBrowser();
    Object prepareBrowserOptions(Boolean cicd);          // daca vrem sa apelam pentru un browser ca este chrome,edge sau firefox (ar fi trebuit sa facem 3 metode aici si fiecare metoda sa fie cu un tip diferit, dar nu putem face asa pentru ca daca facem metode abstracte intr-o interfata ne forteaza sa le implementam si atunci trebuie sa apelam la un obiect de tipul generic "Object")
                                             // cu chestia asta ce castigam : ex: in ChromeBrowserService , linia 34 am facut un public object si sus de tot in metoda in care o folosim i-am facut un "Cast" la linia 17 : Adica am apelat-o si am pus in paranteza ChromeOptions = tipul obiectului sa fie ChromeOptions
                            // si astfel, orice fel de obiect vrem sa ii dam acolo, nu trebuie sa ii specificam tipul in mod direct (ii spunem doar ca trebuie sa fie un obiect) si el mai departe stie sa se descurce(l-am generalizat)



}
