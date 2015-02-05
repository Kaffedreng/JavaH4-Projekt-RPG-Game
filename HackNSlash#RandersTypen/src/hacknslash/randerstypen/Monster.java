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
public class Monster extends Entity {

    /**
     *
     * @param MapLevel
     */
    public Monster(int MapLevel) {
        this.EntityName = "Pikachu";
        this.Level = MapLevel + Helpers.RndInt(5);
        this.MaxHealth = this.Level * 10;
        MaxHealth();
    }
    
}
