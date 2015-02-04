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
        ArrayList<ArrayList<String>> MapArray = new ArrayList<>();
        ArrayList<String> Lines = null;
        try {
            Lines = (ArrayList<String>) Files.readAllLines(Paths.get("C:/HackAndSlashMap/map2.txt"));
        } catch (IOException ex) {
            Logger.getLogger(FileWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        for (String Line : Lines) {
            System.out.println(Line);
            ArrayList<String> row = new ArrayList<>(Line.length());
            for(String MyChar : Line.split("")) {
                row.add(MyChar);
            }
            MapArray.add(row);
        }
        return MapArray;
    
    }
}

