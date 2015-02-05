/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hacknslash.randerstypen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

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
    int Mana;
    
    /**
     *
     * @param Name
     * @param Level
     * @param Experience
     * @param MapLevel
     * @param CurrPosition
     * @param Health
     */
    public Player(String Name, String Level, String Experience, String MapLevel, String CurrPosition, String Health, String Mana) {
        this.EntityName = Name;
        this.Level = Integer.parseInt(Level);
        this.Exp = Integer.parseInt(Experience);
        this.MapLevel = Integer.parseInt(MapLevel);
        this.CurrPos = CurrPosition;
        this.Health = Integer.parseInt(Health);
        this.Mana = Integer.parseInt(Mana);
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
    
     @Override
     int DamageCalculator() {
        
        boolean Attacking = false;
        int Damage = 0;
        
        // Choose between a new game, loading a old game or exit the game
        do {
	    try {
                System.out.println("Choose attack style:");
                System.out.println("1. Punch ");
                System.out.println("2. Kick");
                System.out.println("3. Heal");
                if(Mana >= 5) {
                    System.out.println("4. Magic");
                }
                
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
                    case 4:  if (Mana >= 5) { 
                            System.out.println("BITCH MODE ACTIVATED!!!!");
                            Damage = SpecialAttack();
                            Attacking = true; 
                            System.out.println("BITCHING IS DONE!!!!");
                        }
                        break;
                    default:
                        System.out.println("Your input is not valid! - Please try again.");
                        break;
                }
            } catch (IOException ex) {
		Logger.getLogger(Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        } while (!Attacking);
        
        Mana++;
        return Damage;
    }
    
    private int AttackPunch() {
        return Level * 20;
    }
    
    private int AttackKick() {
        return Level * Helpers.RndInt(35);
    }
    
    private int AttackHeal() {
        Health = Health + 1;
        return 0;
    }

    private int SpecialAttack() {
        Mana = Mana - 5;
        return Level * 100;
    }

    public int Mana() {
        return Mana;
    }

    void MapLevelUp() {
        MapLevel++;
    }
}
