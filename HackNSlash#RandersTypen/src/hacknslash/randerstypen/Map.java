/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hacknslash.randerstypen;

import hacknslash.randerstypen.File.FileWorker;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jan
 */
public class Map {
    ArrayList<ArrayList<String>> MapArray = null;
    public Map(int MapLevel) {
        
        MapArray = FileWorker.Load(MapLevel);
      
        //need file reader for this to work and some maps
        //magical stuff makes this work! now questions asked please...
    }
    
    public String Move(String CurrPoss) throws IOException {
        int y = 0;
        int x = 0;
        
        String[] XY = CurrPoss.split(",");
        x = Integer.parseInt(XY[0]);
        y = Integer.parseInt(XY[1]);
        
        int result;
        boolean Answer = false;
        String NewPoss = null;
        
        MapArray.get(x).set(y, "*");
        System.out.println();
        ArrayList<String> myPrint = new ArrayList<>();
        
        for(ArrayList<String> row : MapArray) {
            String myString = "";
            for(String myLetter : row) {
                   myString += myLetter; 
                }
            myPrint.add(myString);
        }
        for(String myString : myPrint) {
            System.out.println(myString);
        }
        
        do {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Your coordinates are: " + x + "," + y );

        boolean Down  = (!"#".equals(MapArray.get(x + 1).get(y)));
        boolean Up = (!"#".equals(MapArray.get(x - 1).get(y)));
        boolean Right = (!"#".equals(MapArray.get(x).get(y + 1)));
        boolean Left = (!"#".equals(MapArray.get(x).get(y - 1)));
        
        //print user optioens
        System.out.println((Up) ? "1. You can go up" : "1. You cannot go up");
        System.out.println((Down) ? "2. You can go down" : "2. You cannot go down");
        System.out.println((Left) ? "3. You can go left" : "3. You cannot go left");
        System.out.println((Right) ? "4. You can go right" : "4. You cannot go right");
        
        String line = in.readLine();
        
        try {
            result = Integer.parseInt(line);
        } catch (NumberFormatException exception) {
            result = 0;
        }
        
            switch (result){
                case 1:  System.out.print("Your coordinates are: " + x + "," + y );
                         if(Up){
                            Answer = true;
                            x--;
                            NewPoss = x + "," + y;
                         }
                         break;
                case 2:  System.out.print("Your coordinates are: " + x + "," + y );
                         if(Down){
                            x++;
                            Answer = true;
                            NewPoss = x + "," + y;
                         }
                         break;
                case 3:  System.out.print("Your coordinates are: " + x + "," + y );
                         if(Left){
                            y--;
                            Answer = true;
                            NewPoss = x + "," + y;
                         }
                         break;
                case 4:  System.out.print("Your coordinates are: " + x + "," + y );
                         if(Right){
                            y++;
                            Answer = true;
                            NewPoss = x + "," + y;
                         }
                         break;
                default:
                         System.out.println("Your input is not valid! - Please try again.");
                         break;
            }
        } while(!Answer);

       
        return NewPoss;
    }

    boolean HasChest(String CurrPos) {
        boolean MapCompleted = false;
        
        String[] XY = CurrPos.split(",");
        
        int x = Integer.parseInt(XY[0]);
        int y = Integer.parseInt(XY[1]);
        
        MapCompleted = ("c".equals(MapArray.get(x).get(y)));
        
        System.out.println("You have swag!");
        
        return MapCompleted;
    }
}
