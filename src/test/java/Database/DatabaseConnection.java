package Database;

import PropertyUtility.PropertyUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class DatabaseConnection {

    // Ca sa ne asiguram ca avem o singura instanta pe care sa o trimitem in toate testele, folosim conceptul Singleton:

    private static DatabaseConnection instance;
    private Connection connection;

    // facem un constructor privat pentru ca folosim conceptul de Singleton

    private DatabaseConnection(){        // in general constructorii sunt publici, dar acum il facem privat pentru a nu oferi posibilitatea din exterior sa se creeze mai multe instante
        createConnection();
    }

    // facem o metoda care sa construiasca interactiunea cu DB-ul

    private void createConnection(){
        PropertyUtility propertyUtility = new PropertyUtility("Database");
        HashMap<String,String> testData= propertyUtility.getAllData();
        String connectionURL = "jdbc:mysql://localhost:"+testData.get("port")+ "/"+testData.get("databasename")+"?allowPublicKeyRetrieval=true&useSSL=false";
        try {
            connection= DriverManager.getConnection(connectionURL,testData.get("username"),testData.get("password"));
        } catch (SQLException e) {
            System.out.println("There was a problem with database connection.");
        }
    }

    // Metoda care va face o singura instanta pentru Singleton:

    public static synchronized DatabaseConnection getInstance(){         // metoda statica , si astfel nu avem nevoie de o instanta ca sa o putem folosi
        if (instance==null){
            instance= new DatabaseConnection();
        }
        return instance;       // ca sa fie o singura instanta;      aceasta metoda ne asigura ca daca 10 teste folosesc db-ul si apeleaza aceasta metoda , doar un singur test intra pe acest if si restul nu mai intra pt ca instanta nu mai este nula.
    }

    public Connection getConnection() {
        return connection;
    }
}
