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

    public Entity(int MapLevel) {
        this.EntityName = "Pikachu";
        this.Level = MapLevel + Rnd();
        this.MaxHealth = this.Level * 10;
        MaxHealth();
    }
    
    public static int Rnd(int i) {
        Random rand = new Random();
        return rand.nextInt(i);
    }
    
    public void MaxHealth() {
        this.Health = MaxHealth;
    }
    
    public int Attack() {
        DamageCalculator();
        return 0;
    }
    
    public int Health() {
        return Health;
    }
    
    public int Level() {
        return Level;
    }
    
    private int DamageCalculator() {
        return 0;
    }

    void DamageTaken(int Damage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int Rnd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

