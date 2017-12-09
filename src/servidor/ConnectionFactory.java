/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sqlitetutorial.net
 */
public class ConnectionFactory {

    public static Connection conn = null;

    public static Connection getConnection() {

        //memory
        try {
            // db parameters
            String url = "jdbc:postgresql://localhost:5432/porrinha";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "123456");
            props.setProperty("ssl", "true");

            //String url = "jdbc:sqlite:memory";
            // create a connection to the database
            conn = DriverManager.getConnection(url,props);

            System.out.println("Connection to SQLite has been established.");

            return conn;

        } catch (SQLException e) {
            System.out.println(e.getMessage());

            return null;
        } 
    }

}
