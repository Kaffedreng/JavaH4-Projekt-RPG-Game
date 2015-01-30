/*;
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//#Randerstypen
package hacknslash.randerstypen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jan
 */
public class HackNSlashRandersTypen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Variabels
        
        boolean quitGame = false;
        
        //Welcome Message
        System.out.println("Welcome, dear player!");
        
        // Choose between a new game, loading a old game or exit the game
        do {
            System.out.println("Choose an option:");
            System.out.println("1. New game");
            System.out.println("2. Load game");
            System.out.println("3. Quit game");
            
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            
            int Choise = 0;
            
            // Read line and try to call parseInt on it.
	    String line = in.readLine();
	    int result;
	    try {
		result = Integer.parseInt(line);
	    } catch (NumberFormatException exception) {
		result = 0;
            }
            
            switch (result){
                case 1:  StartGame();
                         break;
                case 2:  LoadGame();
                         break;
                case 3:  quitGame = true;
                         break;
                default:
                         System.out.println("Your input is not valid! - Please try again.");
                         break;
            }
        } while (!quitGame);
        
    }
    
    private static void StartGame() {
        // Syntax needed
    }
    
    private static void LoadGame() {
        // Move to player class
    }
    
}
