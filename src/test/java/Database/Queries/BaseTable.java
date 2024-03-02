package Database.Queries;

import Database.DatabaseConnection;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTable {

    public DatabaseConnection databaseConnection;
    public BaseTable(){
        databaseConnection=DatabaseConnection.getInstance();
    }    // toate testele care vor trece prin aceasta clasa vor apela acest constructor si primul test care trece face conexiunea iar celelalte folosesc aceeasi conexiune

    // Metoda care ne returneaza timpul curent de executie:           // sa stim cand se ruleaza testul , ca daca tot o sa bagam date sa stim care date au fost introduse

    public synchronized String getCurrentDate(){        // synchronized aici pt ca daca mai multe metode apeleaza timpul curent , cumva sa le diferentieze (sa stie pe care sa il aleaga)
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss");
        return currentDateTime.format(formatter);
    }
}
