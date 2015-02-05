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

/**
 *
 * @author jan
 */
public class Map {
    ArrayList<ArrayList<String>> MapArray = null;

    /**
     * Constructs the map from the FileWorker
     * @param MapLevel The map you want to load
     */
    public Map(int MapLevel) {
        MapArray = FileWorker.Load(MapLevel);
    }
    
    /**
     * Makes the user able to move around in the map.
     * @param CurrPoss Current position is used for checking valid moves
     * @return New position
     * @throws IOException
     */
    public String Move(String CurrPoss) throws IOException {
        int y = 0;
        int x = 0;
        
        String[] XY = CurrPoss.split(",");
        x = Integer.parseInt(XY[0]);
        y = Integer.parseInt(XY[1]);
        
        int result;
        boolean Answer = false;
        String NewPos = null;
        
        
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
            System.out.println("Your coordinates are: " + x + "," + y );

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
                case 1:  System.out.println("Your coordinates are: " + x + "," + y );
                         if(Up){
                            Answer = true;
                            x--;
                            NewPos = x + "," + y;
                         }
                         break;
                case 2:  System.out.println("Your coordinates are: " + x + "," + y );
                         if(Down){
                            x++;
                            Answer = true;
                            NewPos = x + "," + y;
                         }
                         break;
                case 3:  System.out.println("Your coordinates are: " + x + "," + y );
                         if(Left){
                            y--;
                            Answer = true;
                            NewPos = x + "," + y;
                         }
                         break;
                case 4:  System.out.println("Your coordinates are: " + x + "," + y );
                         if(Right){
                            y++;
                            Answer = true;
                            NewPos = x + "," + y;
                         }
                         break;
                default:
                         System.out.println("Your input is not valid! - Please try again.");
                         break;
            }
        } while(!Answer);
       
        return NewPos;
    }

    /**
     * Checks if the map is completed - only if the current position is a C
     * @param CurrPos The current position
     * @return bool for map completion
     */
    
    public boolean HasChest(String CurrPos) {
        boolean MapCompleted = false;
        
        String[] XY = CurrPos.split(",");
        
        int x = Integer.parseInt(XY[0]);
        int y = Integer.parseInt(XY[1]);
        
        MapCompleted = ("c".equals(MapArray.get(x).get(y)));
        
        if(MapCompleted) {
            System.out.println("You have completed this level!! - Congratulations...");
            Helpers.Separator();
        }
        
        return MapCompleted;
    }
    
    /**
     * Sets the X in the map (Represents player) and cleaning the old X
     * @param Position The position for new X
     * @param LastPosition The position for current X, that will be removed
     */
    public void SetStar(String Position, String LastPosition) {
        int OldY = 0;
        int OldX = 0;
        String[] OldXY = LastPosition.split(",");
        OldX = Integer.parseInt(OldXY[0]);
        OldY = Integer.parseInt(OldXY[1]);
        MapArray.get(OldX).set(OldY, " ");
        
        int y = 0;
        int x = 0;
        String[] XY = Position.split(",");
        x = Integer.parseInt(XY[0]);
        y = Integer.parseInt(XY[1]);
        MapArray.get(x).set(y, "X");
    }

    void PlaceC(String Position, String LastPosition) {
                int OldY = 0;
        int OldX = 0;
        String[] OldXY = LastPosition.split(",");
        OldX = Integer.parseInt(OldXY[0]);
        OldY = Integer.parseInt(OldXY[1]);
        MapArray.get(OldX).set(OldY, "c");
        
        int y = 0;
        int x = 0;
        String[] XY = Position.split(",");
        x = Integer.parseInt(XY[0]);
        y = Integer.parseInt(XY[1]);
        MapArray.get(x).set(y, "X");
    }
}
