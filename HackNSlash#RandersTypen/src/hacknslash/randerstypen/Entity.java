/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hacknslash.randerstypen;

/**
 *
 * @author jan
 */
public class Entity {
    //Variables
    int Health;
    int Damage;
    int Level;
    int MaxHealth;
    String EntityName;

    /**
     * Sets Maximum Health
     */
    public void MaxHealth() {
        this.Health = MaxHealth;
    }
    
    /**
     * Attack for entity
     * @returns Damage from damage calculator
     */
    public int Attack() {
        return DamageCalculator();
    }
    
    /**
     * Health pool
     * @returns health from either entity or player
     */
    public int Health() {
        return Health;
    }
    
    /**
     * Level
     * @returns level from either entity or player
     */
    public int Level() {
        return Level;
    }
    
    /**
     * Damage calculator for damage done to player from entity
     * @returns damage for entity
     */
    int DamageCalculator() {
        int Damage = Helpers.RndInt(Level + Helpers.RndInt(5));
        return Damage;
    }

    /**
     * Reduces health depending on damage done from either entity or player
     * @param Damage 
     */
    public void DamageTaken(int Damage) {
        Health = Health - Damage;
    }
}

