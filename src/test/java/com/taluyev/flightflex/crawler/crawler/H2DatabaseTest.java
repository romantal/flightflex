package com.taluyev.flightflex.crawler.crawler;

import org.junit.Test;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Roman_Taluiev on 10/18/2016.
 */
public class H2DatabaseTest {

    @Test
    public void dbTest() {

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //String url = "jdbc:h2:d:/sample.h2;IFEXISTS=TRUE";
        String url = "jdbc:h2:mem:test";

        try {
            DriverManager.getDriver(url);
            //DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //org.h2.Driver
    }

}
