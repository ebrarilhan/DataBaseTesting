package tests;

import org.junit.Assert;
import org.junit.Test;
import utilities.DButils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class C01 {

    //ogrenciler tablosunda Merve Gul isimli ogrencinin oldugunu test edın


    @Test
    public void test01() throws SQLException {

        String hostName = "localhost";
        String dbName = "Databasetesting";
        String userName = "postgres";
        String password = "Ebrar14.255";


        //1.adım connection
        DButils.connectionOlustur(hostName,dbName,userName,password);

        //2.adım statement
        Statement st = DButils.statementOlustur();

        //3.adım query olustur
        String query="select isim from ogrenciler;";

        //4.adım query calıstır
        ResultSet rs=st.executeQuery(query);
        List<String> isimler=new ArrayList<>();

        while (rs.next()){
            isimler.add(rs.getString(1));
        }

        Assert.assertTrue(isimler.contains("Merve Gul"));

        DButils.connectionStatementKapatma();


    }
}
