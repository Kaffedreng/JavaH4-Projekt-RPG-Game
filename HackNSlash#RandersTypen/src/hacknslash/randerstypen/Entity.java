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
     *
     */
    public void MaxHealth() {
        this.Health = MaxHealth;
    }
    
    /**
     *
     * @return
     */
    public int Attack() {
        return DamageCalculator();
    }
    
    /**
     *
     * @return
     */
    public int Health() {
        return Health;
    }
    
    /**
     *
     * @return
     */
    public int Level() {
        return Level;
    }
    
    int DamageCalculator() {
        int Damage = Helpers.RndInt(Level + Helpers.RndInt(5));
        return Damage;
    }

    void DamageTaken(int Damage) {
        Health = Health - Damage;
    }
    
}

