/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hacknslash.randerstypen.SQL;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author jan
 */
public class SQLSelect extends SQLWorker {
    
    /**
     *
     * @param SQLStatement
     * @throws SQLException
     */
    public SQLSelect(String SQLStatement) throws SQLException{
        SQLConn();
        Statement stmt = null;
        ResultSet Result = null;
        
        System.out.println("Executing Statement...");
        stmt = conn.createStatement();
        Result = stmt.executeQuery(SQLStatement);
        
        while(Result.next()) {
            
            ArrayList<String> ResultList = new ArrayList<String>(Result.getMetaData().getColumnCount());
            int i = 1;
            while (i <= Result.getMetaData().getColumnCount()) {
                ResultList.add(Result.getString(i++));
            }
            
            ResultListOfLists.add(ResultList);
        }
        System.out.println("Statement Executed...");
        
        stmt.close();
        SQLDisconnect();
    }
}
