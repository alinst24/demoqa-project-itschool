package Database.Queries;

import ObjectData.WebTableObject;

import java.sql.SQLException;
import java.sql.Statement;

public class WebTable extends BaseTable{

    // In aceasta clasa vom defini diferite Queries pe care sa le executam pe acest tabel(webtable)

    public synchronized void insertWebTableData(WebTableObject webTableObject){  // am pus synchronized ca atunci cand mai multe teste apeleaza aceasta metoda in acelasi timp sa nu se incurce si datele sa fie tinute pe fiecare thread
        try {
            // Ca sa facem un INSERT avem nevoie de un obiect de tipul "statement"
            Statement statement = databaseConnection.getConnection().createStatement();
            String query = "insert into WebTable (firstnamevalue,prenume,emailvalue,varsta,salariuvaloare,departamentvaloare,entrydate)\n" +
                    "values('" + webTableObject.getFirstnamevalue() + "','" + webTableObject.getPrenume() + "','" + webTableObject.getEmailvalue() + "','" + webTableObject.getVarsta() + "','" + webTableObject.getSalariuvaloare() + "','" + webTableObject.getDepartamentvaloare() + "','" + getCurrentDate() + "');";
            statement.execute(query);
        }
        catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
    }
}
