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

    private DatabaseConnection(){
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

    public static synchronized DatabaseConnection getInstance(){
        if (instance==null){
            instance= new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
