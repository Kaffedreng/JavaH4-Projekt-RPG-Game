/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hacknslash.randerstypen.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jan
 */
public class SQLWorker {
    
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/hacknslash";
    
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "admin";
    static Connection conn = null;
    public ArrayList<ArrayList<String>> ResultListOfLists = new ArrayList<ArrayList<String>>();
    
    public void SQLConn(){
        
        try {
        // Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        // Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        }
        catch (SQLException se){
            se.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Connected...");
    }
    
    public void SQLDisconnect(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQLWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Connection terminated...");
    }
    
    public void Load() {
    
    }
    
    public void Save() {
    
    }
}
 