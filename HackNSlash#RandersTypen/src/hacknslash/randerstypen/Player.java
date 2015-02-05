/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hacknslash.randerstypen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
     * @param Mana
     */
    public Player(String Name, String Level, String Experience, String MapLevel, String CurrPosition, String Health, String Mana) {
        this.EntityName = Name;
        this.Level = Integer.parseInt(Level);
        this.Exp = Integer.parseInt(Experience);
        this.MapLevel = Integer.parseInt(MapLevel);
        this.CurrPos = CurrPosition;
        this.Health = Integer.parseInt(Health);
        this.Mana = Integer.parseInt(Mana);
        this.MaxHealth = 10;
    }

    /**
     *
     * @returns Map Level
     */
    public int MapLevel() {
        return MapLevel;
    }
    
    /**
     *
     * @returns Last Position
     */
    public String LastPos() {
        return LastPos;
    }
    
    /**
     *
     * @returns Current Position
     */
    public String CurrPos() {
        return CurrPos;
    }
    
    /**
     * 
     * @returns AttackHeal (Regenerate x health)
     */
    public void RegenHealth() {
        AttackHeal();
    }

    /**
     * Sets new position and saves current as last position
     * 
     * @param NewPos
     */
    public void SetPos(String NewPos) {
        LastPos = CurrPos;
        CurrPos = NewPos;
    }

    /**
     * Gives experience
     * @param MapLevel Map Level
     */
    
    public void GiveExp(int MapLevel) {
        this.Exp = Exp + MapLevel * 25;
        if(this.Level * 100 <= this.Exp) {
            this.Level++;
            this.Exp = 0;
            this.MaxHealth++;
            System.out.println("Level up!");
        }
    }
    
    
    /**
     * Calculate damage depending on chosen attack style
     * @returns damage done to entity
     */
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
                
                int AttackStyle = 0;                
                String line = Helpers.Read();
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
                            Damage = SpecialAttack();
                            Attacking = true; 
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
    
    /**
     * Damage from Punch Style
     * @returns calculated damage
     */
    private int AttackPunch() {
        return Level * 20;
    }
    
    /**
     * Damage from Kick Style
     * @returns calculated damage
     */
    private int AttackKick() {
        return Level * Helpers.RndInt(35);
    }
    
    /**
     * Heal player
     * @returns 0 damage
     */
    private int AttackHeal() {
        if (Health != MaxHealth) {
            Health++;
        }
        // Return 0 because of 0 damage given when healing
        return 0;
    }
    
    /**
     * Damage from Special attack Style
     * @returns calculated damage
     */
    private int SpecialAttack() {
        Mana = Mana - 5;
        return Level * 100;
    }

    /**
     * Mana pool
     * @returns Mana
     */
    public int Mana() {
        return Mana;
    }

    /**
     * Counts MapLevel up so that a new level can be loaded
     */
    public void MapLevelUp() {
        MapLevel++;
    }

    public ArrayList<String> Save() {
        ArrayList<String> SaveArray = new ArrayList<>();
        
        SaveArray.add(EntityName);
        SaveArray.add(Integer.toString(Level));
        SaveArray.add(Integer.toString(Exp));
        SaveArray.add(Integer.toString(MapLevel));
        SaveArray.add(CurrPos);
        SaveArray.add(Integer.toString(Health));
        SaveArray.add(Integer.toString(Mana));
        
        return SaveArray;
    }
}
