/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hacknslash.randerstypen.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jan
 */
public class FileWorker {
    
    public static ArrayList<ArrayList<String>> Load(int MapLevel) {
        ArrayList MapList = null;
        
        try {
            for(String line : Files.readAllLines(Paths.get("maps/map2.txt"))) {
                ArrayList row = null;
                
                for(int i = 0; i <= line.length(); i++) {
                    row.add(line.charAt(i));
                }
                MapList.add(row);
            }
        } catch (IOException ex) {
            Logger.getLogger(FileWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return MapList;
    }
}

