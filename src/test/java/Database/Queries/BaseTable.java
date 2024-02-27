package Database.Queries;

import Database.DatabaseConnection;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTable {

    public DatabaseConnection databaseConnection;
    public BaseTable(){
        databaseConnection=DatabaseConnection.getInstance();
    }

    // Metoda care ne returneaza timpul curent de executie:

    public synchronized String getCurrentDate(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss");
        return currentDateTime.format(formatter);
    }
}
