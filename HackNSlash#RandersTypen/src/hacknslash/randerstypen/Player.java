/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hacknslash.randerstypen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jan
 */
public class Player extends Entity {
    int Regen;
    int Exp;
    boolean Combat;
    String CurrPos;
    String LastPos;
    int MapLevel;
    
    /**
     *
     * @param Name
     * @param Level
     * @param Experience
     * @param MapLevel
     * @param CurrPosition
     * @param Health
     */
    public Player(String Name, String Level, String Experience, String MapLevel, String CurrPosition, String Health) {
        this.EntityName = Name;
        this.Level = Integer.parseInt(Level);
        this.Exp = Integer.parseInt(Experience);
        this.MapLevel = Integer.parseInt(MapLevel);
        this.CurrPos = CurrPosition;
        this.Health = Integer.parseInt(Health);
    }
    public int MapLevel() {
        return MapLevel;
    }

    public String GetLastPos() {
        return LastPos;
    }
    
    public String LastPos() {
        return LastPos;
    }
    
    public String CurrPos() {
        return CurrPos;
    }

    void RegenHealth() {
        AttackHeal();
    }

    public void SetPos(String NewPos) {
        LastPos = CurrPos;
        CurrPos = NewPos;
    }

    void GiveExp(int MapLevel) {
        this.Exp = MapLevel * 25;
        if(this.Level * 100 < this.Exp) {
            this.Level = this.Level + 1;
            this.Exp = 0;
        }
    }
    
    private int DamageCalculator() throws IOException {
        
        boolean Attacking = false;
        int Damage = 0;
        
        //Welcome Message
        System.out.println("Welcome, dear player!");
        
        // Choose between a new game, loading a old game or exit the game
        do {
            System.out.println("Choose attack style:");
            System.out.println("1. Punch ");
            System.out.println("2. Kick");
            System.out.println("3. Heal");
            
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            
            int AttackStyle = 0;
            
            // Read line and try to call parseInt on it.
	    String line = in.readLine();
	    int result;
	    try {
		result = Integer.parseInt(line);
	    } catch (NumberFormatException exception) {
		result = 0;
            }
            
            switch (result){
                case 1:  Damage = AttackPunch();
                         Attacking = true;
                         break;
                case 2:  Damage = AttackKick();
                         Attacking = true;
                         break;
                case 3:  Damage = AttackHeal();
                         Attacking = true;
                         break;
                default:
                         System.out.println("Your input is not valid! - Please try again.");
                         break;
            }
        } while (!Attacking);
        
        return Damage;
        
    }
    
    private int AttackPunch() {
        return Level * 20;
    }
    
    private int AttackKick() {
        return Level * Helpers.RndInt(35);
    }
    
    private int AttackHeal() {
        Health = Health + (Level % MaxHealth * 10); 
        return 0;
    }
}
