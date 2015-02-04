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
public class Entity {
    //Variables
    int Health;
    int Damage;
    int Level;
    int MaxHealth;
    String EntityName;

    public void MaxHealth() {
        this.Health = MaxHealth;
    }
    
    public int Attack() {
        return DamageCalculator();
    }
    
    public int Health() {
        return Health;
    }
    
    public int Level() {
        return Level;
    }
    
    private int DamageCalculator() {
        return (Helpers.RndInt(Level));
    }

    void DamageTaken(int Damage) {
        Health = Health - Damage;
    }
    
}

