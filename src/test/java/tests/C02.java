package tests;

import org.junit.Assert;
import org.junit.Test;
import utilities.DButils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class C02 {

    //Yazili not ortalamasının 90dan kucuk oldugunu test edın


    @Test
    public void test01() throws SQLException {

        String hostName = "localhost";
        String dbName = "Databasetesting";
        String userName = "postgres";
        String password = "Ebrar14.255";

        DButils.connectionOlustur(hostName,dbName,userName,password);

        Statement st = DButils.statementOlustur();

        String query="select avg(yazili_notu) from ogrenciler;";

        ResultSet rs=st.executeQuery(query);
        rs.next(); // next ile ustunden atladigi degeri alacagindan dolayi once bu adimi yapmamiz gerekti.
        double ortalama = rs.getDouble(1);

        Assert.assertTrue(ortalama<90);

        DButils.connectionStatementKapatma();

    }
}
