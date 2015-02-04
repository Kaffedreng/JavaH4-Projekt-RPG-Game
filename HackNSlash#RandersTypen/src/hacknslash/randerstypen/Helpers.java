/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hacknslash.randerstypen;

import java.util.Random;

/**
 *
 * @author jan
 */
public class Helpers {
    
    public static int RndInt(int i) {
        Random rand = new Random();
        return rand.nextInt(i);
    }
    
    public static boolean RndBool() {
        Random Rnd = new Random();
        return Rnd.nextBoolean();
    }
}
