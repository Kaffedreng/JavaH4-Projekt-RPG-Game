/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hacknslash.randerstypen;

import hacknslash.randerstypen.SQL.SQLSelect;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Random;

/**
 *
 * @author jan
 */
public class Helpers {
    
    /**
     * Calculates a number for i that is used in various methods in the game
     * @param i
     * @returns i
     */
    public static int RndInt(int i) {
        Random rand = new Random();
        return rand.nextInt(i);
    }
    
    /**
     * Read line made easy.. 
     * E.g. String X = Helpers.Read();
     * @returns user input from console
     * @throws IOException 
     */
    public static String Read() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        return in.readLine();
    }
    
    /**
     * Calculates a random number (0,1) that is used in various methods in the game
     * @returns randomly 0 or 1
     */
    public static boolean RndBool() {
        Random Rnd = new Random();
        return Rnd.nextBoolean();
    }
    
    /**
     * Clears view in the console by 25 white spaces
     */
    public static void Clean() {
        for(int i = 0; i <= 25; i++) {
            System.out.println();
        }
    }
    
    /**
     * Sets a separator for visual goods
     */
    public static void Separator() {
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println();
    }
    
        
    /**
     * Checks if username exists in database
     * @param Username
     * @return true if username is available
     * @throws SQLException 
     */
    public static boolean CheckUsername(String Username) throws SQLException {
        boolean UsernameAvailable = false;

        System.out.println("Choose a username:");

        String SQLStatement_Check = "SELECT Name FROM players WHERE Name='" + Username + "' LIMIT 1;";
        SQLSelect SQLReturn = new SQLSelect(SQLStatement_Check);
        UsernameAvailable = (SQLReturn.ResultListOfLists.size() < 1 );
        
        return UsernameAvailable;
    }
}
