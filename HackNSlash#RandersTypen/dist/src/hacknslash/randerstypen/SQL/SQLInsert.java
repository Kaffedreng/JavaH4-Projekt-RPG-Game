/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hacknslash.randerstypen.SQL;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jan
 */
public class SQLInsert extends SQLWorker {

    /**
     * Creates a new user in SQL Database
     * @param SQLStatement
     * @throws SQLException
     */
    public SQLInsert(String SQLStatement) throws SQLException {
        SQLConn();
        Statement stmt = null;
        
        System.out.println("Executing Statement...");
        stmt = conn.createStatement();
        stmt.executeUpdate(SQLStatement);
        
        System.out.println("Statement Executed...");
        stmt.close();
        SQLDisconnect();
    }
    
    /**
     * Updates a user in SQL Database
     * @param SQLArray
     * @throws SQLException 
     */
    public SQLInsert(ArrayList<String> SQLArray) throws SQLException {
        SQLConn();
        Statement stmt = null;
        
        String SQLStatement = "INSERT INTO players (Name, Level, Experience, MapLevel, CurrentPosition, Health, Mana) VALUES ('" + 
                SQLArray.get(0) + "'," + 
                SQLArray.get(1) + "," + 
                SQLArray.get(2) + "," + 
                SQLArray.get(3) + ",'" + 
                SQLArray.get(4) + "'," + 
                SQLArray.get(5) + "," + 
                SQLArray.get(6) + ") " +
                "ON DUPLICATE KEY UPDATE " +
                "Level = " + SQLArray.get(1) + "," + 
                "Experience = " + SQLArray.get(2) + "," + 
                "MapLevel = " + SQLArray.get(3) + "," + 
                "CurrentPosition = '" + SQLArray.get(4) + "'," + 
                "Health = " + SQLArray.get(5) + "," + 
                "Mana = " + SQLArray.get(6) + ";";
        
        System.out.println("Executing Statement...");
        stmt = conn.createStatement();
        stmt.executeUpdate(SQLStatement);
        
        System.out.println("Statement Executed...");
        stmt.close();
        SQLDisconnect();
    }
    
}
