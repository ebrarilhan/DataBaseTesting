package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DButils {

    //connection
    //statement
    //con ve statement kapatma

    private static Connection connection;
    private static Statement statement;





    //1. adim: connection olustur.
    public static Connection connectionOlustur(String hostName, String dataBaseIsmi, String userName, String password){

        //1. adim: drivera kaydol
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        //2. adim: connection olustur
        //url syntax:jdbc:postgresql://hostname:portnumber/databaseismi
        String url = "jdbc:postgresql://"+hostName+":5432/"+dataBaseIsmi;

        try {
            connection = DriverManager.getConnection(url,userName,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;

    }





    //2. adim: statement olustur.
    public static Statement statementOlustur(){

        try {
            statement=connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return statement;

    }





    //3. adim: connection ve statement kapatma
    public static void connectionStatementKapatma(){

        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
